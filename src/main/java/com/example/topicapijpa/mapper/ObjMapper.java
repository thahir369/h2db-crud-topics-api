package com.example.topicapijpa.mapper;


import com.example.topicapijpa.dto.TopicDto;
import com.example.topicapijpa.model.Topic;
import org.springframework.stereotype.Component;


public class ObjMapper {

    TopicDto objToDto(Topic topic){

        return TopicDto.builder()
                .id(topic.getId())
                .name(topic.getName())
                .description(topic.getDescription())
                .build();

    }

    Topic dtoToObj(TopicDto topicDto){
        return Topic.builder()
                .id(topicDto.getId())
                .name(topicDto.getName())
                .description(topicDto.getDescription())
                .build();
    }
}
