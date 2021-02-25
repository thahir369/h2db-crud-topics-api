package com.example.topicapijpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Topic {

    @Id
    @Column(updatable = false,nullable = false,unique = true)
    private int id;
    private String name;
    private String description;

}
