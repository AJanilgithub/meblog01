package com.meblog.service;

import com.meblog.entity.Comment;
import com.meblog.entity.Post;
import com.meblog.exception.ResourceNotFoundException;
import com.meblog.payload.CommentDto;
import com.meblog.repository.CommentRepository;
import com.meblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    private PostRepository postRepository;

    private CommentRepository commentRepository;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }


    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("post not found with id:" + postId)
        );

        Comment comment=new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);
        Comment savecomment = commentRepository.save(comment);

        CommentDto dto=new CommentDto();
        dto.setId(savecomment.getId());
        dto.setEmail(savecomment.getEmail());
        dto.setText(savecomment.getText());

        return dto;
    }
}
