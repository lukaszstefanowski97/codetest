package com.pierceecom.blog.client;

import com.pierceecom.blog.service.PostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class ConnetionSettings {

    public RestTemplate restTemplate;

    public ConnetionSettings(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public static String url = "http://localhost:8080/blog-web/posts/";

    public static Boolean showPost(ResponseEntity<PostDto> postDtoResponseEntity) {
        try {
            System.out.println(postDtoResponseEntity.getBody().toString());
            return true;
        } catch (Exception e) {
            System.out.println("Post does not exist");
            return false;
        }
    }

    public void savePost(String id, String title, String content) {
        PostDto post = new PostDto();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        try {
            final ResponseEntity<PostDto> response =
                    restTemplate.postForEntity(UriComponentsBuilder.fromHttpUrl(url).toUriString(), post, PostDto.class);

            showPost(response);
        } catch (HttpClientErrorException ex) {
            System.out.println(ex.getResponseBodyAsString());
        }
    }

    public void removePost(PostDto post) {
        try {
            restTemplate.delete(String.valueOf(UriComponentsBuilder.fromHttpUrl(url)));
        } catch (HttpClientErrorException e){
            System.out.println(e.getResponseBodyAsString());
        }
    }

    public void getAllPosts() {

    }
}
