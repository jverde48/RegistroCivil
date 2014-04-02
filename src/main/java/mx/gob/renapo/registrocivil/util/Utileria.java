package mx.gob.renapo.registrocivil.util;

import mx.gob.renapo.registrocivil.catalogos.dao.*;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.catalogos.service.CatColoniaLocalidadService;
import mx.gob.renapo.registrocivil.comun.dto.DomicilioDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.entity.Domicilio;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 10/03/14
 * Time: 12:27
 * To change this template use File | Settings | File Templates.
 */

@Service
public class Utileria {

    @Autowired
    private CatCompareceDAO compareceDAO;

    @Autowired
    private CatDestinoCadaverDAO destinoCadaverDAO;

    @Autowired
    private CatLugarFalleceDAO lugarFalleceDAO;

    @Autowired
    private CatEscolaridadDAO escolaridadDAO;

    @Autowired
    private CatEstadoCivilDAO estadoCivilDAO;

    @Autowired
    private CatLugarPartoDAO lugarPartoDAO;

    @Autowired
    private CatParentescoDAO parentescoDAO;

    @Autowired
    private CatPuestoDAO puestoDAO;

    @Autowired
    private CatRegimenDAO regimenDAO;
    @Autowired
    private CatSituacionLaboralDAO situacionLaboralDAO;
    @Autowired
    private CatTipoDivorcioDAO tipoDivorcioDAO;
    @Autowired
    private CatTipoDocumentoDAO tipoDocumentoDAO;
    @Autowired
    private CatTipoLocalidadDAO tipoLocalidadDAO;
    @Autowired
    private CatTipoOficialiaDAO tipoOficialiaDAO;
    @Autowired
    private CatTipoOperacionDAO tipoOperacionDAO;
    @Autowired
    private CatTipoPartoDAO tipoPartoDAO;
    @Autowired
    private CatTipoSentenciaDAO tipoSentenciaDAO;
    @Autowired
    private CatOficialiaDAO oficialiaDAO;

    @Autowired
    private CatColoniaLocalidadService coloniaLocalidadService;

    /**
     * Convierte una fecha a string con el formato dd/MM/yyyy.
     * @param fecha - Fecha de tipo Date a converit.
     * @return - Regresa un String con el formato especificado.
     */
    public static String convertirFecha(Date fecha) {
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(fecha);
    }

