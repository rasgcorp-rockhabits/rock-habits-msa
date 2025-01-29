package com.rockhabits.rockhabitsmsa.domain.applicationservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
public class Tasks {
    @NotNull
    private final String day;
    @NotNull
    private final Map<String, Boolean> tasks;
}
