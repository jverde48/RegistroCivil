package mx.gob.renapo.registrocivil.actos.adopcion.service;

import mx.gob.renapo.registrocivil.actos.adopcion.dto.AdopcionDTO;

import java.util.List;

public interface AdopcionService {
    public AdopcionDTO guardarAdopcion(AdopcionDTO adopcionDTO, Boolean abueloUnoAdotante,
                                       Boolean abueloDosAdoptante);
    List<AdopcionDTO> consultaAdopcionPorCadena(String cadenaValue);

    List<AdopcionDTO> consultaAdopcionPorNumeroActa(int i, String s);
}
