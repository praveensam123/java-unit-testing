package com.rps.job;

import java.util.Optional;

public class CoreProcessor {

    private final JobRepository jobRepository;

    public CoreProcessor() {
        this.jobRepository = new JobRepository();
    }

    private void process() {
        Optional.of(jobRepository)
                .map(JobRepository::fetchOptimizeParams)
                .filter(param -> param.contains("Core"))
                .map(JobRepository::tune)
                .orElseThrow(() -> new RuntimeException("Core Processor failed"));
    }

    public void firstLevelProcess() {
        process();
    }

    public void secondLevelProcess() {
        process();
    }

    public void thirdLevelProcess() {
        process();
    }
}
