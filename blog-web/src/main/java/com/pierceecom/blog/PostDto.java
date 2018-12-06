package com.pierceecom.blog;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PostDto {

    @Id
    public static String id;

    @NotNull
    public static String title;

    @NotNull
    public static String content;
}
