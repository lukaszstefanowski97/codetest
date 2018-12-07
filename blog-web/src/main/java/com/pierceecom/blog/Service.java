package com.pierceecom.blog;

import java.time.LocalDate;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    public static Repository repository;

    public static void post(PostDto post) throws Exceptions.PostExistsException {
        if (repository.existsById(post.id)) {
            throw new Exceptions.PostExistsException("Post already exists");
        } else {
            post.setId(LocalDate.now().toString());
            repository.save(post);
        }
    }

    public static void updatePost(PostDto post) throws Exceptions.PostExistsException {
        if (repository.existsById(post.id)) {
            repository.save(post);
        } else {
            throw new Exceptions.PostExistsException("404 Post with given id does not exist");
        }
    }

    public void deletePost(String id) throws Exceptions.PostExistsException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new Exceptions.PostExistsException("404 Post with given id does not exist");
        }
    }

    public void getAllPosts() {
        repository.findAll();
    }

    public Optional<PostDto> findPostWithGivenId(String id) throws Exceptions.PostExistsException {
        if (!repository.existsById(id)) {
            throw new Exceptions.PostExistsException("404 Post with given id does not exist");
        }
        return repository.findById(id);
    }
}
