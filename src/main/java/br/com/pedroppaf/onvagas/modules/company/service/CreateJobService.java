package br.com.pedroppaf.onvagas.modules.company.service;

import br.com.pedroppaf.onvagas.exceptions.CompanyNotFoundException;
import br.com.pedroppaf.onvagas.modules.company.entity.JobEntity;
import br.com.pedroppaf.onvagas.modules.company.repository.CompanyRepository;
import br.com.pedroppaf.onvagas.modules.company.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity jobEntity) {
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });
        return this.jobRepository.save(jobEntity);
    }
}
