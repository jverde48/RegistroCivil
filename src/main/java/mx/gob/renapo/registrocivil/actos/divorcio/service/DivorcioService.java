package mx.gob.renapo.registrocivil.actos.divorcio.service;

import java.util.List;

import mx.gob.renapo.registrocivil.actos.divorcio.dto.DivorcioDTO;

public interface DivorcioService {

	/**
     * Metodo para el registro de un nuevo divorcio
     * @param divorcioDTO
     */
    public DivorcioDTO guardarDivorcio(DivorcioDTO divorcioDTO);

    /**
     * Metodo para la edicion de un divorcio
     * @param divorcioDTO
     */
    void editarDivorcio(DivorcioDTO divorcioDTO);
    
    /**
     * Metodo para consultar un divorcio por la cadena
     * @param cadena
     * @return DivorcioDTO
     */
    public List<DivorcioDTO> consultaDivorcioPorCadena(String cadena);
    
    public List<DivorcioDTO> consultaDivorcioPorNumeroActa(Integer anio, String numeroActa);
}
