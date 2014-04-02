package mx.gob.renapo.registrocivil.util;

import lombok.Data;
import mx.gob.renapo.registrocivil.util.dto.PersonaCertificadoDTO;
import mx.gob.renapo.registrocivil.util.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.impl.UtileriaServiceImpl;
import mx.gob.renapo.registrocivil.ws.consultaWS.ConsultaWS;
import mx.gob.renapo.registrocivil.ws.consultaWS.ConsultaWS_Service;
import mx.gob.renapo.registrocivil.ws.response.ActoSalud;
import mx.gob.renapo.registrocivil.ws.response.NacimientoRepActo;
import mx.gob.renapo.registrocivil.ws.response.NacimientoRespuesta;
import mx.gob.renapo.registrocivil.ws.response.NacimientoVerActo;
import org.apache.log4j.Logger;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Green4
 * Date: 6/03/14
 * Time: 05:02 PM
 * To change this template use File | Settings | File Templates.
 */

@Data
public class ConsultaInformacionService {
    private static Logger log = Logger.getLogger(ConsultaInformacionService.class);

    //@Autowired
    private ConsultaWS_Service consultaWSService;

    /**
     * valida el certificado para el registro de un nacimiento, verifica que sea valido.
     * @param dependencia - Estado donde se realiza el registro.
     * @param certificado - Numero del certificado a validar.
     * @return
     */
    public PersonaCertificadoDTO validarCertificadoNacimiento (String dependencia,
                String certificado) throws NoSuchAlgorithmException{
        ConsultaWS consultaWS = consultaWSService.getConsultaWSPort();
        String hash = crearCadena(dependencia, certificado);
        ActoSalud actoSalud = consultaWS.validaCertificadonacimiento(dependencia, certificado, hash);
        return getPersonaCertificadoConsulta(actoSalud);
    }

    /**
     * Reporta a salud que un certificado de nacimiento ha sido registrado.
     * @param dependencia - Estado donde se realiza el registro.
     * @param nacimietoRegistro - Datos del Registrado.
     * @return regreasa un booleano de que el registro fue exitoso.
     */
    public boolean reportaCertificadoNacimiento(String dependencia, String certificado,
                NacimientoVerActo nacimietoRegistro) throws NoSuchAlgorithmException{
        ConsultaWS consultaWS = consultaWSService.getConsultaWSPort();
        String hash = crearCadena(dependencia, certificado);
        return consultaWS.reportaCertificadonacimiento(dependencia, certificado, nacimietoRegistro, hash);
    }

    /**
     * Valida que el nacimimento no se haya registrado con anterioridad .
     * @param dependencia - Estado donde se realiza el Registro.
     * @param nombre - Nombre del registrado.
     * @param primerApellido - Primer apellido del Registrado.
     * @param segundoApellido - Segundo apellido del registrado.
     * @param fechaNacimiento - Fecha de nacimiento del registrado.
     * @param sexo - Sexo del Registrado.
     * @param estadoNacimiento - Estado Nacimiento del Registrado.
     * @param curpPadre - Curp del Padre del registrado.
     * @param curpMadre - Curp de la Madre del registrado.
     * @return - Devuelve un boleano indicando si el nacimento es valido para
     * registrar.
     */
    public boolean validarNacimiento (String dependencia, String nombre, String primerApellido,
                String segundoApellido, Date fechaNacimiento, String sexo, Long estadoNacimiento,
                String curpPadre, String curpMadre) throws NoSuchAlgorithmException {
        ConsultaWS consultaWS = consultaWSService.getConsultaWSPort();

        String fechaNacimientoString = UtileriaServiceImpl.convertirFecha(fechaNacimiento);
        String hash = crearCadena(dependencia, nombre, primerApellido, segundoApellido,
                fechaNacimientoString, sexo, String.valueOf(estadoNacimiento), curpPadre, curpMadre);

        return consultaWS.validaNacimiento(dependencia, nombre, primerApellido, segundoApellido,
                fechaNacimientoString, sexo, estadoNacimiento.intValue(), curpPadre, curpMadre, hash);
    }

