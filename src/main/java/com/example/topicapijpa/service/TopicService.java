package com.example.topicapijpa.service;

import com.example.topicapijpa.model.Topic;
import com.example.topicapijpa.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Optional<Topic> getTopic(int id) {
        if(!topicRepository.findById(id).isPresent())
            throw new RuntimeException("topic with id "+id+" is not found");
        else
            return topicRepository.findById(id);

    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic) {
        topicRepository.save(topic);

    }

    public void deleteTopic(int id) {
     topicRepository.deleteById(id);
    }

}
