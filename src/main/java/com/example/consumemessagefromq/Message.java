package com.example.consumemessagefromq;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable {
    private String message;
    private String to;
    private String from;
}
