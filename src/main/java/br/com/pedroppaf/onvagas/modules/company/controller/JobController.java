package br.com.pedroppaf.onvagas.modules.company.controller;

import br.com.pedroppaf.onvagas.modules.company.entity.JobEntity;
import br.com.pedroppaf.onvagas.modules.company.service.CreateJobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private CreateJobService jobService;

    @PostMapping("/")
    public JobEntity create(@Valid @RequestBody JobEntity jobEntity){
        return this.jobService.execute(jobEntity);
    }
}
