package mx.gob.renapo.registrocivil.actos.divorcio.util;

import mx.gob.renapo.registrocivil.actos.divorcio.dto.DivorcioDTO;
import mx.gob.renapo.registrocivil.actos.divorcio.entity.Divorcio;

public interface DivorcioUtilService {

	DivorcioDTO mapearEntityDivorcioADTO(Divorcio diorcioEntity);
}
