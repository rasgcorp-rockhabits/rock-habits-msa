package com.rockhabits.rockhabitsmsa.domain.domaincore.entity;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class WeekTasksAggregateRoot {
    private final String weekId;
    private List<Tasks> tasks;
}
