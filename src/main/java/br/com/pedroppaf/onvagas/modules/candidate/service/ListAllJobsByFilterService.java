package br.com.pedroppaf.onvagas.modules.candidate.service;

import br.com.pedroppaf.onvagas.modules.company.entity.JobEntity;
import br.com.pedroppaf.onvagas.modules.company.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ListAllJobsByFilterService {

    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(String filter){
        return this.jobRepository.findByDescriptionContainingIgnoreCase(filter);
    }
}
