package com.pierceecom.blog.service;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<PostDto, String> {

}
