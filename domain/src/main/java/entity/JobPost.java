package entity;

import inter.Post;
import inter.User;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class JobPost implements Post {
    public JobPost(String title, String career, String degree, double salary, String detail, LocalDate endDate, User user) {
        this.title = title;
        this.career = career;
        this.degree = degree;
        this.salary = salary;
        this.detail = detail;
        this.endDate = endDate;
        this.user = user;
    }

    private int no;
    private String title;
    private String career;
    private String degree;
    private double salary;
    private String detail;
    private LocalDate createDate;
    private LocalDate endDate;
    private User user;
}
