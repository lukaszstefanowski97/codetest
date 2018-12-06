package com.pierceecom.blog;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface Repository extends MongoRepository<PostDto, String> {

}
