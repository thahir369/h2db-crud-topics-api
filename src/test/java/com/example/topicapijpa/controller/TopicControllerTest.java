package com.example.topicapijpa.controller;

import com.example.topicapijpa.dto.TopicDto;
import com.example.topicapijpa.service.TopicService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(TopicController.class)
class TopicControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TopicService topicService;

    @Test
    void homepage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/home"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hai! welcome to our website. click here to to see all topics available in this website"));
    }

    @Test
    void getAllTopics() throws Exception {

        when(topicService.getAllTopics()).thenReturn(
                Arrays.asList(
                        new TopicDto(1, "topic1", "description1"),
                        new TopicDto(2, "topic2", "description2"),
                        new TopicDto(3, "topic3", "description3")
                )
        );

        mockMvc.perform(MockMvcRequestBuilders
                .get("/topics")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[2].name").value("topic3"));

        verify(topicService, times(1)).getAllTopics();
    }

    @Test
    void getTopic() throws Exception {

        when(topicService.getTopic(Mockito.anyInt())).thenReturn(new TopicDto(3, "topic3", "description3"));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/topics/{id}", Mockito.anyInt())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.description").value("description3"));

        verify(topicService, times(1)).getTopic(Mockito.anyInt());

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
