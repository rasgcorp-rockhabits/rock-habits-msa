package com.rockhabits.rockhabitsmsa.application.rest;

import com.rockhabits.rockhabitsmsa.domain.applicationservice.dto.WeekTasksResponse;
import com.rockhabits.rockhabitsmsa.domain.applicationservice.ports.input.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "tasks", produces = "application/vnd.api.v1+json")
public class Controller {

    private final ApplicationService applicationService;

    public Controller(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/{weekId}")
    public ResponseEntity<WeekTasksResponse> getTasksByWeekId(@PathVariable String weekId) {
        WeekTasksResponse weekTasksResponse = applicationService.getTasksByWeekId(weekId);
        log.info("Returning week tasks by week id: {}", weekTasksResponse.getWeekId());
        return ResponseEntity.ok(weekTasksResponse);
    }
}
