package mx.gob.renapo.registrocivil.actos.adopcion.service;

import mx.gob.renapo.registrocivil.actos.adopcion.dto.AdopcionDTO;

public interface AdopcionService {
    public AdopcionDTO guardarAdopcion(AdopcionDTO adopcionDTO, Boolean abueloUnoAdotante,
                                       Boolean abueloDosAdoptante);
}
