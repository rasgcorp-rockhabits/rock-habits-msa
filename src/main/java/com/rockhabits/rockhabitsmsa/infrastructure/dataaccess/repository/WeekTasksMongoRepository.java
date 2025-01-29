package com.rockhabits.rockhabitsmsa.infrastructure.dataaccess.repository;

import com.rockhabits.rockhabitsmsa.infrastructure.dataaccess.entity.WeekTasks;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WeekTasksMongoRepository extends MongoRepository<WeekTasks, String> {
    Optional<WeekTasks> findBy_id(String weekId);
}
