package br.com.pedroppaf.onvagas.modules.candidate.service;

import br.com.pedroppaf.onvagas.exceptions.UserFoundException;
import br.com.pedroppaf.onvagas.modules.candidate.entity.CandidateEntity;
import br.com.pedroppaf.onvagas.modules.candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidate){
        this.candidateRepository
                .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.candidateRepository.save(candidate);

    }
}
