package mx.gob.renapo.registrocivil.util;

import mx.gob.renapo.registrocivil.util.dto.PersonaCertificadoDTO;
import mx.gob.renapo.registrocivil.util.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.ws.response.NacimientoVerActo;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Green4
 * Date: 21/04/14
 * Time: 07:24 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ConsultaInformacionService {
    PersonaCertificadoDTO validarCertificadoNacimiento(String dependencia,
                                                       String certificado) throws NoSuchAlgorithmException;

    boolean reportaCertificadoNacimiento(String dependencia, String certificado,
                                         NacimientoVerActo nacimietoRegistro) throws NoSuchAlgorithmException;

    boolean validarNacimiento (String dependencia, String nombre, String primerApellido,
                               String segundoApellido, Date fechaNacimiento, String sexo, Long estadoNacimiento,
                               String curpPadre, String curpMadre) throws NoSuchAlgorithmException;

    List<PersonaDTO> consultaPersona (String dependencia, HashMap<String, Object> datosPersonales,
                                      String curp, String cadena) throws NoSuchAlgorithmException;

    mx.gob.renapo.registrocivil.ws.consultaWS.ConsultaWS_Service getConsultaWSService();

    void setConsultaWSService(mx.gob.renapo.registrocivil.ws.consultaWS.ConsultaWS_Service consultaWSService);
}
