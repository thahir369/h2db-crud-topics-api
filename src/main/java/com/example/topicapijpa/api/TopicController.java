package com.example.topicapijpa.api;

import com.example.topicapijpa.dto.TopicDto;
import com.example.topicapijpa.model.Topic;
import com.example.topicapijpa.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/usersAssistance")
    public String usersAssistance() {
        return "hai! i'm your personal asssitance";
    }
    @GetMapping("/home")
    public String homepage() {
        return "Hai! welcome to our website. click here to to see all topics available in this website";
    }

    @GetMapping("/topics")
    public List<TopicDto> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{id}")
    public TopicDto getTopic(@PathVariable int id) {
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @PutMapping("topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable int id) {
        topicService.updateTopic(topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable int id) {
        topicService.deleteTopic(id);
    }



}
