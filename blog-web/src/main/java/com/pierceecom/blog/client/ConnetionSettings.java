package com.pierceecom.blog.client;

import com.pierceecom.blog.service.PostDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.LinkedList;

public class ConnetionSettings {

    public RestTemplate restTemplate;

    public static HttpHeaders returnHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        String mediaType;
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

    public ConnetionSettings() {
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

    public void removePost(String id) {
        try {
            restTemplate.delete(String.valueOf(UriComponentsBuilder.fromHttpUrl(url).path(id)));
        } catch (HttpClientErrorException e){
            System.out.println(e.getResponseBodyAsString());
        }
    }

    public void getPost(String id) {
        ResponseEntity<PostDto> responseEntity =
                restTemplate.getForEntity(String.valueOf(UriComponentsBuilder.fromHttpUrl(url).path(id)),
                        PostDto.class);
    }

    public void getAllPosts() {
        ResponseEntity<LinkedList<PostDto>> responseEntity =
                restTemplate.exchange(String.valueOf(UriComponentsBuilder.fromHttpUrl(url)), HttpMethod.GET,
                        new HttpEntity<>(returnHeader()),
                        new ParameterizedTypeReference<LinkedList<PostDto>>() {
                        });
    }

    public static void printPost (ResponseEntity<PostDto> postDtoResponseEntity) {
        try {
            System.out.println(postDtoResponseEntity.getBody().toString());
        } catch (Exception e) {
            System.out.println("Post does not exist");
        }
    }
}
