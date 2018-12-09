package com.pierceecom.blog.service;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/posts")
public class RestController {

    private ServiceMethods service;

    @Autowired
    public void setService(ServiceMethods service) {
        this.service = service;
    }

    @RequestMapping(value = "/posts", method= RequestMethod.GET)
    @ApiOperation(value = "Display all posts", nickname = "getAllPosts")
    @ApiResponse(code = 200, message = "OK", response = PostDto.class)
    public Iterable list(){
        return service.getAllPosts();
    }

    @RequestMapping(value = "/posts/{id}", method= RequestMethod.GET)
    @ApiOperation(value = "Display selected post", nickname = "getPostById")
    @ApiResponses ({
        @ApiResponse(code = 200, message = "OK", response = PostDto.class),
        @ApiResponse(code = 404, message = "Post not found")
    })
    public Optional<PostDto> showPost(@PathVariable String id) throws Exceptions.PostExistsException {
        Optional<PostDto> post = service.findPostWithGivenId(id);
        return post;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "Save Post", nickname = "getAllPosts")
    @ApiResponse(code = 200, message = "OK", response = PostDto.class)

    public ResponseEntity<String> savePost(@RequestBody PostDto post) throws Exceptions.PostExistsException {
        service.post(post);
        return new ResponseEntity<>("Post saved successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update Post", nickname = "updatePost")
    @ApiResponses ({
            @ApiResponse(code = 200, message = "OK", response = PostDto.class),
            @ApiResponse(code = 404, message = "Post not found")
    })
    public ResponseEntity<String> updatePost(@PathVariable String id, @RequestBody PostDto post) throws Exceptions.PostExistsException {
        if (service.doesPostExist(id)){
            Optional<PostDto> storedPost = service.findPostWithGivenId(id);
            post.id = storedPost.get().id;
            post.title = storedPost.get().title;
            post.content = storedPost.get().content;
        }
        return new ResponseEntity<>("Post updated successfully", HttpStatus.OK);
    }


    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete Post", nickname = "deletePosts")
    @ApiResponses ({
            @ApiResponse(code = 200, message = "OK", response = PostDto.class),
            @ApiResponse(code = 404, message = "Post not found")
    })
    public ResponseEntity<String> deletePost(@PathVariable String id) throws Exceptions.PostExistsException {
        service.deletePost(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);

    }
}
