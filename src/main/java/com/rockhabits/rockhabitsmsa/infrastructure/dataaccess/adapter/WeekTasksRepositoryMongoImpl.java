package com.rockhabits.rockhabitsmsa.infrastructure.dataaccess.adapter;

import com.rockhabits.rockhabitsmsa.domain.applicationservice.ports.output.repository.WeekTasksRepository;
import com.rockhabits.rockhabitsmsa.domain.domaincore.entity.WeekTasksAggregateRoot;
import com.rockhabits.rockhabitsmsa.infrastructure.dataaccess.entity.WeekTasks;
import com.rockhabits.rockhabitsmsa.infrastructure.dataaccess.mapper.WeekTasksDataAccessMapper;
import com.rockhabits.rockhabitsmsa.infrastructure.dataaccess.repository.WeekTasksMongoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WeekTasksRepositoryMongoImpl implements WeekTasksRepository {

    private final WeekTasksMongoRepository weekTasksMongoRepository;
    private final WeekTasksDataAccessMapper weekTasksDataAccessMapper;

    public WeekTasksRepositoryMongoImpl(WeekTasksMongoRepository weekTasksMongoRepository,
                                        WeekTasksDataAccessMapper weekTasksDataAccessMapper) {
        this.weekTasksMongoRepository = weekTasksMongoRepository;
        this.weekTasksDataAccessMapper = weekTasksDataAccessMapper;
    }


    @Override
    public WeekTasksAggregateRoot findByWeekId(String weekId) {
        Optional<WeekTasks> weekTasksMongoRepoById = weekTasksMongoRepository.findBy_id(weekId);
        return weekTasksMongoRepoById.map(weekTasksDataAccessMapper::weekTasksEntityToWeekTasksAggregateRoot).orElse(null);
    }
}
