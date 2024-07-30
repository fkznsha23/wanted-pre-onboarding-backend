package project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.repository.RepoInter;

@Service
@RequiredArgsConstructor
public class EmploymentService {
    private final RepoInter repoInter;

}
