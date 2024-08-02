package project.service;

import entity.Company;
import entity.JobPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.dto.JobPostForm;
import project.repository.EmploymentRepo;

@Service
@RequiredArgsConstructor
public class EmploymentService {
    private final EmploymentRepo employmentRepo;

    public JobPost addPost(JobPostForm form) {
        form.checkForm();
        JobPost post = new JobPost(form.getTitle(), form.getCareer(), form.getDegree(), form.getSalary(), form.getDetail()
                    ,form.getEndDate(), form.getCompanyNo());

        return employmentRepo.save(post);
    }

}
