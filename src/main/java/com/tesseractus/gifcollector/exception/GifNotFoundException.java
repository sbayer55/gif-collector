package com.tesseractus.gifcollector.exception;

public class GifNotFoundException extends RuntimeException {

    public GifNotFoundException(Integer gifId) {
        super("Could not find gif for " + gifId);
    }
}
