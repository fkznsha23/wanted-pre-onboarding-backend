package entity;

import inter.User;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Company implements User {
    public Company(String name, String type, String businessDetail, LocalDate establishmentDate, String address, int peopleNum) {
        this.name = name;
        this.type = type;
        this.businessDetail = businessDetail;
        this.establishmentDate = establishmentDate;
        this.address = address;
        this.peopleNum = peopleNum;
    }

    private int no;
    private String name;
    private String type;
    private String homePage;
    private String ceo;
    private String businessDetail;
    private LocalDate establishmentDate;
    private String address;
    private int peopleNum;
}
