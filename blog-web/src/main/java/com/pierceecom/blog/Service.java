package com.pierceecom.blog;

import java.time.LocalDate;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    static Repository repository;

    public static Boolean doesPostExist(String id) {
        return repository.existsById(id);
    }

    public static void post(PostDto post) throws Exceptions.PostExistsException {
        if (doesPostExist(post.id)) {
            throw new Exceptions.PostExistsException("Post already exists");
        } else {
            post.setId(LocalDate.now().toString());
            repository.save(post);
        }
    }

    public void deletePost(String id) throws Exceptions.PostExistsException {
        if (doesPostExist(id)) {
            repository.deleteById(id);
        } else {
            throw new Exceptions.PostExistsException("Post with given id does not exist");
        }
    }

    public void getAllPosts() {
        repository.findAll();
    }

    public Optional<PostDto> findPostWithGivenId(String id) {
        return repository.findById(id);
    }
}
