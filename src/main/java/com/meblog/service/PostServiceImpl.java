package com.meblog.service;

import com.meblog.entity.Post;
import com.meblog.payload.PostDto;
import com.meblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post=new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savespost =postRepository.save(post);

        PostDto postDto1=new PostDto();
        postDto1.setId(savespost.getId());
        postDto1.setTitle(savespost.getTitle());
        postDto1.setDescription(savespost.getDescription());
        postDto1.setContent(savespost.getContent());
        postRepository.save(savespost);
        return postDto1;
    }
}
