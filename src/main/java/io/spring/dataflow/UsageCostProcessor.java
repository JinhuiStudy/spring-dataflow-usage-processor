package io.spring.dataflow;


import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsageCostProcessor {

    private final double ratePerSecond = 0.1;

    private final double ratePerMB = 0.05;

    @Bean
    public Function<UsageDetail, UsageCostDetail> processUsageCost() {
        return usageDetail -> {
            UsageCostDetail usageCostDetail = new UsageCostDetail();
            usageCostDetail.setUserId(usageDetail.getUserId());
            usageCostDetail.setCallCost(usageDetail.getDuration() * this.ratePerSecond);
            usageCostDetail.setDataCost(usageDetail.getData() * this.ratePerMB);
            return usageCostDetail;
        };
    }
}