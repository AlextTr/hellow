package com.hellow.repository;

import com.hellow.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT * FROM bloger.comments WHERE comments.id = :id", nativeQuery = true)
    Comment findOne(
            @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "Insert into bloger.comments values(comment_pk_seq.nextval, :text, :owner, :postid)", nativeQuery = true)
    void save(@Param("text") String text,
              @Param("owner") String owner,
              @Param("postid") Integer postid);

    @Modifying
    @Transactional
    @Query(value = "Update bloger.comments set comments.comment_text=:text, comments.comment_owner=:owner where comments.id=:id", nativeQuery = true)
    void updateComment(@Param("id") Integer id,
                    @Param("text") String text,
                    @Param("owner") String owner);

    @Modifying
    @Transactional
    @Query(value = "Delete from bloger.comments where comments.id = :id", nativeQuery = true)
    void deleteComment(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "Delete from bloger.comments where comments.post_id = :id", nativeQuery = true)
    void deleteAllComments(@Param("id") Integer id);

    @Query(value = "SELECT * FROM bloger.comments where comments.post_id = :id", nativeQuery = true)
    List<Comment> findAllComments(@Param("id") Integer id);

}
