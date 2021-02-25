package com.example.topicapijpa.bootstrapLoader;

import com.example.topicapijpa.model.Topic;
import com.example.topicapijpa.repository.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class TopicLoader implements CommandLineRunner {

    private final TopicRepository topicRepository;

    public TopicLoader(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadTopicObjects();
    }

    private void loadTopicObjects() {

        if (topicRepository.count() == 0) {
            topicRepository.save(Topic.builder().id(1).name("java").description("programming language").build());
            topicRepository.save(Topic.builder().id(2).name("python").description("programming language").build());
            topicRepository.save(Topic.builder().id(3).name("spring").description("framework").build());
            topicRepository.save(Topic.builder().id(4).name("sql").description("query language").build());

        }
        System.out.println("Loaded topics: "+topicRepository.count());
    }

}
