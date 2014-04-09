package mx.gob.renapo.registrocivil.actos.divorcio.dto;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatRegimenDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoDivorcioDTO;
import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class ActaDivorcioDTO extends ActaDTO{

	private Date fechaEjecutoria;
	private Date fechaResolucion;
	private String resolucionAdmin;
	private String autoridad;
	
	@Autowired
	private CatTipoDivorcioDTO tipoDivorcio;
}
