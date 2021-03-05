package com.example.topicapijpa.service;

import com.example.topicapijpa.dto.TopicDto;
import com.example.topicapijpa.exception.ResourceNotFoundException;
import com.example.topicapijpa.mapper.TopicMapper;
import com.example.topicapijpa.model.Topic;
import com.example.topicapijpa.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private TopicMapper topicMapper;

    List<Topic> topics;
    List<TopicDto> topicDtos = new ArrayList<>();

    public List<TopicDto> getAllTopics() {
        topics = topicRepository.findAll();
        if (topics.isEmpty()) {
            throw new ResourceNotFoundException("no topics are found");
        } else {
            topics.forEach(i -> topicDtos.add(transformTopicToTopicDto(Optional.of(i))));
            return topicDtos;
        }
    }

    public TopicDto getTopic(int id) {
        if (!topicRepository.findById(id).isPresent())
            throw new ResourceNotFoundException("topic with id " + id + " is not found");
        else
            return transformTopicToTopicDto(topicRepository.findById(id));

    }

    public void addTopic(TopicDto topicDto) {
        topicRepository.save(transformTopicDtoToTopic(topicDto));
    }

    public void updateTopic(int id, TopicDto topicDto) {
        if (!topicRepository.findById(id).isPresent())
            throw new ResourceNotFoundException("topic with id " + id + " is not found");
        else
        topicRepository.save(transformTopicDtoToTopic(topicDto));
    }

    public void deleteTopic(int id) {
        topicRepository.deleteById(id);
    }


    private TopicDto transformTopicToTopicDto(Optional<Topic> topic) {
        if (topic.isPresent()) {

            return TopicDto.builder()
                    .id(topic.get().getId())
                    .name(topic.get().getName())
                    .description(topic.get().getDescription())
                    .build();
        } else {
            return null;
        }
    }

    private Topic transformTopicDtoToTopic(TopicDto topicDto) {

        return Topic.builder()
                .id(topicDto.getId())
                .name(topicDto.getName())
                .description(topicDto.getDescription())
                .build();

    }

}
