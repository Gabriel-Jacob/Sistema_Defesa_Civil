package Repository.Threads;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Model.Threads.ocorrenciaModel;

@Repository
public interface ocorrenciaRepository extends JpaRepository<ocorrenciaModel, Long> {

}
