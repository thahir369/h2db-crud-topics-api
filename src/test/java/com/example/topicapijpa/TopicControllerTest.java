package com.example.topicapijpa;

import com.example.topicapijpa.model.Topic;
import com.example.topicapijpa.repository.TopicRepository;
import com.example.topicapijpa.service.TopicService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TopicControllerTest {

  @InjectMocks
  TopicService topicService;

  @Mock
  TopicRepository topicRepository;

    @Test
    void getAllTopics() {

        List<Topic> data= Arrays.asList(
                new Topic('1',"java","programming language"),
                new Topic('2',"javascript","markup language")
        );

        when(topicRepository.findAll()).thenReturn(data);
      List<Topic> listOfTopics=topicService.getAllTopics();

        assertEquals("java", listOfTopics.get(0).getName());
    }

    @Test
    void getTopic() {

      Topic x=new Topic('2',"javascript","markup language");
      when(topicRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(x));
      Optional<Topic> obj= topicService.getTopic(Mockito.anyInt());
      assertEquals(true,obj.isPresent());
    }

    @Test
    void addTopic() {
    }

    @Test
    void updateTopic() {
    }

    @Test
    void deleteTopic() {
    }
}