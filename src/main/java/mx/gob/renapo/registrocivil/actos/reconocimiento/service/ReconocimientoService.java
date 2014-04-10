package mx.gob.renapo.registrocivil.actos.reconocimiento.service;

import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ReconocimientoDTO;

public interface ReconocimientoService {

    public ReconocimientoDTO registrarReconocimiento(ReconocimientoDTO reconocimientoDTO, Integer PersonaOtorgaConsentimiento);

}
