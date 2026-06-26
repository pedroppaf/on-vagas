package br.com.pedroppaf.onvagas.modules.candidate.service;

import br.com.pedroppaf.onvagas.exceptions.JobNotFoundException;
import br.com.pedroppaf.onvagas.exceptions.UserNotFoundException;
import br.com.pedroppaf.onvagas.modules.candidate.repository.ApplyJobRepository;
import br.com.pedroppaf.onvagas.modules.candidate.repository.CandidateRepository;
import br.com.pedroppaf.onvagas.modules.company.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    public void execute(UUID idCandidate, UUID idJob){
        this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {throw new UserNotFoundException();
                });

        this.jobRepository.findById(idJob)
                .orElseThrow(() -> {throw new JobNotFoundException();
                });

    }
}
