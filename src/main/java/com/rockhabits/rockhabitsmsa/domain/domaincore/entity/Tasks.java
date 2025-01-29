package com.rockhabits.rockhabitsmsa.domain.domaincore.entity;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class Tasks {
    private String day;
    private Map<String, Boolean> tasks;
}
