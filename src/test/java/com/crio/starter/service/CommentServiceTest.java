package com.crio.starter.service;

import com.crio.starter.data.Comment;
import com.crio.starter.repository.CommentRepository;
import com.crio.starter.repository.MemeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CommentServiceTest {

    @MockBean
    MemeRepository memeRepository;

    @MockBean
    CommentRepository commentRepository;


    void shouldReturnTrueIfParentMemepostExists() {
        Comment comment = new Comment();
//        comment.setUsername("sandeep");
        comment.setParentMemeId();
        comment.setComment("blah blah blah");
    }

    @Test
    void commentOnMemeServiceShouldSave() {

    }
}
