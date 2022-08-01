package com.rps.job;

import java.util.Optional;

public class JobOptimizer {

    private final JobRepository jobRepository;

    public JobOptimizer() {
        this.jobRepository = new JobRepository();
    }

    public void optimize() {
        Optional.of(jobRepository)
                .map(JobRepository::fetchOptimizeParams)
                .filter(param -> param.contains("Active"))
                .map(JobRepository::tune)
                .orElseThrow(() -> new RuntimeException("Params fetch failed"));
    }

    public void firstLevelOptimize() {
        optimize();
    }

    public void secondLevelOptimize() {
        optimize();
    }

    public void thirdLevelOptimize() {
        optimize();
    }
}
