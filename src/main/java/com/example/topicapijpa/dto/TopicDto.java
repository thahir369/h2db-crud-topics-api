package com.example.topicapijpa.dto;

import lombok.*;

import javax.persistence.Column;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicDto {

    @Column(updatable = false,nullable = false,unique = true)
    private int id;
    private String name;
    private String description;

}
