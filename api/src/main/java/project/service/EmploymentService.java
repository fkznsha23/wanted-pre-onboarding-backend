package project.service;

import entity.Company;
import entity.JobPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.dto.JobPostDetail;
import project.dto.JobPostForm;
import project.dto.JobPostModifyForm;
import project.dto.JobSimplePost;
import project.repository.CompanyRepo;
import project.repository.EmploymentRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmploymentService {
    private final EmploymentRepo employmentRepo;
    private final CompanyRepo companyRepo;

    public JobPost addPost(JobPostForm form) {
        form.checkForm();
        JobPost post = new JobPost(form.getTitle(), form.getPosition(), form.getCareer(), form.getDegree(), form.getSalary(), form.getDetail()
                    ,form.getEndDate(), form.getCompanyNo());

        return employmentRepo.save(post);
    }

    public JobPost getPost(int postNo) {
        Optional<JobPost> opPost = employmentRepo.findById(postNo);

        if(opPost.isEmpty()){
            throw new RuntimeException("조회된 채용공고가 존재하지 않습니다.");
        }

        return opPost.get();
    }

    public JobPost removePost(int postNo) {
        JobPost post = employmentRepo.deleteByNo(postNo);
        if(post == null) {
            throw new RuntimeException("삭제할 채용공고가 존재하지 않습니다.");
        }

        return post;
    }

    public void removeAllPost() {
        employmentRepo.deleteAll();
    }

    public JobPost updateJobPost(JobPostModifyForm modifyForm) {
        try {
            JobPost modifyPost = getPost(modifyForm.getNo());
            modifyPost.modifyJobPost(modifyForm.getTitle(), modifyForm.getPosition(), modifyForm.getCareer(), modifyForm.getDegree(), modifyForm.getSalary()
                    , modifyForm.getDetail(), modifyForm.getEndDate());

            return employmentRepo.save(modifyPost);
        }catch (RuntimeException ex) {
            throw new RuntimeException("수정할 채용공고가 존재하지 않습니다.");
        }
    }

    public List<JobPost> getAllJobPost() {
        List<JobPost> postList = employmentRepo.findAll();
        if(postList.isEmpty()){
            throw new RuntimeException("조회된 채용공고가 존재하지 않습니다.");
        }

        return postList;
    }

    public List<JobPost> getAllJobPostByCompanyNo(int companyNo) {
        return employmentRepo.findAllByNo(companyNo);
    }

    public List<CompletableFuture<JobSimplePost>> changeSimplePost(List<JobPost> postList) {
        List<CompletableFuture<JobSimplePost>> list = new ArrayList<>();
        for(JobPost post : postList) {
            list.add(CompletableFuture.supplyAsync(() -> asyncChangeSimplePost(post)));
        }

        return list;
    }

    // 비동기 메서드 : 다수의 JobPost를 비동기를 이용해 JobSimplePost로 변환
    private JobSimplePost asyncChangeSimplePost(JobPost post) {
        Company company = companyRepo.getCompanyByNo(post.getCompanyNo());
        return new JobSimplePost(post.getTitle(), company.getName(), post.getCareer(), company.getAddress(), post.getPosition(), post.getDegree());
    }

    // 비동기 메서드
    public CompletableFuture<List<JobSimplePost>> changeAsync(List<CompletableFuture<JobSimplePost>> complList) {
        CompletableFuture<?>[] complArray = complList.toArray(new CompletableFuture[0]);
        return CompletableFuture.allOf(complArray).thenApply(i -> complList.stream().map(CompletableFuture::join).collect(Collectors.toList()));
    }

    public JobPost getJobPostByNo(int no) {
        Optional<JobPost> OptionalPost = employmentRepo.findById(no);
        if(OptionalPost.isEmpty()) {
            throw new RuntimeException("해당 채용공고의 상세 페이지는 존재하지 않습니다.");
        }

        return OptionalPost.get();
    }

    public JobPostDetail createJobPostDetail(JobPost post) {
        Company company = companyRepo.getCompanyByNo(post.getCompanyNo());

        return new JobPostDetail(post.getNo(), post.getTitle(), post.getPosition(), post.getCareer(), post.getDegree(), post.getSalary(), post.getDetail(), post.getEndDate()
                ,company.getName(), company.getHomePage(), company.getAddress());
    }
}
