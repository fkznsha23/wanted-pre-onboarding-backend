package project.repository;

import entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmploymentRepo extends JpaRepository<JobPost, Integer> {
    JobPost deleteByNo(int no);

    List<JobPost> findAllByNo(int companyNo);

    List<JobPost> findAllByTitleLike(String word);
}
