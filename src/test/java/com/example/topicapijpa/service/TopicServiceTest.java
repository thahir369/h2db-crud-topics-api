//package com.example.topicapijpa.service;
//
//import com.example.topicapijpa.dto.TopicDto;
//import com.example.topicapijpa.model.Topic;
//import com.example.topicapijpa.repository.TopicRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//
//@ExtendWith(MockitoExtension.class)
//class TopicServiceTest {
//
//    @InjectMocks
//    TopicService topicService;
//
//    @Mock
//    TopicRepository topicRepository;
//
//    @Test
//    void getAllTopicsTest() {
//
//        when(topicRepository.findAll()).thenReturn(data);
//        List<TopicDto> listOfTopics = topicService.getAllTopics();
//
//        assertEquals("java", listOfTopics.get(0).getName());
//    }
//
//    @Test
//    void getTopicTest() {
//
//        Topic x = new Topic('2', "javascript", "markup language");
//        when(topicRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(x));
//        Optional<Topic> obj = topicService.getTopic(Mockito.anyInt());
//        assertEquals(true, obj.isPresent());
//    }
//
//    @Test
//    void addTopicTest() {
//    }
//
//    @Test
//    void updateTopicTest() {
//    }
//
//    @Test
//    void deleteTopicTest() {
//    }
//}