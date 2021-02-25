package com.example.topicapijpa;

import com.example.topicapijpa.dto.TopicDto;
import com.example.topicapijpa.model.Topic;


@org.mapstruct.Mapper
public interface TopicMapper {

    public TopicDto topicToTopicDto(Topic topic);

}
