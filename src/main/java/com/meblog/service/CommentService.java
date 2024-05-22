package com.meblog.service;

import com.meblog.payload.CommentDto;

public interface CommentService {


    CommentDto createComment(CommentDto commentDto, long postId);
}
