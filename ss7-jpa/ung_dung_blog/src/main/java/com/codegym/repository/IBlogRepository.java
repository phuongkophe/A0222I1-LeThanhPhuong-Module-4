package com.codegym.repository;

import com.codegym.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
//    @Modifying
//    @Query(value = "delete from Customer where id = :id", nativeQuery = false)
//    void delete(@Param("id") String id);
//
//    @Query(value = "select blog_id, blog_name, blog_image, blog_describe from blog where name like :nameSearch", nativeQuery = true)
//    List<Blog> search(@Param("nameSearch") String name);

    List<Blog> findAllByNameContaining(String name);
}
