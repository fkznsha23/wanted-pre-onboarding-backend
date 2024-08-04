package project.controller;

import entity.Company;
import entity.JobPost;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.dto.JobPostDetail;
import project.dto.JobPostForm;
import project.dto.JobPostModifyForm;
import project.dto.JobSimplePost;
import project.service.CompanyService;
import project.service.EmploymentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employment")
public class EmploymentController {

    private final EmploymentService emplService;
    private final CompanyService companyService;

    @PostMapping("/job-post")
    public JobPostDetail addJobPost(@ModelAttribute JobPostForm form) {
        JobPost jobPost = emplService.addPost(form);
        Company company = companyService.getCompany(form.getCompanyNo());

        return new JobPostDetail(jobPost.getNo(), jobPost.getTitle(), jobPost.getPosition(), jobPost.getCareer(), jobPost.getDegree(), jobPost.getSalary(), jobPost.getDetail()
                                , jobPost.getEndDate(), company.getName(), company.getHomePage(), company.getAddress());
    }

    @DeleteMapping("/all-job-post")
    public void allRemoveJobPost(){
        emplService.removeAllPost();
    }

    @DeleteMapping("/job-post")
    public List<JobSimplePost> removeJobPost(int postNo){
        JobPost post = emplService.removePost(postNo);

        return emplService.getPostByCompanyNo(post.getCompanyNo());
    }

    @PutMapping("/job-post")
    public JobPostDetail updateJobPost(@ModelAttribute JobPostModifyForm form) {
        JobPost modifyPost = emplService.updateJobPost(form);
        Company company = companyService.getCompany(modifyPost.getCompanyNo());

        System.out.println("test" + modifyPost.getTitle());

        return new JobPostDetail(modifyPost.getNo(), modifyPost.getTitle(), modifyPost.getPosition(), modifyPost.getCareer(), modifyPost.getDegree(), modifyPost.getSalary()
                                , modifyPost.getDetail(), modifyPost.getEndDate(), company.getName(), company.getHomePage(), company.getAddress());
    }

}
