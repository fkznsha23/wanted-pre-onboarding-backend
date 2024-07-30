package project;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import project.repository.RepoInter;
import project.service.EmploymentService;

@ExtendWith(MockitoExtension.class)
public class EmploymentServiceTest {

    @Mock
    private RepoInter repo;

    @InjectMocks
    private EmploymentService service;
}
