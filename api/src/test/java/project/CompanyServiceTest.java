package project;

import entity.Company;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import project.repository.CompanyRepo;
import project.service.CompanyService;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {

    @Mock
    CompanyRepo companyRepo;

    @InjectMocks
    CompanyService companyService;

    @Test
    public void 회사_조회_성공_테스트() {
        companyService.getCompany(anyInt());

        verify(companyRepo, times(1)).getCompanyByNo(anyInt());
    }
}
