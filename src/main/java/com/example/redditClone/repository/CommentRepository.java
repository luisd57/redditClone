package com.example.redditClone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.redditClone.model.Comment;
import com.example.redditClone.model.Post;
import com.example.redditClone.model.User;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	List<Comment> findByPost(Post post);

	List<Comment> findAllByUser(User user);

}
