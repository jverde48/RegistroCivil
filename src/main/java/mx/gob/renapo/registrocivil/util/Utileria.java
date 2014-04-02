package mx.gob.renapo.registrocivil.util;


import mx.gob.renapo.registrocivil.catalogos.dao.*;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.dto.DomicilioDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.entity.Domicilio;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
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

public class Utileria {
	
	@Autowired
	private CatMunicipioDAO municipioDAO;
	@Autowired
	private CatInegiMunicipioDAO inegiMunicipioDAO;
	@Autowired
	private CatEstadoDAO estadoDAO;
	@Autowired
	private CatInegiEstadoDAO inegiEstadoDAO;
	@Autowired
	private CatPaisDAO paisDAO;
	@Autowired
	private CatInegiPaisDAO inegiPaisDAO;
	@Autowired
	private CatColoniaLocalidadDAO localidadDAO;
	@Autowired
	private CatAtendioPartoDAO atendioPartoDAO;
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

    public static CatEstado findById(Long id) {
        List<CatEstado> listaEstados = new ArrayList<CatEstado>();
        CatEstado estado1 = new CatEstado();
        estado1.setDescripcion("Guanajuato");
        estado1.setId(1L);
        estado1.setIdRenapo(1L);
        estado1.setMunicipios(null);

        listaEstados.add(estado1);

        estado1 = new CatEstado();
        estado1.setDescripcion("Durango");
        estado1.setId(2L);
        estado1.setIdRenapo(2L);
        estado1.setMunicipios(null);

        listaEstados.add(estado1);

        estado1 = new CatEstado();
        estado1.setDescripcion("Zacatecas");
        estado1.setId(3L);
        estado1.setIdRenapo(3L);
        estado1.setMunicipios(null);

        listaEstados.add(estado1);

        for (CatEstado estado : listaEstados){
            if (estado.getId().equals(id))
                return estado;
        }

        return null;
    }

    public CatMunicipio recupearMunicipio(MunicipioDTO municipioDTO) {
        CatMunicipio municipio = municipioDAO.recuperarRegistro(municipioDTO.getId());       
        return municipio;
    }

    public CatInegiMunicipio recuperarInegiMunicipio(MunicipioDTO municipioDTO) {
        CatInegiMunicipio municipio = inegiMunicipioDAO.recuperarRegistro(municipioDTO.getId());
        return municipio;
    }

    public CatEstado recuperarEstado(EstadoDTO estadoDTO) {
        CatEstado estado = estadoDAO.recuperarRegistro(estadoDTO.getId());
        return estado;

    }

    public CatInegiEstado recupearInegiEstado(EstadoDTO estadoDTO) {
        CatInegiEstado estado = inegiEstadoDAO.recuperarRegistro(estadoDTO.getId());
        return estado;

    }

    public CatPais recupearPais(PaisDTO paisDTO) {
        CatPais pais = paisDAO.recuperarRegistro(paisDTO.getId());
        return pais;

    }

    public CatInegiPais mapearDTOEntityPaisInegi(PaisDTO paisDTO) {
        CatInegiPais inegiPais = inegiPaisDAO.recuperarRegistro(paisDTO.getId());
        return inegiPais;
    }

    public CatInegiLocalidad mapearDTOEntityLocalidad(LocalidadDTO coloniaLocalidad) {
        CatInegiLocalidad inegiLocalidad = 
        		localidadDAO.recuperarRegistro(coloniaLocalidad.getId());
        return inegiLocalidad;
    }

    public CatAtendioParto mapearDTOAEntityAtendioParto(CatAtendioPartoDTO catalogo) {
        CatAtendioParto atendioParto = 
        		atendioPartoDAO.recuperarRegistro(catalogo.getId());
        return atendioParto;
    }

    public static CatComparece mapearDTOAEntityComparece(CatCompareceDTO catalogo) {

        CatComparece comparece = new CatComparece();

        comparece.setId(catalogo.getId());
        comparece.setDescripcion(catalogo.getDescripcion());
        return comparece;
    }

    public static CatDestinoCadaver mapearDTOAEntityDestinoCadaver(CatDestinoCadaverDTO catalogo) {

        CatDestinoCadaver destinoCadaver = new CatDestinoCadaver();
        destinoCadaver.setId(catalogo.getId());
        destinoCadaver.setDescripcion(catalogo.getDescripcion());
        return destinoCadaver;

    }

    public static CatLugarFallece mapearDTOAEntityLugarFallece (CatLugarFalleceDTO catLugarFalleceDTO) {
        CatLugarFallece catLugarFallece = new CatLugarFallece();
        catLugarFallece.setId(catLugarFalleceDTO.getId());
        catLugarFallece.setDescripcion(catLugarFalleceDTO.getDescripcion());
        return catLugarFallece;
    }

    public static CatEscolaridad mapearDTOAEntityEscolaridad(CatEscolaridadDTO catalogo) {

        CatEscolaridad escolaridad = new CatEscolaridad();
        escolaridad.setId(catalogo.getId());
        escolaridad.setDescripcion(catalogo.getDescripcion());
        return escolaridad;

    }

    public static CatEstadoCivil mapearDTOAEntityEstadoCivil(CatEstadoCivilDTO catalogo) {

        CatEstadoCivil estadoCivil = new CatEstadoCivil();
        estadoCivil.setId(catalogo.getId());
        estadoCivil.setDescripcion(catalogo.getDescripcion());
        return estadoCivil;

    }

    public static CatLugarParto mapearDTOAEntityLugarParto(CatLugarPartoDTO catalogo) {

        CatLugarParto lugarParto = new CatLugarParto();
        lugarParto.setId(catalogo.getId());
        lugarParto.setDescripcion(catalogo.getDescripcion());
        return lugarParto;

    }

    public static CatParentesco mapearDTOAEntityParentesco(CatParentescoDTO catalogo) {

        CatParentesco parentesco = new CatParentesco();
        parentesco.setId(catalogo.getId());
        parentesco.setDescripcion(catalogo.getDescripcion());
        return parentesco;

    }

    public static CatPuesto mapearDTOAEntityPuesto(CatPuestoDTO catalogo) {

        CatPuesto puesto = new CatPuesto();
        puesto.setId(catalogo.getId());
        puesto.setDescripcion(catalogo.getDescripcion());
        return puesto;

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

    /*public static Persona mapearDtoAEntityPersona (PersonaDTO personaDTO) {
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
    }*/

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
