package com.restep.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author restep
 * @date 2019/10/3
 */
@Component
public class PlanSchedule {
    private int count = 0;

    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        System.out.println(count++);
    }
}
