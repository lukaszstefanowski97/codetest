package com.pierceecom.blog;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PostDto {

    @Id
    public String id;

    @NotNull
    private String title;

    @NotNull
    private String content;
}
