package com.example.topicapijpa.controller;

import com.example.topicapijpa.dto.TopicDto;
import com.example.topicapijpa.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Validated
@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/home")
    public String homepage() {
        return "Hai! welcome to our website. click here to to see all topics available in this website";
    }

    @GetMapping("/topics")
    @ResponseStatus(HttpStatus.OK)
    public List<TopicDto> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TopicDto getTopic(@PathVariable int id) {
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")
    @ResponseStatus(HttpStatus.CREATED)
    public String addTopic(@RequestBody TopicDto topicDto) {
        topicService.addTopic(topicDto);
        return ("topic with id:"+topicDto.getId()+" and name:"+topicDto.getName()+" added successfully!");
    }

    @PutMapping("topics/{id}")
    public String updateTopic(@RequestBody TopicDto topicDto, @PathVariable int id) {
        topicService.updateTopic(id,topicDto);
        return ("topic with id:"+id+" and name:"+topicDto.getName()+" updated successfully!");
    }

    @DeleteMapping("/topics/{id}")
    public String deleteTopic(@PathVariable int id) {
        topicService.deleteTopic(id);
        return ("topic with id:"+id+" deleted successfully!");

    }



}
