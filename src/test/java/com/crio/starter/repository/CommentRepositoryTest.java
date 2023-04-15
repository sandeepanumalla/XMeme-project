package com.crio.starter.repository;


import com.crio.starter.data.Comment;
import com.crio.starter.repository.CommentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CommentRepositoryTest {

        @MockBean
        private CommentRepository commentRepository;

        Comment comment;

        @BeforeEach
        void setup() {
                comment = new Comment();
                comment.setId("1");
                comment.setUsername("sandeep");
                comment.setComment("this is my new comment");
        }

        @Test
        void shouldReturnFalseIfCommentDontExist() {
            ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

            Mockito.when(commentRepository.existsById(stringArgumentCaptor.capture())).thenReturn(false);
            boolean actual = commentRepository.existsById("2");
            Assertions.assertEquals(false, actual);
        }

        void shouldReturnTrueIfCommentExists() {

        }

        void shouldReturnTheCommentDTOIfCommentExists() {

        }

        @Test
        void shouldCreateNewCommentSuccessfully() {
                ArgumentCaptor<Comment> commentArgumentCaptor = ArgumentCaptor.forClass(Comment.class);

                Mockito.when(commentRepository.save(commentArgumentCaptor.capture())).thenReturn(comment);
                Comment saved = commentRepository.save(comment);
                Assertions.assertEquals(comment.getUsername(), saved.getUsername());
                Assertions.assertEquals(comment.getComment(), saved.getComment());

                Assertions.assertEquals(commentArgumentCaptor.getValue().getUsername(), saved.getUsername());
                Assertions.assertEquals(commentArgumentCaptor.getValue().getComment(), saved.getComment());


        }

}


