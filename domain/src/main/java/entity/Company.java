package entity;

import inter.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Company implements User {
    public Company(String name, String type, String businessDetail, LocalDate establishmentDate, String address, int peopleNum) {
        this.name = name;
        this.type = type;
        this.businessDetail = businessDetail;
        this.establishmentDate = establishmentDate;
        this.address = address;
        this.peopleNum = peopleNum;
    }

    @Id
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
