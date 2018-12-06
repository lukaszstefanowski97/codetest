package com.pierceecom.blog;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Exceptions {

    public static class PostExistsException extends Throwable {
        public PostExistsException(String exceptionMessage) {
            System.out.println(exceptionMessage);
        }
    }
}