    /**
     * Convierte una fecha String a una de tipo Date
     * @param stringFecha - String de fecha.
     * @return - Regresa un objeto de tipo Date
     */
    public static Date convertirStringToDate(String stringFecha) {
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");

        try {
            date = formatter.parse(stringFecha);
            formatter.format(date);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        return date;
    }

    /**
     * Crea y devuelve un mapa con la informacion de los datos personales de una persona
     * @return - Devuelve un map de datos personales.
     */
    public static HashMap<String, String> getDatosPersonales(String nombre, String primerApellido,
                     String segundoApellido, Date fechaNacimiento, String sexo, CatEstado estado) {
        HashMap<String, String> mapDatosPersonales = new HashMap<String, String>();
        mapDatosPersonales.put("nombre", nombre);
        mapDatosPersonales.put("primerApellido", primerApellido);
        mapDatosPersonales.put("segundoApellido", segundoApellido);
        mapDatosPersonales.put("fechaNacimiento", convertirFecha(fechaNacimiento));
        mapDatosPersonales.put("sexo", sexo);
        mapDatosPersonales.put("estado", estado.getDescripcion());

        return mapDatosPersonales;
    }

    public static CatMunicipio mapearDTOAEntityMunicipio(MunicipioDTO municipioDTO) {
        CatMunicipio municipio = new CatMunicipio();
        municipio.setId(municipio.getId());
        municipio.setNombre(municipio.getNombre());
        return municipio;
    }

    public static CatInegiMunicipio mapearDTOAEntityInegiMunicipio(MunicipioDTO municipioDTO) {
        CatInegiMunicipio municipio = new CatInegiMunicipio();
        municipio.setId(municipioDTO.getId());
        municipio.setDescripcion(municipioDTO.getNombreMunicipio());
        return municipio;
    }

    public static CatEstado mapearDTOAEntityEstado(EstadoDTO estadoDTO) {
        CatEstado estado = new CatEstado();
        estado.setId(estadoDTO.getId());
        estado.setIdRenapo(estadoDTO.getIdRenapo());
        estado.setDescripcion(estadoDTO.getNombreEstado());
        return estado;

    }

    public static CatInegiEstado mapearDTOAEntityInegiEstado(EstadoDTO estadoDTO) {
        CatInegiEstado estado = new CatInegiEstado();
        estado.setId(estadoDTO.getId());
        estado.setDescripcion(estadoDTO.getNombreEstado());
        return estado;

    }

    public static CatPais mapearDTOAEntityPais(PaisDTO paisDTO) {
        CatPais pais = new CatPais();
        pais.setId(paisDTO.getId());
        pais.setDescripcion(paisDTO.getDescripcion());
        return pais;

    }

    public static CatInegiPais mapearDTOEntityPaisInegi(PaisDTO paisDTO) {
        CatInegiPais inegiPais = new CatInegiPais();
        inegiPais.setId(paisDTO.getId());
        inegiPais.setDescripcion(paisDTO.getDescripcion());
        return inegiPais;
    }

    public static CatInegiLocalidad mapearDTOEntityLocalidad(LocalidadDTO coloniaLocalidad) {
        CatInegiLocalidad inegiLocalidad = new CatInegiLocalidad();
        inegiLocalidad.setId(coloniaLocalidad.getId());
        inegiLocalidad.setNombre(coloniaLocalidad.getNombreLocalidad());
        return inegiLocalidad;
    }

    public static CatAtendioParto mapearDTOAEntityAtendioParto(CatAtendioPartoDTO catalogo) {
        CatAtendioParto atendioParto = new CatAtendioParto();
        atendioParto.setId(catalogo.getId());
        atendioParto.setDescripcion(catalogo.getDescripcion());
        return atendioParto;
    }

    public CatComparece mapearDTOAEntityComparece(CatCompareceDTO catalogo) {
        return compareceDAO.recuperarRegistro(catalogo.getId());
    }

    public CatDestinoCadaver mapearDTOAEntityDestinoCadaver(CatDestinoCadaverDTO catalogo) {
        return destinoCadaverDAO.recuperarRegistro(catalogo.getId());
    }

    public CatLugarFallece mapearDTOAEntityLugarFallece (CatLugarFalleceDTO catLugarFalleceDTO) {
        return lugarFalleceDAO.recuperarRegistro(catLugarFalleceDTO.getId());
    }

    public CatEscolaridad mapearDTOAEntityEscolaridad(CatEscolaridadDTO catalogo) {
        return escolaridadDAO.recuperarRegistro(catalogo.getId());
    }

    public CatEstadoCivil mapearDTOAEntityEstadoCivil(CatEstadoCivilDTO catalogo) {
        return estadoCivilDAO.recuperarRegistro(catalogo.getId());
    }

    public CatLugarParto mapearDTOAEntityLugarParto(CatLugarPartoDTO catalogo) {
        return lugarPartoDAO.recuperarRegistro(catalogo.getId());
    }

    public CatParentesco mapearDTOAEntityParentesco(CatParentescoDTO catalogo) {
        return parentescoDAO.recuperarRegistro(catalogo.getId());
    }

    public CatPuesto mapearDTOAEntityPuesto(CatPuestoDTO catalogo) {
        return puestoDAO.recuperarRegistro(catalogo.getId());
    }

    public CatRegimen mapearDTOAEntityRegimen(CatRegimenDTO catalogo) {

        return regimenDAO.recuperarRegistro(catalogo.getId());
    }

    public CatSituacionLaboral mapearDTOAEntitySituacionLaboral
            (CatSituacionLaboralDTO catalogo) {

        return situacionLaboralDAO.recuperarRegistro(catalogo.getId());
    }

    public CatTipoDivorcio mapearDTOAEntityTipoDivorcio(CatTipoDivorcioDTO catalogo) {


        return tipoDivorcioDAO.recuperarRegistro(catalogo.getId());
    }

    public CatTipoDocumento mapearDTOAEntityTipoDocumento(CatTipoDocumentoDTO catalogo) {

        return tipoDocumentoDAO.recuperarRegistro(catalogo.getId());
    }

    public CatTipoOperacion mapearDTOAEntityTipoOperacion(CatTipoOperacionDTO catalogo) {

        return tipoOperacionDAO.recuperarRegistro(catalogo.getId());
    }

    public  CatTipoParto mapearDTOAEntityTipoParto(CatTipoPartoDTO catalogo) {

        return  tipoPartoDAO.recuperarRegistro(catalogo.getId());

    }

    public CatTipoSentencia mapearDTOAEntityTipoSentencia(CatTipoSentenciaDTO catalogo) {

        return tipoSentenciaDAO.recuperarRegistro(catalogo.getId());
    }

    public CatOficialia mapearDTOAEntityOficialia(OficialiaDTO oficialiaDTO) {

        return oficialiaDAO.recuperarRegistro(oficialiaDTO.getId());
    }

    public static Persona mapearDtoAEntityPersona (PersonaDTO personaDTO) {
        Persona persona = new Persona();

        persona.setCadena(personaDTO.getCadenaNacimiento());
        persona.setCertificadoNacimiento(personaDTO.getCadenaNacimiento());
        persona.setCurp(personaDTO.getCertificadoNacimiento());
        persona.setEdad(personaDTO.getEdad());
        persona.setEntidad(
                Utileria.mapearDTOAEntityEstado(personaDTO.getEntidadNacimiento()));
        persona.setMunicipio(
                Utileria.mapearDTOAEntityMunicipio(personaDTO.getMunicipioNacimiento()));
        persona.setLocalidad(
                Utileria.mapearDTOEntityLocalidad(personaDTO.getColoniaLocalidad()));
        persona.setEstadoCivil(
                Utileria.mapearDTOAEntityEstadoCivil(personaDTO.getEstadoCivil()));
        persona.setNombre(personaDTO.getNombre());
        persona.setPrimerApellido(personaDTO.getPrimerApellido());
        persona.setSegundoApellido(personaDTO.getSegundoApellido());
        persona.setSexo(personaDTO.getSexo());
        persona.setFechaNacimiento(personaDTO.getFechaNacimiento());
        persona.setFechaNacimientoIncorrecta(personaDTO.getFechaNacimientoInc());
        persona.setPais(Utileria.mapearDTOAEntityPais(personaDTO.getPaisNacimiento()));
        persona.setDomicilio(mapearDtoAEntityDomicilio(personaDTO.getDomicilio()));

        return persona;
    }

    public static Domicilio mapearDtoAEntityDomicilio (DomicilioDTO domicilioDTO) {
        Domicilio domicilio = new Domicilio();

        domicilio.setCalle(domicilioDTO.getCalle());
        domicilio.setNumeroExt(domicilioDTO.getNumeroExterior());
        domicilio.setNumeroInt(domicilioDTO.getNumeroInteror());
        domicilio.setColonia(domicilioDTO.getColonia());
        domicilio.setLocalidad(Utileria.mapearDTOEntityLocalidad(domicilioDTO.getLocalidad()));
        domicilio.setMunicipio(Utileria.mapearDTOAEntityInegiMunicipio(domicilioDTO.getMunicipio()));
        domicilio.setEstado(Utileria.mapearDTOAEntityInegiEstado(domicilioDTO.getEstado()));
        domicilio.setCodigoPostal(domicilioDTO.getCodigoPostal());
        domicilio.setPais(Utileria.mapearDTOEntityPaisInegi(domicilioDTO.getPais()));

        return domicilio;
    }

    public static PaisDTO mapeaEntityADtoPais(CatPais paisEntity) {

        PaisDTO paisDTO = new PaisDTO();
        paisDTO.setId(paisEntity.getId());
        paisDTO.setNacionalidad(paisEntity.getNacionalidad());
        paisDTO.setDescripcion(paisEntity.getDescripcion());

        return paisDTO;
    }

    public static MunicipioDTO mapearEntityADtoMunicipio(CatMunicipio municipioEntity) {

        MunicipioDTO municipioDTO = new MunicipioDTO();
        municipioDTO.setId(municipioEntity.getId());
        municipioDTO.setIdRenapo(municipioEntity.getIdRenapo());
        municipioDTO.setNombreMunicipio(municipioEntity.getNombre());

        return municipioDTO;

    }

    public static PaisDTO mapeaEntityInegiADtoPais(CatInegiPais inegiPais) {

        PaisDTO paisDTO = new PaisDTO();
        paisDTO.setId(inegiPais.getId());
        paisDTO.setDescripcion(inegiPais.getDescripcion());
        return paisDTO;
    }

    public static EstadoDTO mapeaEntityInegiADtoEstado(CatInegiEstado inegiEstado) {

        EstadoDTO estadoDTO = new EstadoDTO();
        estadoDTO.setId(inegiEstado.getId());
        estadoDTO.setNombreEstado(inegiEstado.getDescripcion());
        return estadoDTO;

    }

    public static CatTipoOficialiaDTO mapeaEntityTipoOficialiaADTO(CatTipoOficialia tipoOficialiaEntity) {

        CatTipoOficialiaDTO oficialiaDTO = new CatTipoOficialiaDTO();
        oficialiaDTO.setId(tipoOficialiaEntity.getId());
        oficialiaDTO.setDescripcion(tipoOficialiaEntity.getDescripcion());

        return oficialiaDTO;
    }

    public static OficialDTO mapeaEntityOficialADTO(CatOficial oficial) {

        OficialDTO oficialDTO = new OficialDTO();
        oficialDTO.setId(oficial.getId());
        oficialDTO.setNumeroOficial(oficial.getNumOficial());
        oficialDTO.setNombre(oficial.getDescripcion());

        return oficialDTO;
    }

    public static OficialiaDTO mapeaEntityOficialiaADTO(CatOficialia oficialia) {

        OficialiaDTO oficialiaDTO = new OficialiaDTO();
        oficialiaDTO.setId(oficialia.getId());
        oficialiaDTO.setIdRenapo(oficialia.getIdRenapo());
        oficialiaDTO.setNombreOficialia(oficialia.getDescripcion());
        oficialiaDTO.setTipoOficialia(mapeaEntityTipoOficialiaADTO(oficialia.getTipoOficialia()));
        oficialiaDTO.setMunicipio(mapearEntityADtoMunicipio(oficialia.getMunicipio()));
        oficialiaDTO.setOficial(mapeaEntityOficialADTO(oficialia.getIdOficial()));

        return oficialiaDTO;
    }

}
