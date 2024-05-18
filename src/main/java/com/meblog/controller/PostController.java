package com.meblog.controller;

import com.meblog.payload.PostDto;
import com.meblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(PostDto postDto){
        PostDto postDto1=postService.createPost(postDto);
        return new ResponseEntity<>(postDto1, HttpStatus.CREATED);
    }
}
