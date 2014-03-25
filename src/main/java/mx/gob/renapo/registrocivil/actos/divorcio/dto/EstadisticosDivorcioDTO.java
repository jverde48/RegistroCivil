package mx.gob.renapo.registrocivil.actos.divorcio.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;

@Data
@Component
public class EstadisticosDivorcioDTO {

	@Autowired
	private CatEscolaridadDTO escolaridadDivorciadoUno;
	@Autowired
	private CatEscolaridadDTO escolaridadDivorciadoDos;
	@Autowired
	private CatPuestoDTO posTrabDivorciadoUno;
	@Autowired
	private CatPuestoDTO posTrabDivorciadoDos;
	@Autowired
	private CatSituacionLaboralDTO sitLabDivorciadoUno;
	@Autowired
	private CatSituacionLaboralDTO sitLabDivorciadoDos;
}