    public List<PersonaDTO> consultaPersona (String dependencia, HashMap<String, String> datosPersonales,
                String curp, String cadena) throws NoSuchAlgorithmException {
        String hash;
        NacimientoRespuesta nacimientoRespuesta = null;
        ConsultaWS consultaWS = consultaWSService.getConsultaWSPort();

        if (datosPersonales != null && !datosPersonales.isEmpty()) {
            hash = crearCadena(dependencia, datosPersonales.get("nombre"), datosPersonales.get("primerApellido"),
                    datosPersonales.get("segundoApellido"), datosPersonales.get("fechaNacimiento"),
                    datosPersonales.get("sexo"), String.valueOf(datosPersonales.get("estado")));

            nacimientoRespuesta = consultaWS.consultaNAcompleto(dependencia, curp, cadena,
                    datosPersonales.get("nombre"), datosPersonales.get("primerApellido"),
                    datosPersonales.get("segundoApellido"), datosPersonales.get("fechaNacimiento"),
                    datosPersonales.get("sexo"), Integer.parseInt(datosPersonales.get("estado")), hash);
        } else if (curp != null || !curp.isEmpty()) {
            hash = crearCadena(dependencia, curp);
            nacimientoRespuesta = consultaWS.consultaNAcompleto(dependencia, curp, cadena, null,
                    null, null, null, null, null, hash);
        } else  if (cadena != null || !cadena.isEmpty()) {
            hash = crearCadena(dependencia, cadena);
            nacimientoRespuesta = consultaWS.consultaNAcompleto(dependencia, curp, cadena, null,
                    null, null, null, null, null, hash);
        }
        return getPersonaConsulta(nacimientoRespuesta);
    }

    /**
     * Devuelve el hash encriptado con la informacion que recibe
     * @param cadenaInformacion - Contacatenacion de la informacion que se envia al WS de consulta
     * @return
     */
    private static String getHash(String cadenaInformacion)
            throws NoSuchAlgorithmException {
        return Hasher.getHashDigest(cadenaInformacion, ConstantesComunes.SHA1);
    }

    /**
     * Concatena la informacion pasada en los argumentos
     * @param datosHash - Informacion para generar la cadena de hash.
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static String crearCadena(String... datosHash)
            throws NoSuchAlgorithmException {
        StringBuilder cadenaDatosHash = new StringBuilder();

        for (String dato : datosHash)
            cadenaDatosHash.append(dato);

        String hash = getHash(cadenaDatosHash.toString());
        cadenaDatosHash = null;
        return hash;
    }


    /**
     * Pasa la informacion devuelta por el WS cuando se consulta una persona a un objeto de tipo PersonaDTO.
     * @param nacimientoRespuesta - Objeto que devuelve el WS con la informacion de la persona buscada.
     * @return - Devuelve un objeto de tipo PersonaDTO.
     */
    private List<PersonaDTO> getPersonaConsulta(NacimientoRespuesta nacimientoRespuesta) {
        List<PersonaDTO> listaPersonas = null;

        if (nacimientoRespuesta.getError().equals(ConstantesComunes.NO_ERRORS)) {
            listaPersonas = new ArrayList<PersonaDTO>();
            if (nacimientoRespuesta.getNacimientos() != null &&
                    !nacimientoRespuesta.getNacimientos().isEmpty()) {
                for (NacimientoRepActo nacimiento : nacimientoRespuesta.getNacimientos()) {
                    //Datos de la persona
                    PersonaDTO persona = new PersonaDTO();
                    persona.setNombre(nacimiento.getNombre());
                    persona.setPrimerApellido(nacimiento.getPrimerApellido());
                    persona.setSegundoApellido(nacimiento.getSegundoApellido());
                    persona.setFechaNacimiento(UtileriaServiceImpl.convertirStringToDate(nacimiento.getFechaNacimiento()));
                    persona.setSexo(nacimiento.getSexo());
                    persona.setCurp(nacimiento.getCurp());
                    //persona.setVivoMuerto(nacimiento.getVivoMuerto());

                    //Datos del lugar de nacimiento
                    persona.setIdEstadoNacimiento(Integer.parseInt(nacimiento.getEstadoNac()));
                    persona.setEstadoNacimiento(nacimiento.getEstadoNacNombre());
                    persona.setIdMunicipioNacimiento(Integer.parseInt(nacimiento.getMunicipioNac()));
                    persona.setMunicipioNacimiento(nacimiento.getMunicipioNacNombre());
                    persona.setLocalidad(nacimiento.getLocalidad());

                    //Datos del lugar y fecha de registro
                    persona.setIdEstadoRegistro(Integer.parseInt(nacimiento.getEstadoReg()));
                    persona.setEstadoRegistro(nacimiento.getEstadoRegNombre());
                    persona.setIdMunicipioRegistro(Integer.parseInt(nacimiento.getMunicipioReg()));
                    persona.setMunicipioRegistro(nacimiento.getMunicipioRegNombre());
                    persona.setIdOficialia(Long.parseLong(nacimiento.getOficialia()));
                    persona.setOficialiaRegistro(nacimiento.getOficialiaNombre());
                    persona.setAnioRegistro(Integer.parseInt(nacimiento.getAnioRegistro()));
                    persona.setFechaRegistro(UtileriaServiceImpl.convertirStringToDate(nacimiento.getFechaRegistro()));

                    //Datos de los Padres
                    //Progenitor Uno
                    persona.setNombreProgenitorUno(nacimiento.getNombrePrimeraPersona());
                    persona.setPrimerApellidoProgenitorUno(nacimiento.getPrimerApellidoPrimeraPersona());
                    persona.setSegundoApellidoProgenitorUno(nacimiento.getSegundoApellidoPrimeraPersona());
                    persona.setCurpProgenitorUno(nacimiento.getCurpMADRE());

                    persona.setNombreProgenitorDos(nacimiento.getNombreSegundaPersona());
                    persona.setPrimerApellidoProgenitorDos(nacimiento.getPrimerApellidoSegundaPersona());
                    persona.setSegundoApellidoProgenitorDos(nacimiento.getSegundoApellidoSegundaPersona());
                    persona.setCurpProgenitorDos(nacimiento.getCurpPADRE());

                    //Datos del Acta
                    persona.setActaBis(nacimiento.getActaBis());
                    persona.setFoja(nacimiento.getFoja());
                    persona.setLibro(nacimiento.getLibro());
                    persona.setTomo(nacimiento.getTomo());
                    persona.setFolio(nacimiento.getFolio());
                    persona.setNumeroActa(nacimiento.getNumeroActa());
                    persona.setSsa(nacimiento.getSsa());

                    listaPersonas.add(persona);
                }
            }

        } else if (nacimientoRespuesta.getError().equals(ConstantesComunes.NO_EXISTE)){
            listaPersonas = new ArrayList<PersonaDTO>();
            log.info("El registro buscado no existe, mensaje de error: " + nacimientoRespuesta.getMsgError());
        } else if (nacimientoRespuesta.getError().equals(ConstantesComunes.DATOS_INVALIDOS)) {

            log.info("Los datos proporcionados no son validos, mensaje de error: " + nacimientoRespuesta.getMsgError());
        } else if (nacimientoRespuesta.getError().equals(ConstantesComunes.HASH_INVALIDO)) {
            log.info("El hash generado no es valido.");
        }

        return listaPersonas;
    }

