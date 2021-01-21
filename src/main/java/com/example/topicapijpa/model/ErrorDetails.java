package com.example.topicapijpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class ErrorDetails {
    private Date timestamp;
    private  String message;
    private String details;
    private HttpStatus httpStatus;
}
