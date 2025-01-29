package com.rockhabits.rockhabitsmsa.infrastructure.dataaccess.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@Document(collection = "weektasks")
public class WeekTasks {
    @Id
    private String _id;
    private Map<String, Map<String, Boolean>> tasks;

    public WeekTasks() {
    }

    public WeekTasks(String _id, Map<String, Map<String, Boolean>> tasks) {
        this._id = _id;
        this.tasks = tasks;
    }
}
