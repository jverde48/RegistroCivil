package mx.gob.renapo.registrocivil.actos.divorcio.service;

import mx.gob.renapo.registrocivil.actos.divorcio.dto.DivorcioDTO;

public interface DivorcioService {

	/**
     * Metodo para el registro de un nuevo divorcio
     * @param divorcioDTO
     */
    void guardarDivorcio(DivorcioDTO divorcioDTO);

    /**
     * Metodo para la edicion de un divorcio
     * @param divorcioDTO
     */
    void editarDivorcio(DivorcioDTO divorcioDTO);
}
