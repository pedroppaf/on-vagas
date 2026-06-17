package br.com.pedroppaf.onvagas.modules.company.controller;

import br.com.pedroppaf.onvagas.modules.company.dto.CreateJobDTO;
import br.com.pedroppaf.onvagas.modules.company.entity.JobEntity;
import br.com.pedroppaf.onvagas.modules.company.service.CreateJobService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private CreateJobService jobService;

    @PostMapping("/")
    public JobEntity create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request){
        var companyId = request.getAttribute("company_id");

        var jobEntity = JobEntity.builder()
                .benefits(createJobDTO.getBenefits())
                .companyId(UUID.fromString(companyId.toString()))
                .description(createJobDTO.getDescription())
                .level(createJobDTO.getLevel())
                .build();

        return this.jobService.execute(jobEntity);
    }
}
