package entity;

import inter.Post;
import inter.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class JobPost implements Post {
    public JobPost(String title, String career, String degree, double salary, String detail, LocalDate endDate, int companyNo) {
        this.title = title;
        this.career = career;
        this.degree = degree;
        this.salary = salary;
        this.detail = detail;
        this.endDate = endDate;
        this.companyNo = companyNo;
    }

    @Id
    private int no;
    private String title;
    private String career;
    private String degree;
    private double salary;
    private String detail;
    private LocalDate createDate;
    private LocalDate endDate;
    private int companyNo;
}
