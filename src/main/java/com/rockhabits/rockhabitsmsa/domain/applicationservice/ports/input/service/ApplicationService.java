package com.rockhabits.rockhabitsmsa.domain.applicationservice.ports.input.service;

import com.rockhabits.rockhabitsmsa.domain.applicationservice.dto.WeekTasksResponse;

public interface ApplicationService {
    WeekTasksResponse getTasksByWeekId(String weekId);
}
