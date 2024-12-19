package com.jo_paris_2024.controller;  // Assurez-vous que le package est le bon

public class ErrorResponse {
    private String message;

    // Constructeur
    public ErrorResponse(String message) {
        this.message = message;
    }

    // Getter
    public String getMessage() {
        return message;
    }

    // Setter
    public void setMessage(String message) {
        this.message = message;
    }
}
