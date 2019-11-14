package com.hellow.repository;

import com.hellow.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT * FROM bloger.posts WHERE posts.id = :id", nativeQuery = true)
    Post findOne(
            @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "Insert into bloger.posts values(post_pk_seq.nextval, :text, :name, :creator)", nativeQuery = true)
    void save(@Param("text") String text,
              @Param("name") String name,
              @Param("creator") String creator);

    @Modifying
    @Transactional
    @Query(value = "Update bloger.posts set posts.post_text=:text, posts.post_name=:name where posts.id=:id", nativeQuery = true)
    void updatePost(@Param("id") Integer id,
                    @Param("text") String text,
                    @Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "Delete from bloger.posts where posts.id = :id", nativeQuery = true)
    void deletePost(@Param("id") Integer id);

    @Query(value = "SELECT * FROM bloger.posts", nativeQuery = true)
    List<Post> findAllPosts();

}
