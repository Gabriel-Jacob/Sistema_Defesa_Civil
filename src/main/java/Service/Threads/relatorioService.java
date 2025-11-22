package Service.Threads;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.Threads.relatorioModel;
import Repository.Threads.relatorioRepository;

@Service
public class relatorioService {

	@Autowired
	private relatorioRepository rr;

	public List<relatorioModel> getAll() {

		return rr.findAll();
	}
}
