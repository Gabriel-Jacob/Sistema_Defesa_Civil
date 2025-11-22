package Controller.Threads;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Threads.ocorrenciaModel;
import Service.Threads.ocorrenciaService;

@RestController
@RequestMapping("ocorrencias")
public class ocorrenciasController {

	@Autowired
	ocorrenciaService os;

	@GetMapping("/ocorrencias")
	public List<ocorrenciaModel> getAll() {
		List<ocorrenciaModel> ocorrencias = os.getAll();

		return ocorrencias;
	}

	@PostMapping("/ocorrencias")
	public ResponseEntity<?> criarOcorrencia(@RequestBody ocorrenciaModel om) {

		ocorrenciaModel nova = os.salvarOcorrencia(om);

		return ResponseEntity.ok(nova);
	}
	
	@PutMapping("/ocorrencias/{id}")
	public ResponseEntity<?> atualizarOcorrencia (@PathVariable Long id, @RequestBody ocorrenciaModel om){
			
			Optional<ocorrenciaModel> atualizada = os.atualizarOcorrencia(id, om);
			
			if (atualizada.isPresent()) {
				
				return ResponseEntity.ok(atualizada);
			}
			else {
				
				return ResponseEntity.notFound().build();
			}

}

}