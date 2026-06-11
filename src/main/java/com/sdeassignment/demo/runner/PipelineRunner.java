package com.sdeassignment.demo.runner;

import com.sdeassignment.demo.service.OutreachPipelineService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class PipelineRunner implements CommandLineRunner {

    private final OutreachPipelineService pipelineService;

    public PipelineRunner(OutreachPipelineService pipelineService) {
        this.pipelineService = pipelineService;
    }

    @Override
    public void run(String... args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Company Domain:");

        String domain = scanner.nextLine();

        pipelineService.execute(domain);
    }
}