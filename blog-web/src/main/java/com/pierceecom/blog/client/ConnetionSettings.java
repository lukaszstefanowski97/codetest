package com.pierceecom.blog.client;

import com.pierceecom.blog.service.PostDto;
import org.springframework.web.client.RestTemplate;

public class ConnetionSettings {

    public static String URL = "http://localhost:8080/blog-web/posts/";

    public RestTemplate restTemplate;

    public void savePost(String id, String title, String content) {
        PostDto post = new PostDto();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
    }
}
