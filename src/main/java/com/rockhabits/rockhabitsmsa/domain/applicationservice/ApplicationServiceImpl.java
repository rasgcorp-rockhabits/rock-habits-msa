package com.rockhabits.rockhabitsmsa.domain.applicationservice;

import com.rockhabits.rockhabitsmsa.domain.applicationservice.dto.WeekTasksResponse;
import com.rockhabits.rockhabitsmsa.domain.applicationservice.ports.input.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final TasksCommandHandler tasksCommandHandler;

    public ApplicationServiceImpl(TasksCommandHandler tasksCommandHandler) {
        this.tasksCommandHandler = tasksCommandHandler;
    }

    @Override
    public WeekTasksResponse getTasksByWeekId(String weekId) {
        return tasksCommandHandler.getTasks(weekId);
    }
}
