package com.rockhabits.rockhabitsmsa.infrastructure.dataaccess.mapper;

import com.rockhabits.rockhabitsmsa.domain.domaincore.entity.Tasks;
import com.rockhabits.rockhabitsmsa.domain.domaincore.entity.WeekTasksAggregateRoot;
import com.rockhabits.rockhabitsmsa.infrastructure.dataaccess.entity.WeekTasks;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class WeekTasksDataAccessMapper {


    public WeekTasksAggregateRoot weekTasksEntityToWeekTasksAggregateRoot(WeekTasks weekTasks) {
        return WeekTasksAggregateRoot.builder()
                .weekId(weekTasks.get_id())
                .tasks(weekTasks.getTasks().isEmpty() ? new ArrayList<>() :
                        weekTasks.getTasks().entrySet().stream()
                                .map(tasks -> Tasks.builder()
                                        .day(tasks.getKey())
                                        .tasks(tasks.getValue())
                                        .build()).collect(Collectors.toList())
                )
                .build();
    }
}
