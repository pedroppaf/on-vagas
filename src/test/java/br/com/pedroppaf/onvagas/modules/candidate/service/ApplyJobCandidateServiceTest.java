package br.com.pedroppaf.onvagas.modules.candidate.service;

import br.com.pedroppaf.onvagas.exceptions.UserNotFoundException;
import br.com.pedroppaf.onvagas.modules.candidate.repository.CandidateRepository;
import br.com.pedroppaf.onvagas.modules.company.repository.JobRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateServiceTest {

    @InjectMocks
    private ApplyJobCandidateService applyJobCandidateService;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;

    @Test
    public void should_not_be_able_to_apply_job_with_candidate_not_found(){
        try {
            applyJobCandidateService.execute(null, null);
        }catch (Exception e) {
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }
    }
}
