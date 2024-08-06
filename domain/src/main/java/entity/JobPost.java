package entity;

import inter.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class JobPost implements Post {
    public JobPost(String title, String position, String career, String degree, double salary, String detail, LocalDate endDate, int companyNo) {
        this.title = title;
        this.position = position;
        this.career = career;
        this.degree = degree;
        this.salary = salary;
        this.detail = detail;
        this.createDate = LocalDate.now();
        this.endDate = endDate;
        this.companyNo = companyNo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String title;
    private String position;
    private String career;
    private String degree;
    private double salary;
    private String detail;
    private LocalDate createDate;
    private LocalDate endDate;
    private int companyNo;

    public void modifyJobPost(String title, String position, String career, String degree, double salary, String detail, LocalDate endDate) {
        this.title = title;
        this.position = position;
        this.career = career;
        this.degree = degree;
        this.salary = salary;
        this.detail = detail;
        this.endDate = endDate;
    }
}
