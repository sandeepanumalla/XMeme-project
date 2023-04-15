package com.crio.starter.data;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Comments")
public class Comment {

    private String id;
    private String username;
    private String parentMemeId;
    private String comment;
    @CreatedDate
    private Date dateCreated;
    List<User> listOfLikes;
    List<Comment> listOfComments;
}
