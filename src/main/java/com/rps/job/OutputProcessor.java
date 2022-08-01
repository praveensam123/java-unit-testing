package com.rps.job;

import java.util.List;

public class OutputProcessor {

    private final JobRepository jobRepository;

    public OutputProcessor() {
        this.jobRepository = new JobRepository();
    }

    public List<String> process() {
        return jobRepository.validResult();
    }
}
