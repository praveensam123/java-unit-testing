package com.rps.job;

import java.util.List;

public class JobRepository {
    public List<String> fetchOptimizeParams() {
        return List.of();
    }

    public static List<String> tune(List<String> params) {
        return params;
    }

    public List<String> validResult() {
        return List.of("Feature Counts", "Part Counts");
    }
}
