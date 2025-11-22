package Repository.Threads;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Model.Threads.relatorioModel;

@Repository
public interface relatorioRepository extends JpaRepository<relatorioModel, Long> {

}
