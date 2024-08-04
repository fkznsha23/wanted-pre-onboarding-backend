package project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
public class JobPostModifyForm {
    public JobPostModifyForm(int no, String title, String position, String career, String degree, double salary, String detail, LocalDate endDate) {
        this.no = no;
        this.title = title;
        this.position = position;
        this.career = career;
        this.degree = degree;
        this.salary = salary;
        this.detail = detail;
        this.endDate = endDate;
    }

    private int no;
    private String title;
    private String position;
    private String career;
    private String degree;
    private double salary;
    private String detail;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate endDate;
}
