package project.service;

import entity.JobPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.dto.JobPostDetail;
import project.dto.JobPostForm;
import project.dto.JobPostModifyForm;
import project.dto.JobSimplePost;
import project.repository.EmploymentRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmploymentService {
    private final EmploymentRepo employmentRepo;

    public JobPost addPost(JobPostForm form) {
        form.checkForm();
        JobPost post = new JobPost(form.getTitle(), form.getPosition(), form.getCareer(), form.getDegree(), form.getSalary(), form.getDetail()
                    ,form.getEndDate(), form.getCompanyNo());

        return employmentRepo.save(post);
    }

    public JobPost getPost(int postNo) {
        JobPost post = employmentRepo.getJobPostByNo(postNo);

        if(post == null){
            throw new RuntimeException("조회된 채용공고가 존재하지 않습니다.");
        }

        return post;
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
        List<JobPost> postList = employmentRepo.getAllJobPost();
        if(postList.isEmpty()){
            throw new RuntimeException("조회된 채용공고가 존재하지 않습니다.");
        }

        return postList;
    }

    public List<JobPost> getAllJobPostByCompanyNo(int companyNo) {

        return null;
    }
}