    /**
     * Pasa la informacion devuelta cuando se consulta un certificado de nacimiento a un
     * objeto de tipo PersonaCertificadoDTO.
     * @param actoSalud - Informacion del certifcado de salud con los datos de registrado.
     * @return - Devuelve un objeto de tipo PersonaCertificadoDTO.
     */
    private PersonaCertificadoDTO getPersonaCertificadoConsulta(ActoSalud actoSalud) {
        PersonaCertificadoDTO personaCertificado = new PersonaCertificadoDTO();

        if (actoSalud.getRespuesta() == 1) {
            personaCertificado.setCodigoRespuesta(Integer.parseInt(ConstantesComunes.NO_ERRORS));
            //Datos del recien nacido
            personaCertificado.setNombre(actoSalud.getNombre());
            personaCertificado.setPrimerApellido(actoSalud.getPrimerApellido());
            personaCertificado.setSegundoApellido(actoSalud.getSegundoApellido());
            personaCertificado.setFechaNacimiento(UtileriaServiceImpl.convertirStringToDate(actoSalud.getFechaNacimiento()));

            //Datos del lugar de nacimiento
            personaCertificado.setIdEstadoNacimiento(Integer.parseInt(actoSalud.getEstadoNac()));
            personaCertificado.setEstadoNacimiento(actoSalud.getEstadoNacNombre());
            personaCertificado.setIdMunicipioNacimiento(Integer.parseInt(actoSalud.getMunicipioNac()));
            personaCertificado.setMunicipioNacimiento(actoSalud.getMunicipioNacNombre());

            //Datos del Padre (Madre)
            personaCertificado.setNombreProgenitorUno(actoSalud.getNombrePrimeraPersona());
            personaCertificado.setPrimerApellidoProgenitorUno(actoSalud.getPrimerApellidoPrimeraPersona());
            personaCertificado.setSegundoApellidoProgenitorUno(actoSalud.getSegundoApellidoPrimeraPersona());
        } else if (actoSalud.getRespuesta() == 2){
            personaCertificado.setCodigoRespuesta(Integer.parseInt(ConstantesComunes.NO_EXISTE));
            log.info("El registro buscado no existe, mensaje de error: ");
        } else if (actoSalud.getRespuesta() == 3) {
            personaCertificado.setCodigoRespuesta(Integer.parseInt(ConstantesComunes.DATOS_INVALIDOS));
            log.info("Los datos proporcionados no son validos, mensaje de error: ");
        } else if (actoSalud.getRespuesta() == 4) {
            log.info("El hash generado no es valido.");
        }

        return personaCertificado;
    }
}
