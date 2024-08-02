package project.service;

import entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.repository.CompanyRepo;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepo companyRepo;

    public Company getCompany(int companyNo) {
        Company company = companyRepo.getCompanyByNo(companyNo);

        if(company == null) {
            throw new RuntimeException("조회된 회사가 존재하지 않습니다.");
        }

        return company;
    }
}
