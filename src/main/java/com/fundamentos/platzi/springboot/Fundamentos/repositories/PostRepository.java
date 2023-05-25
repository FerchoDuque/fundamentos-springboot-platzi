package com.fundamentos.platzi.springboot.Fundamentos.repositories;

import com.fundamentos.platzi.springboot.Fundamentos.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
