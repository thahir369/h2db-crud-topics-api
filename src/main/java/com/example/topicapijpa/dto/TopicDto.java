package com.example.topicapijpa.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicDto {

    private int id;
    private String name;
    private String description;

}
