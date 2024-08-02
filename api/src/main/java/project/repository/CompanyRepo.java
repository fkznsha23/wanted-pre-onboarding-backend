package project.repository;

import entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Integer> {
    public Company getCompanyByNo(int no);
}
