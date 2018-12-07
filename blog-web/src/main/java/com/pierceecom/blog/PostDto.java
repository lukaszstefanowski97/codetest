package com.pierceecom.blog;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Document
public class PostDto {

    @Id
    @ApiModelProperty
    public String id;

    @Field(value = "Title")
    @ApiModelProperty(required = true, example = "Example of post title")
    @NotNull
    public String title;

    @Field(value = "Content")
    @ApiModelProperty(required = true, example = "Example of post content")
    @NotNull
    public String content;
}
