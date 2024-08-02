package project.controller;

import entity.Company;
import entity.JobPost;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.dto.JobPostDetail;
import project.dto.JobPostForm;
import project.service.CompanyService;
import project.service.EmploymentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employment")
public class EmploymentController {

    private final EmploymentService emplService;
    private final CompanyService companyService;

    @PostMapping("/job-post")
    public JobPostDetail addJobPost(@ModelAttribute JobPostForm form) {
        System.out.println("test" + form.getCompanyNo());

        JobPost jobPost = emplService.addPost(form);
        Company company = companyService.getCompany(form.getCompanyNo());

        return new JobPostDetail(jobPost.getTitle(), jobPost.getCareer(), jobPost.getDegree(), jobPost.getSalary(), jobPost.getDetail()
                                , jobPost.getEndDate(), company.getName(), company.getHomePage(), company.getAddress());
    }

}
