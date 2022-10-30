package com.example.glsib.Repository;

import com.example.glsib.Entite.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
