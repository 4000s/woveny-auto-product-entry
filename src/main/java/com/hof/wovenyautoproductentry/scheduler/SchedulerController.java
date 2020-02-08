package com.hof.wovenyautoproductentry.scheduler;

import com.hof.wovenyautoproductentry.service.ChairishRugEntryService;
import com.hof.wovenyautoproductentry.service.EtsyRugEntryService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SchedulerController {

    private final EtsyRugEntryService etsyRugEntryService;
    private final ChairishRugEntryService chairishRugEntryService;

    public SchedulerController(EtsyRugEntryService etsyRugEntryService, ChairishRugEntryService chairishRugEntryService) {
        this.etsyRugEntryService = etsyRugEntryService;
        this.chairishRugEntryService = chairishRugEntryService;
    }

    @Scheduled(cron = "10 11 22 * * ?")
    public void etsyRugEntry() {
        System.out.println(
                "Cron -" + System.currentTimeMillis() / 1000);
    }

    @Scheduled(fixedRate = 1000 * 100)
    public void scheduleEtsyRugEntry() throws InterruptedException {
        System.out.println(
                "Fixed rate task - " + System.currentTimeMillis() / 1000 + " " + new Date() + " Etsy rug entry job is started.");
        this.etsyRugEntryService.execute();
        System.out.println(
                "Fixed rate task - " + System.currentTimeMillis() / 1000 + " " + new Date() + " Etsy rug entry job is finished.");
    }
    //@Scheduled(fixedRate = 1000 * 100)
    public void scheduleChairishRugEntry() throws InterruptedException {
        System.out.println(
                "Fixed rate task - " + System.currentTimeMillis() / 1000 + " " + new Date() + " Chairish rug entry job is started.");
        this.chairishRugEntryService.execute();
        System.out.println(
                "Fixed rate task - " + System.currentTimeMillis() / 1000 + " " + new Date() + " Chairish rug entry job is finished.");
    }
}
