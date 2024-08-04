package project;

import entity.Company;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import project.repository.CompanyRepo;
import project.service.CompanyService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {

    @Mock
    CompanyRepo companyRepo;

    @InjectMocks
    CompanyService companyService;

    @Test
    public void 회사_조회_성공_테스트() {
        Company company = mock(Company.class);
        given(companyRepo.getCompanyByNo(anyInt())).willReturn(company);

        companyService.getCompany(anyInt());

        verify(companyRepo, times(1)).getCompanyByNo(anyInt());
    }

    @Test
    public void 회사_조회_실패_테스트() {
        Throwable ex = assertThrows(RuntimeException.class, () -> companyService.getCompany(anyInt()));

        assertThat(ex.getMessage()).isEqualTo("조회된 회사가 존재하지 않습니다.");
    }
}
