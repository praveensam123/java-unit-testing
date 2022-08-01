package com.rps.job;

import java.util.List;

public class JobProcessor {

    private final JobOptimizer jobOptimizer;
    private final InputProcessor inputProcessor;
    private final CoreProcessor coreProcessor;
    private final OutputProcessor outputProcessor;

    public JobProcessor() {
        this.jobOptimizer = new JobOptimizer();
        this.inputProcessor = new InputProcessor();
        this.coreProcessor = new CoreProcessor();
        this.outputProcessor = new OutputProcessor();
    }

    public List<String> process() {
        optimize();
        processInputs();
        coreProcess();
        return outputProcessor.process();
    }

    void optimize() {
        jobOptimizer.firstLevelOptimize();
        jobOptimizer.secondLevelOptimize();
        jobOptimizer.thirdLevelOptimize();
    }

    void processInputs() {
        inputProcessor.firstLevelProcess();
        inputProcessor.secondLevelProcess();
        inputProcessor.thirdLevelProcess();
    }

    void coreProcess() {
        coreProcessor.firstLevelProcess();
        coreProcessor.secondLevelProcess();
        coreProcessor.thirdLevelProcess();
    }
}
