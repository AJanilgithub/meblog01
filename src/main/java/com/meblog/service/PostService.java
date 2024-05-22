package com.meblog.service;

import com.meblog.payload.PostDto;

import java.util.List;

public interface PostService {

      PostDto createPost(PostDto postDto);

      PostDto getPostById(long id);

      List<PostDto> getAllPosts(int pageNo, int pageSize,String sortBy,String sortDir);
}
