package br.com.pedroppaf.onvagas.modules.company.service;

import br.com.pedroppaf.onvagas.modules.company.entity.JobEntity;
import br.com.pedroppaf.onvagas.modules.company.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobService {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);

    }
}
