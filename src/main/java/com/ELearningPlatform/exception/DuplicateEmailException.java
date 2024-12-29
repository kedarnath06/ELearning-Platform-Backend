package com.ELearningPlatform.exception;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String email) {
        super("Instructor with email " + email + " already exists");
    }
}
