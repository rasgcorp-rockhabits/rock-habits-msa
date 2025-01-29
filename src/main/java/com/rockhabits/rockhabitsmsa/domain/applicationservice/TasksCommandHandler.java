package com.rockhabits.rockhabitsmsa.domain.applicationservice;

import com.rockhabits.rockhabitsmsa.domain.applicationservice.dto.WeekTasksResponse;
import com.rockhabits.rockhabitsmsa.domain.applicationservice.mapper.WeekTaskDataMapper;
import com.rockhabits.rockhabitsmsa.domain.applicationservice.ports.output.repository.WeekTasksRepository;
import com.rockhabits.rockhabitsmsa.domain.domaincore.entity.WeekTasksAggregateRoot;
import com.rockhabits.rockhabitsmsa.domain.domaincore.exception.WeekTasksNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TasksCommandHandler {

    private final WeekTasksRepository weekTasksRepository;
    private final WeekTaskDataMapper weekTaskDataMapper;

    public TasksCommandHandler(WeekTasksRepository weekTasksRepository, WeekTaskDataMapper weekTaskDataMapper) {
        this.weekTasksRepository = weekTasksRepository;
        this.weekTaskDataMapper = weekTaskDataMapper;
    }

    public WeekTasksResponse getTasks(String weekId) {
        WeekTasksAggregateRoot weekTasksByWeekId = weekTasksRepository.findByWeekId(weekId);
        if (weekTasksByWeekId == null) {
            log.warn("Could not find week tasks with week id: {}", weekId);
            throw new WeekTasksNotFoundException("Could not find week tasks with week id: " + weekId);
        }
        return weekTaskDataMapper.weekTasksAggregateRootToWeekTaskResponse(weekTasksByWeekId);
    }
}
