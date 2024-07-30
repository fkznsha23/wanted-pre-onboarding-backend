package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.service.EmploymentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employment")
public class EmploymentController {

    private final EmploymentService emplService;
}
