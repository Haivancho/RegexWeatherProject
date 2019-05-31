package com.jboxers.datastructure.modelStructure;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class AbstractEntity {

    public LocalDateTime dateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private int version;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
