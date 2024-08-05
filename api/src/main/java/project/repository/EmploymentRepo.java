package project.repository;

import entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmploymentRepo extends JpaRepository<JobPost, Integer> {
    JobPost getJobPostByNo(int no);
    JobPost deleteByNo(int no);

    List<JobPost> findAllByNo(int companyNo);
}
