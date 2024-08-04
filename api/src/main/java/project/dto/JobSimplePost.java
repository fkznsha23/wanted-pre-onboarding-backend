package project.dto;

import lombok.Getter;

@Getter
public class JobSimplePost {
    public JobSimplePost(String title, String name, String career, String address, String position, String degree) {
        this.title = title;
        this.name = name;
        this.career = career;
        this.address = address;
        this.position = position;
        this.degree = degree;
    }

    private String title;
    private String name;
    private String career;
    private String address;
    private String position;
    private String degree;
}
