package com.example.glsib.Service;

import com.example.glsib.Entite.Comment;
import com.example.glsib.Entite.Service;
import com.example.glsib.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class CommentService  {

    @Autowired
    CommentRepository commentRepository;
    public Comment addService(Comment s1){
        Comment savedComment = commentRepository.save(s1);
        return savedComment;
    }
    public Comment deleteComment(Long id){
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()){
            return comment.get();
        }else
        {
            return null;
        }
    }
    public List<Service> gettAllComment(){
        commentRepository.findAll();
        return gettAllComment();
    }

}
