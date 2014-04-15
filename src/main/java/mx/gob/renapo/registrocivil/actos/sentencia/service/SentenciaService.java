package mx.gob.renapo.registrocivil.actos.sentencia.service;

import mx.gob.renapo.registrocivil.actos.sentencia.dto.SentenciaDTO;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 10/04/14
 * Time: 01:32 PM
 * To change this template use File | Settings | File Templates.
 */
public interface SentenciaService {

    void guardarSentencia(SentenciaDTO sentenciaDTO);

    void editarSentencia (SentenciaDTO sentenciaDTO);


}
