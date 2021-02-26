package com.example.topicapijpa.mapper;


import com.example.topicapijpa.dto.TopicDto;
import com.example.topicapijpa.model.Topic;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper
public interface TopicMapper {

    public TopicDto transformTopicToDto(Optional<Topic> topic);

    public Topic transformDtoToTopic(TopicDto topicDto);


}
