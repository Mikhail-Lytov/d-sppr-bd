package com.lytov.diplom.dspprbd.exception;

public class DownloadUrlGenerationException extends RuntimeException {
    public DownloadUrlGenerationException(String message) {
        super(message);
    }

    public String getReason() {
        return "download_url_generation_exception";
    }
}
