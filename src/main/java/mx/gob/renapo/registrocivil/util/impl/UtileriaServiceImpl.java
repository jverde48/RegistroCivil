package mx.gob.renapo.registrocivil.util.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.catalogos.dao.*;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.catalogos.service.CatColoniaLocalidadService;
import mx.gob.renapo.registrocivil.comun.dto.DomicilioDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.entity.Domicilio;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.apache.log4j.Logger;
/*import org.joda.time.DateTime;
import org.joda.time.Years;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
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
@EqualsAndHashCode(callSuper = false)
public class UtileriaServiceImpl implements UtileriaService, Serializable {
	
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

    private static Logger log = Logger.getLogger(UtileriaServiceImpl.class);

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
    public HashMap<String, String> getDatosPersonales(String nombre, String primerApellido,
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

    @Override
    public CatMunicipio recupearMunicipio(MunicipioDTO municipioDTO) {
        CatMunicipio municipio = null;
        try {
           municipio = municipioDAO.recuperarRegistro(municipioDTO.getId());
        }catch (Exception e) {
            log.error("Error: " + e);
            }

        return municipio;
    }

    @Override
    public CatInegiMunicipio recuperarInegiMunicipio(MunicipioDTO municipioDTO) {
        CatInegiMunicipio municipio = null;
        try  {
            municipio = inegiMunicipioDAO.recuperarRegistro(municipioDTO.getId());
        }catch (Exception e) {
            log.error("Error: " + e);

        }

        return municipio;
    }

    @Override
    public CatEstado recuperarEstado(EstadoDTO estadoDTO) {
        CatEstado estado = null;
        try {
            estado = estadoDAO.recuperarRegistro(estadoDTO.getId());
        }catch (Exception e) {
          log.error("Error: " + e);
        }
        return estado;

    }

    @Override
    public CatInegiEstado recupearInegiEstado(EstadoDTO estadoDTO) {
        CatInegiEstado estado = null;
        try {
            estado = inegiEstadoDAO.recuperarRegistro(estadoDTO.getId());
        }catch (Exception e) {
            log.error("Error: " + e);
        }
        return estado;

    }

    @Override
    public CatPais recupearPais(PaisDTO paisDTO) {
        CatPais pais = null;
        try {
            pais = paisDAO.recuperarRegistro(paisDTO.getId());
        }catch (Exception e) {
            log.error("Error: " + e);
        }
        return pais;

    }

    @Override
    public CatInegiPais recuperarPaisInegi(PaisDTO paisDTO) {
        CatInegiPais inegiPais = null;
        try {
            inegiPais = inegiPaisDAO.recuperarRegistro(paisDTO.getId());
        }catch (Exception e) {
            log.error("Error: " + e);
        }
        return inegiPais;
    }

    @Override
    public CatInegiLocalidad recuperarLocalidad(LocalidadDTO coloniaLocalidad) {
        CatInegiLocalidad inegiLocalidad = null;
        try {
            inegiLocalidad =
                    localidadDAO.recuperarRegistro(coloniaLocalidad.getId());
        }catch (Exception e)  {
            log.error("Error: " + e);
        }
        return inegiLocalidad;
    }

    @Override
    public CatAtendioParto recuperarAtendioParto(CatAtendioPartoDTO catalogo) {
        CatAtendioParto atendioParto = null;
        try {
            atendioParto = atendioPartoDAO.recuperarRegistro(catalogo.getId());
        }catch (Exception e) {
          log.error("Error: " +  e);
        }
        return atendioParto;
    }

    @Override
    public CatComparece recuperarComparece(CatCompareceDTO catalogo) {
        CatComparece comparece = null;
        try {
             comparece = compareceDAO.recuperarRegistro(catalogo.getId());
        }catch (Exception e) {
            log.error("Error " + e);
        }
        return comparece;
    }

    @Override
    public CatDestinoCadaver recuperarDestinoCadaver(CatDestinoCadaverDTO catalogo) {
        CatDestinoCadaver destinoCadaver = null;
        try {
             destinoCadaver = destinoCadaverDAO.recuperarRegistro(catalogo.getId());
        }catch (Exception e) {
           log.error("Error " +  e);
        }
        return destinoCadaver;
    }

    @Override
    public CatLugarFallece recuperarLugarFallece(CatLugarFalleceDTO catLugarFalleceDTO) {
        CatLugarFallece lugarFallece = null;
        try {
            lugarFallece =  lugarFalleceDAO.recuperarRegistro(catLugarFalleceDTO.getId());
        }catch (Exception e) {
             log.error("Error: " +  e);
        }
        return lugarFallece;
    }

    @Override
    public CatEscolaridad recuperarEscolaridad(CatEscolaridadDTO catalogo) {
        CatEscolaridad escolaridad = null;
        try {
             escolaridad = escolaridadDAO.recuperarRegistro(catalogo.getId());
        }catch (Exception e) {
           log.error("Error: " +  e);
        }
        return escolaridad;
    }

    @Override
    public CatEstadoCivil recuperarEstadoCivil(CatEstadoCivilDTO catalogo) {
        CatEstadoCivil estadoCivil = null;
        try {
            estadoCivil =  estadoCivilDAO.recuperarRegistro(catalogo.getId());
        }catch (Exception e) {
             log.error("Error: " +  e);
        }
        return estadoCivil;
    }

    @Override
    public CatLugarParto recuperarLugarParto(CatLugarPartoDTO catalogo) {
        CatLugarParto lugarParto = null;
        try {
            lugarParto = lugarPartoDAO.recuperarRegistro(catalogo.getId());
        }catch (Exception e) {
            log.error("Error: " + e);
        }
        return lugarParto;
    }

    @Override
    public CatParentesco recuperarParentesco(CatParentescoDTO catalogo) {
        CatParentesco parentesco = null;
        try {
            parentesco = parentescoDAO.recuperarRegistro(catalogo.getId());
        }catch (Exception e) {
            log.error("Error: " + e);
        }
        return parentesco;
    }

    @Override
    public CatPuesto recuperarPuesto(CatPuestoDTO catalogo) {
        CatPuesto puesto = null;
        try {
            puesto = puestoDAO.recuperarRegistro(catalogo.getId());
        }catch (Exception e) {
            log.error("Error: " + e);
        }
        return puesto;
    }

    @Override
    public CatRegimen recuperarRegimen(CatRegimenDTO catalogo) {
        CatRegimen regimen = null;
        try {
            regimen = regimenDAO.recuperarRegistro(catalogo.getId());
        }catch (Exception e) {
            log.error("Error: " + e);
        }
        return regimen;
    }

    @Override
    public CatSituacionLaboral recuperarSituacionLaboral(CatSituacionLaboralDTO catalogo) {
        CatSituacionLaboral situacionLaboral = null;
        try {
            situacionLaboral = situacionLaboralDAO.recuperarRegistro(catalogo.getId());
        }catch (Exception e) {
           log.error("Error: " + e);
        }
        return situacionLaboral;
    }

    @Override
    public CatTipoDivorcio recuperarTipoDivorcio(CatTipoDivorcioDTO catalogo) {
        CatTipoDivorcio tipoDivorcio = null;
        try {
             tipoDivorcio = tipoDivorcioDAO.recuperarRegistro(catalogo.getId());
        }catch (Exception e) {
            log.error("Error: " + e);
        }
        return tipoDivorcio;
    }

    @Override
    public CatTipoDocumento recuperarTipoDocumento(CatTipoDocumentoDTO catalogo) {
        CatTipoDocumento tipoDocumento = null;
        try {
            tipoDocumento = tipoDocumentoDAO.recuperarRegistro(catalogo.getId());
        }catch(Exception e) {
             log.error("Error: " + e);
        }
        return tipoDocumento;
    }

    @Override
    public CatTipoOperacion recuperarTipoOperacion(CatTipoOperacionDTO catalogo) {
        CatTipoOperacion tipoOperacion = null;
        try {
            tipoOperacion = tipoOperacionDAO.recuperarRegistro(catalogo.getId());
        }catch (Exception e) {
            log.error("Error: " + e);
        }
        return tipoOperacion;
    }

    @Override
    public  CatTipoParto recuperarTipoParto(CatTipoPartoDTO catalogo) {
        CatTipoParto tipoParto = null;
        try {
             tipoParto = tipoPartoDAO.recuperarRegistro(catalogo.getId());
        }catch (Exception e) {
           log.error("Error: " + e);
        }
        return tipoParto;
    }

    @Override
    public CatTipoSentencia recuperarTipoSentencia(CatTipoSentenciaDTO catalogo) {
        CatTipoSentencia tipoSentencia = null;
        try {
             tipoSentencia = tipoSentenciaDAO.recuperarRegistro(catalogo.getId());
        }catch (Exception e) {
            log.error("Error: " + e);
        }
        return tipoSentencia;
    }

    @Override
    public CatOficialia recuperarOficialia(OficialiaDTO oficialiaDTO) {
        CatOficialia oficialia = null;
        try {
            oficialia =  oficialiaDAO.recuperarRegistro(oficialiaDTO.getId());
        }catch (Exception e) {
            log.error("Error: " +  e);
        }
        return  oficialia;
    }

    @Override
    public Persona mapearDtoAEntityPersona(PersonaDTO personaDTO) {
        Persona persona = new Persona();

        persona.setCadena("");//TODO GENRAR CADENA DE MATRIMONIO
        persona.setCertificadoNacimiento(
                personaDTO.getCertificadoNacimiento() != null ?
                        personaDTO.getCertificadoNacimiento().toUpperCase() : "");
        persona.setCurp(personaDTO.getCurp() != null ?
                personaDTO.getCurp().toUpperCase() : "");
        persona.setNombre(personaDTO.getNombre().toUpperCase());
        persona.setPrimerApellido(personaDTO.getPrimerApellido().toUpperCase());
        persona.setSegundoApellido(personaDTO.getSegundoApellido() != null ?
                personaDTO.getSegundoApellido().toUpperCase() : "");
        persona.setEdad(calcularEdadPersona(personaDTO.getFechaNacimiento()));
        persona.setFechaNacimiento(personaDTO.getFechaNacimiento());
        persona.setFechaNacimientoIncorrecta(personaDTO.getFechaNacimientoInc() != null ?
                personaDTO.getFechaNacimientoInc().toUpperCase() : "");
        persona.setSexo(personaDTO.getSexo());
        persona.setPais(recupearPais(personaDTO.getPaisNacimiento()));
        persona.setEntidad(recuperarEstado(personaDTO.getEntidadNacimiento()));
        persona.setMunicipio(recupearMunicipio(personaDTO.getMunicipioNacimiento()));
        persona.setLocalidad(personaDTO.getColoniaLocalidad().getNombreLocalidad());
        persona.setEstadoCivil(recuperarEstadoCivil(personaDTO.getEstadoCivil()));
        persona.setDomicilio(mapearDtoAEntityDomicilio(personaDTO.getDomicilio()));
        persona.setFechaActualizacion(null);
        persona.setFechaCreacion(new Date());
        persona.setFechaBorrado(null);
        persona.setUsuarioCreo(null);
        persona.setUsuarioModifica(null);
        persona.setUsuarioBorra(null);
        persona.setVersion(1L);

        return persona;
    }

    @Override
    public Domicilio mapearDtoAEntityDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = new Domicilio();

        domicilio.setCalle(domicilioDTO.getCalle().toUpperCase());
        domicilio.setNumeroExt(domicilioDTO.getNumeroExterior().toUpperCase());
        domicilio.setNumeroInt(domicilioDTO.getNumeroInteror().toUpperCase());
        domicilio.setColonia(domicilioDTO.getColonia() != null ?
                domicilioDTO.getColonia().toUpperCase() : "");
        domicilio.setPais(recuperarPaisInegi(domicilioDTO.getPais()));
        domicilio.setEstado(recupearInegiEstado(domicilioDTO.getEstado()));
        domicilio.setMunicipio(recuperarInegiMunicipio(domicilioDTO.getMunicipio()));
        domicilio.setLocalidad(recuperarLocalidad(domicilioDTO.getLocalidad()));
        domicilio.setCodigoPostal(domicilioDTO.getCodigoPostal());
        domicilio.setFechaActualizacion(null);
        domicilio.setFechaCreacion(new Date());
        domicilio.setFechaBorrado(null);
        domicilio.setUsuarioCreo(null);
        domicilio.setUsuarioModifica(null);
        domicilio.setUsuarioBorra(null);
        domicilio.setVersion(1L);

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

    private int calcularEdadPersona(Date fechaNacimiento){
       /* log.info("Calculando Edad de la Persona: " + fechaNacimiento );
        DateTime start = new DateTime(fechaNacimiento);
        DateTime end = new DateTime(new Date());

        Years years = Years.yearsBetween(start,end);

        log.info("La Edad de la Persona es: " + years.getYears());

        return years.getYears();*/
    	return 0;
    }

	public CatMunicipioDAO getMunicipioDAO() {
		return municipioDAO;
	}

	public void setMunicipioDAO(CatMunicipioDAO municipioDAO) {
		this.municipioDAO = municipioDAO;
	}

	public CatInegiMunicipioDAO getInegiMunicipioDAO() {
		return inegiMunicipioDAO;
	}

	public void setInegiMunicipioDAO(CatInegiMunicipioDAO inegiMunicipioDAO) {
		this.inegiMunicipioDAO = inegiMunicipioDAO;
	}

	public CatEstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(CatEstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	public CatInegiEstadoDAO getInegiEstadoDAO() {
		return inegiEstadoDAO;
	}

	public void setInegiEstadoDAO(CatInegiEstadoDAO inegiEstadoDAO) {
		this.inegiEstadoDAO = inegiEstadoDAO;
	}

	public CatPaisDAO getPaisDAO() {
		return paisDAO;
	}

	public void setPaisDAO(CatPaisDAO paisDAO) {
		this.paisDAO = paisDAO;
	}

	public CatInegiPaisDAO getInegiPaisDAO() {
		return inegiPaisDAO;
	}

	public void setInegiPaisDAO(CatInegiPaisDAO inegiPaisDAO) {
		this.inegiPaisDAO = inegiPaisDAO;
	}

	public CatColoniaLocalidadDAO getLocalidadDAO() {
		return localidadDAO;
	}

	public void setLocalidadDAO(CatColoniaLocalidadDAO localidadDAO) {
		this.localidadDAO = localidadDAO;
	}

	public CatAtendioPartoDAO getAtendioPartoDAO() {
		return atendioPartoDAO;
	}

	public void setAtendioPartoDAO(CatAtendioPartoDAO atendioPartoDAO) {
		this.atendioPartoDAO = atendioPartoDAO;
	}

	public CatCompareceDAO getCompareceDAO() {
		return compareceDAO;
	}

	public void setCompareceDAO(CatCompareceDAO compareceDAO) {
		this.compareceDAO = compareceDAO;
	}

	public CatDestinoCadaverDAO getDestinoCadaverDAO() {
		return destinoCadaverDAO;
	}

	public void setDestinoCadaverDAO(CatDestinoCadaverDAO destinoCadaverDAO) {
		this.destinoCadaverDAO = destinoCadaverDAO;
	}

	public CatLugarFalleceDAO getLugarFalleceDAO() {
		return lugarFalleceDAO;
	}

	public void setLugarFalleceDAO(CatLugarFalleceDAO lugarFalleceDAO) {
		this.lugarFalleceDAO = lugarFalleceDAO;
	}

	public CatEscolaridadDAO getEscolaridadDAO() {
		return escolaridadDAO;
	}

	public void setEscolaridadDAO(CatEscolaridadDAO escolaridadDAO) {
		this.escolaridadDAO = escolaridadDAO;
	}

	public CatEstadoCivilDAO getEstadoCivilDAO() {
		return estadoCivilDAO;
	}

	public void setEstadoCivilDAO(CatEstadoCivilDAO estadoCivilDAO) {
		this.estadoCivilDAO = estadoCivilDAO;
	}

	public CatLugarPartoDAO getLugarPartoDAO() {
		return lugarPartoDAO;
	}

	public void setLugarPartoDAO(CatLugarPartoDAO lugarPartoDAO) {
		this.lugarPartoDAO = lugarPartoDAO;
	}

	public CatParentescoDAO getParentescoDAO() {
		return parentescoDAO;
	}

	public void setParentescoDAO(CatParentescoDAO parentescoDAO) {
		this.parentescoDAO = parentescoDAO;
	}

	public CatPuestoDAO getPuestoDAO() {
		return puestoDAO;
	}

	public void setPuestoDAO(CatPuestoDAO puestoDAO) {
		this.puestoDAO = puestoDAO;
	}

	public CatRegimenDAO getRegimenDAO() {
		return regimenDAO;
	}

	public void setRegimenDAO(CatRegimenDAO regimenDAO) {
		this.regimenDAO = regimenDAO;
	}

	public CatSituacionLaboralDAO getSituacionLaboralDAO() {
		return situacionLaboralDAO;
	}

	public void setSituacionLaboralDAO(CatSituacionLaboralDAO situacionLaboralDAO) {
		this.situacionLaboralDAO = situacionLaboralDAO;
	}

	public CatTipoDivorcioDAO getTipoDivorcioDAO() {
		return tipoDivorcioDAO;
	}

	public void setTipoDivorcioDAO(CatTipoDivorcioDAO tipoDivorcioDAO) {
		this.tipoDivorcioDAO = tipoDivorcioDAO;
	}

	public CatTipoDocumentoDAO getTipoDocumentoDAO() {
		return tipoDocumentoDAO;
	}

	public void setTipoDocumentoDAO(CatTipoDocumentoDAO tipoDocumentoDAO) {
		this.tipoDocumentoDAO = tipoDocumentoDAO;
	}

	public CatTipoLocalidadDAO getTipoLocalidadDAO() {
		return tipoLocalidadDAO;
	}

	public void setTipoLocalidadDAO(CatTipoLocalidadDAO tipoLocalidadDAO) {
		this.tipoLocalidadDAO = tipoLocalidadDAO;
	}

	public CatTipoOficialiaDAO getTipoOficialiaDAO() {
		return tipoOficialiaDAO;
	}

	public void setTipoOficialiaDAO(CatTipoOficialiaDAO tipoOficialiaDAO) {
		this.tipoOficialiaDAO = tipoOficialiaDAO;
	}

	public CatTipoOperacionDAO getTipoOperacionDAO() {
		return tipoOperacionDAO;
	}

	public void setTipoOperacionDAO(CatTipoOperacionDAO tipoOperacionDAO) {
		this.tipoOperacionDAO = tipoOperacionDAO;
	}

	public CatTipoPartoDAO getTipoPartoDAO() {
		return tipoPartoDAO;
	}

	public void setTipoPartoDAO(CatTipoPartoDAO tipoPartoDAO) {
		this.tipoPartoDAO = tipoPartoDAO;
	}

	public CatTipoSentenciaDAO getTipoSentenciaDAO() {
		return tipoSentenciaDAO;
	}

	public void setTipoSentenciaDAO(CatTipoSentenciaDAO tipoSentenciaDAO) {
		this.tipoSentenciaDAO = tipoSentenciaDAO;
	}

	public CatOficialiaDAO getOficialiaDAO() {
		return oficialiaDAO;
	}

	public void setOficialiaDAO(CatOficialiaDAO oficialiaDAO) {
		this.oficialiaDAO = oficialiaDAO;
	}

	public CatColoniaLocalidadService getColoniaLocalidadService() {
		return coloniaLocalidadService;
	}

	public void setColoniaLocalidadService(
			CatColoniaLocalidadService coloniaLocalidadService) {
		this.coloniaLocalidadService = coloniaLocalidadService;
	}

}
