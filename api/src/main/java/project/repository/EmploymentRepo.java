package project.repository;

import entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentRepo extends JpaRepository<JobPost, Integer> {

    JobPost getJobPostByNo(int no);
}
