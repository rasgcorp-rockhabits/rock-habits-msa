package com.rockhabits.rockhabitsmsa.domain.applicationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class WeekTasksResponse {
    private final String weekId;
    private final List<Tasks> tasksByDay;
}
