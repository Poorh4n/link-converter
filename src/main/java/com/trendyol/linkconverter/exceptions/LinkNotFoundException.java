package com.trendyol.linkconverter.exceptions;


public class LinkNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;
    private final String[] params;

    public LinkNotFoundException() {
        super("Link Not Found");
        this.message = "Link Not Found";
        this.params = new String[0];
    }

    public LinkNotFoundException(String message, String... params) {
        super(message);
        this.message = message;
        this.params = params;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String[] getParams() {
        return params;
    }
}
