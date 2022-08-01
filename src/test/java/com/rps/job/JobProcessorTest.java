package com.rps.job;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class JobProcessorTest {

    private @Spy JobProcessor jobProcessor;

    @BeforeEach
    public void setUp() {
        doNothing().when(jobProcessor).optimize();
        doNothing().when(jobProcessor).processInputs();
        doNothing().when(jobProcessor).coreProcess();
    }

    @Test
    void job_process_executes_all_the_relevant_processes_and_then_returns_counts() {
        List<String> result = jobProcessor.process();
        verify(jobProcessor).optimize();
        verify(jobProcessor).processInputs();
        verify(jobProcessor).coreProcess();
        assertThat(result, everyItem(containsString("Counts")));
    }
}
