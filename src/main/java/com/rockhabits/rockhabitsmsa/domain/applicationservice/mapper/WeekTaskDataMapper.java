package com.rockhabits.rockhabitsmsa.domain.applicationservice.mapper;

import com.rockhabits.rockhabitsmsa.domain.applicationservice.dto.Tasks;
import com.rockhabits.rockhabitsmsa.domain.applicationservice.dto.WeekTasksResponse;
import com.rockhabits.rockhabitsmsa.domain.domaincore.entity.WeekTasksAggregateRoot;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class WeekTaskDataMapper {
    public WeekTasksResponse weekTasksAggregateRootToWeekTaskResponse(WeekTasksAggregateRoot weekTasksByWeekId) {
        return WeekTasksResponse.builder()
                .weekId(weekTasksByWeekId.getWeekId())
                .tasksByDay(weekTasksByWeekId.getTasks().stream()
                        .map(tasks -> Tasks.builder()
                                .day(tasks.getDay())
                                .tasks(tasks.getTasks())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
