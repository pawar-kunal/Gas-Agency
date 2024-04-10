package com.gas.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String firstName;

    private String lastName;

    private String email;

    private String mobileNumber;

    private String password;

    private String status;

    private Date date;

    @ManyToOne
    private RoleMaster roleMaster;

}
