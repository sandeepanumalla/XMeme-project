package com.crio.starter.data;

import com.crio.starter.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document("meme_posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meme {

    private String username;

    @Indexed(unique = true)
    private String url;

    @Indexed(unique = true)
    private String caption;

    @CreatedDate
    private Date dateCreated;

    List<Comment> listOfComments;
}
