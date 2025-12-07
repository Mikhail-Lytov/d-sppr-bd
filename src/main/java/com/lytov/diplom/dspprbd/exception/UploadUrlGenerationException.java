package com.lytov.diplom.dspprbd.exception;

public class UploadUrlGenerationException extends RuntimeException {
    public UploadUrlGenerationException(String message) {
        super(message);
    }

    public String getReason() {
        return "upload_url_generation_exception";
    }
}
