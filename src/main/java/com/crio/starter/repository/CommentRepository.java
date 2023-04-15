package com.crio.starter.repository;

import com.crio.starter.data.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CommentRepository extends MongoRepository<Comment, String> {

//    @Query(value = "{ '_id' : ?0, 'listOfComments._id' : ?1 }",
//            fields = "{ 'listOfComments.$' : 1 }")
//    Comment findCommentById(String memeId, String commentId);
//
//    @Query(value = "{ '_id' : ?0, 'listOfComments._id' : ?1 }",
//            fields = "{ 'listOfComments.$' : 1 }")
//    Optional<Comment> findCommentByIdOptional(String memeId, String commentId);
//
//    @Query(value = "{ '_id' : ?0, 'listOfComments._id' : ?1 }")
//    void updateComment(String memeId, String commentId, Comment comment);
}
