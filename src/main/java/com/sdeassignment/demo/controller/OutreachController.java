package com.sdeassignment.demo.controller;
import com.sdeassignment.demo.service.OutreachPipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/outreach")
public class OutreachController {

    @Autowired
    private OutreachPipelineService service;

    @PostMapping
    public String runPipeline(
            @RequestParam String domain) {

        service.execute(domain);

        return "Pipeline Executed Successfully";
    }
}
