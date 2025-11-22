package Service.Threads;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.Threads.ocorrenciaModel;
import Repository.Threads.ocorrenciaRepository;

@Service
public class ocorrenciaService {

	@Autowired
	private ocorrenciaRepository or;

	public List<ocorrenciaModel> getAll() {

		return or.findAll();
	}

	public ocorrenciaModel salvarOcorrencia(ocorrenciaModel om) {

		return or.save(om);
	}
	
	public Optional<ocorrenciaModel> atualizarOcorrencia(Long id, ocorrenciaModel om) {
		
		Optional<ocorrenciaModel> existente = or.findById(id);
		
	if (existente.isPresent()) {
		
		ocorrenciaModel modificada = existente.get();
		
		modificada.setDatahora(om.getDatahora());
		modificada.setLocal (om.getLocal());
		modificada.setDescricao(om.getDescricao());
		modificada.setStatus(om.getStatus());
		
		return Optional.of(or.save(modificada));
	}
	
	else {
		
		return Optional.empty();
	}
	
	}
}
