package Controller.Threads;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Threads.relatorioModel;
import Service.Threads.relatorioService;

@RestController
@RequestMapping("relatorios")
public class relatorioController {

	@Autowired
	relatorioService rs;

	@GetMapping("/relatorios")
	public List<relatorioModel> getAll() {
		List<relatorioModel> relatorios = rs.getAll();

		return relatorios;
	}

	@PostMapping("/relatorios/gerar")
	public ResponseEntity<?> gerarRelatorio() {

		return ResponseEntity.ok(null);
	}
}
