package Model.Threads;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class relatorioModel {

	private Long id;
	private LocalDateTime dataGeracao;
	private String resumo;
	private int qtdOcorrenciasProcessadas;
	
}
