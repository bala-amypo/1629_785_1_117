// package com.example.demo.exception;

// public class ResourceNotFoundException extends RuntimeException {

//     public ResourceNotFoundException(String message) {
//         super(message);
//     }
// }

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
