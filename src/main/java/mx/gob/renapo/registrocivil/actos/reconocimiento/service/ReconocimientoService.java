package mx.gob.renapo.registrocivil.actos.reconocimiento.service;

import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ReconocimientoDTO;

import java.util.List;

public interface ReconocimientoService {

    public ReconocimientoDTO registrarReconocimiento(ReconocimientoDTO reconocimientoDTO,
                                                     Integer PersonaOtorgaConsentimiento);

    public void eliminarReconocimiento(Long idReconocimiento);

    public List<ReconocimientoDTO> consultaReconocimientoCadena(String cadena);

    public List<ReconocimientoDTO> consultaReconocimientoNumeroActa(Integer anio, String numeroActa);

}
