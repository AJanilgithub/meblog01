package com.meblog.controller;

import com.meblog.payload.PostDto;
import com.meblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<PostDto> getPostById(@RequestParam long id){
        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //http://localhost:8080/api/posts/pageNo=0&pageSize=5&sortBy=title
    @GetMapping("/all")
    public List<PostDto> getAllPosts(
          @RequestParam(value = "pageNo",required = false,defaultValue = "0")int pageNo,
          @RequestParam(value = "pageSize",required = false,defaultValue = "5")int pageSize,
          @RequestParam(value = "sortBy" , required = false ,defaultValue = "id")String sortBy,
          @RequestParam(value = "sortDir", required = false,defaultValue = "id")String sortDir
    ){
        List<PostDto> postdtos=postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);
        return  postdtos;
    }
}
