package com.crio.starter.data;

import java.sql.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "User")
public class User {
    
    private String username;
    private String password;
    private String About;

    @CreatedDate
    private Date date;
}
