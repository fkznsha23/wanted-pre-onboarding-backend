package project.repository;

import entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmploymentRepo extends JpaRepository<JobPost, Integer>, RepoInter {

}
