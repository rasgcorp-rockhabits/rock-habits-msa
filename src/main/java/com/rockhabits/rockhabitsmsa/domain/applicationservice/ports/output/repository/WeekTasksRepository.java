package com.rockhabits.rockhabitsmsa.domain.applicationservice.ports.output.repository;

import com.rockhabits.rockhabitsmsa.domain.domaincore.entity.WeekTasksAggregateRoot;

import java.util.Optional;

public interface WeekTasksRepository {

    WeekTasksAggregateRoot findByWeekId(String weekId);
}
