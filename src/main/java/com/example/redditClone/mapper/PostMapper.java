package com.example.redditClone.mapper;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.redditClone.dto.PostRequest;
import com.example.redditClone.dto.PostResponse;
import com.example.redditClone.model.Post;
import com.example.redditClone.model.Subreddit;
import com.example.redditClone.model.User;
import com.example.redditClone.service.AuthService;


@Mapper(componentModel = "spring")
public abstract class PostMapper {
	@Autowired
	private AuthService authservice;
	
	@Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
	@Mapping(target = "description", source = "postRequest.description")
	@Mapping(target = "subreddit", source = "subreddit")
	@Mapping(target = "voteCount", constant = "0")
	@Mapping(target = "user", source = "user")
	public abstract Post map(PostRequest postRequest, Subreddit subreddit, User user);

	@Mapping(target = "id", source = "postId")
	@Mapping(target = "subredditName", source = "subreddit.name")
	@Mapping(target = "userName", source = "user.username")
	
	public abstract PostResponse mapToDto(Post post);
}
