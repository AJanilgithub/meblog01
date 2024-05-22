package com.meblog.payload;

import lombok.Data;

@Data
public class CommentDto {
    private long id;

    private String text;

    private String email;
}
