package com.rps.job;

import java.util.Optional;

public class InputProcessor {

    private final JobRepository jobRepository;

    public InputProcessor() {
        this.jobRepository = new JobRepository();
    }

    private void process() {
        Optional.of(jobRepository)
                .map(JobRepository::fetchOptimizeParams)
                .filter(param -> param.contains("Input"))
                .map(JobRepository::tune)
                .orElseThrow(() -> new RuntimeException("Input Processor failed"));
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
