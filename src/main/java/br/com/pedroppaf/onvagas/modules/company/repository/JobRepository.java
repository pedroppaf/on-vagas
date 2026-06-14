package br.com.pedroppaf.onvagas.modules.company.repository;

import br.com.pedroppaf.onvagas.modules.company.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
}
