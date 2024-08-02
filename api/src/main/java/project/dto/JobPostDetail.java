package project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class JobPostDetail {
    public JobPostDetail(String title, String career, String degree, double salary, String detail, LocalDate endDate
                        , String companyName, String homePage, String address) {
        this.title = title;
        this.career = career;
        this.degree = degree;
        this.salary = salary;
        this.detail = detail;
        this.endDate = endDate;
        this.companyName = companyName;
        this.homePage = homePage;
        this.address = address;
    }

    private String title;
    private String career;
    private String degree;
    private double salary;
    private String detail;
    private LocalDate endDate;
    private String companyName;
    private String homePage;
    private String address;
}
