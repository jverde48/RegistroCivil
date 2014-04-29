package mx.gob.renapo.registrocivil.actos.adopcion.bean;


import lombok.Data;
import mx.gob.renapo.registrocivil.actos.adopcion.dto.AdopcionDTO;
import mx.gob.renapo.registrocivil.actos.adopcion.service.AdopcionService;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.service.impl.*;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Data
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@ViewScoped
@ManagedBean(name = "adopcionPrincipalBean")
public abstract class AdopcionPrincipalBean  implements Serializable {
    @Autowired
    AdopcionDTO adopcionDTO;
    @Autowired
    AdopcionDTO adopcionHistoricoDTO;
    @Autowired
    AdopcionDTO adopcionEspecialDTO;
    @Autowired
    AdopcionDTO detalleAdopcion;
    @Autowired
    AdopcionService adopcionService;


    //En caso de que se registren los abuelos del adoptado
    private Boolean existenciaAbueloUnoProgenitor;
    private Boolean existenciaAbueloDosProgenitor;
    private Boolean existenciaAbueloUnoAdoptante;
    private Boolean existenciaAbueloDosAdoptante;

    //Services de catalogos a utilizar
    @Autowired
    private CatPaisServiceImpl paisService;
    @Autowired
    private CatEstadoServiceImpl estadoService;
    @Autowired
    private CatInegiPaisServiceImpl inegiPaisService;
    @Autowired
    private CatInegiEstadoServiceImpl inegiEstadoService;
    @Autowired
    private CatInegiMunicipioServiceImpl inegiMunicipioService;
    @Autowired
    private CatMunicipioServiceImpl municipioService;
    @Autowired
    private CatEstadoCivilServiceImpl estadoCivilService;
    @Autowired
    private CatColoniaLocalidadServiceImpl localidadService;
    @Autowired
    private CatTipoLocalidadServiceImpl tipoLocalidadService;



    /**
     * Listas para carga de paises de cada una de las personas
     * involucradas en el acto de adopcion
     */
    private List<PaisDTO> paises;
    private List<PaisDTO> paisesInegi;

    /**
     * Listas para carga de estados de cada persona del acto de nacimiento
     */
    private List<EstadoDTO> estadosAdoptado;
    private List<EstadoDTO> estadosProgenitor;
    private List<EstadoDTO> estadosAdoptante;
    private List<EstadoDTO> estadosPadreUnoProgenitor;
    private List<EstadoDTO> estadosPadreDosProgenitor;
    private List<EstadoDTO> estadosPadreUnoAdoptante;
    private List<EstadoDTO> estadosPadreDosAdoptante;
    private List<EstadoDTO> estadosTestigoUno;
    private List<EstadoDTO> estadosTestigoDos;

    private List<EstadoDTO> estadosInegiAdoptado;
    private List<EstadoDTO> estadosInegiProgenitor;
    private List<EstadoDTO> estadosInegiAdoptante;
    private List<EstadoDTO> estadosInegiPadreUnoProgenitor;
    private List<EstadoDTO> estadosInegiPadreDosProgenitor;
    private List<EstadoDTO> estadosInegiPadreUnoAdoptante;
    private List<EstadoDTO> estadosInegiPadreDosAdoptante;
    private List<EstadoDTO> estadosInegiTestigoUno;
    private List<EstadoDTO> estadosInegiTestigoDos;

    /**
     * Listas para carga de municipios de cada persona
     */
    private List<MunicipioDTO> municipiosAdoptado;
    private List<MunicipioDTO> municipiosProgenitor;
    private List<MunicipioDTO> municipiosAdoptante;
    private List<MunicipioDTO> municipiosPadreUnoProgenitor;
    private List<MunicipioDTO> municipiosPadreDosProgenitor;
    private List<MunicipioDTO> municipiosPadreUnoAdoptante;
    private List<MunicipioDTO> municipiosPadreDosAdoptante;
    private List<MunicipioDTO> municipiosTestigoUno;
    private List<MunicipioDTO> municipiosTestigoDos;

    private List<MunicipioDTO> municipiosInegiAdoptado;
    private List<MunicipioDTO> municipiosInegiProgenitor;
    private List<MunicipioDTO> municipiosInegiAdoptante;
    private List<MunicipioDTO> municipiosInegiPadreUnoProgenitor;
    private List<MunicipioDTO> municipiosInegiPadreDosProgenitor;
    private List<MunicipioDTO> municipiosInegiPadreUnoAdoptante;
    private List<MunicipioDTO> municipiosInegiPadreDosAdoptante;
    private List<MunicipioDTO> municipiosInegiTestigoUno;
    private List<MunicipioDTO> municipiosInegiTestigoDos;

    /**
     * Listas para carga de localidades de cada persona
     */
    private List<LocalidadDTO> localidadesAdoptado;
    private List<LocalidadDTO> localidadesProgenitor;
    private List<LocalidadDTO> localidadesAdoptante;
    private List<LocalidadDTO> localidadesPadreUnoAdoptante;
    private List<LocalidadDTO> localidadesPadreDosAdoptante;
    private List<LocalidadDTO> localidadesPadreUnoProgenitor;
    private List<LocalidadDTO> localidadesPadreDosProgenitor;
    private List<LocalidadDTO> localidadesTestigoUno;
    private List<LocalidadDTO> localidadesTestigoDos;

    /**
     * Lista para tipo de localidad para cada persona
     */
    private List<CatTipoLocalidadDTO> tipoLocalidadList;

    private List<CatEstadoCivilDTO> estadoCivilList;


    /**
     * Metodo para recupear los estados por pais de una persona
     * @param tipoPersona
     */
    public void consultaEstados(Integer tipoPersona, Integer tipoRegistro) {
        //Obtenemos la persona de la que se trata
        PersonaDTO persona = obtienePersona(tipoPersona, tipoRegistro);
        //Obtenemos el pais de nacimeiento de esa persona
        PaisDTO pais = persona.getPaisNacimiento();

        switch(tipoPersona) {
            case 2:
                setEstadosProgenitor(getEstadoService().recuperarPorPais(pais));
                break;
            case 3:
                setEstadosAdoptante(getEstadoService().recuperarPorPais(pais));
                break;
            case 4:
                setEstadosPadreUnoProgenitor(getEstadoService().recuperarPorPais(pais));
                break;
            case 5:
                setEstadosPadreDosProgenitor(getEstadoService().recuperarPorPais(pais));
                break;
            case 6:
                setEstadosPadreUnoAdoptante(getEstadoService().recuperarPorPais(pais));
                break;
            case 7:
                setEstadosPadreDosAdoptante(getEstadoService().recuperarPorPais(pais));
                break;
            case 8:
                setEstadosTestigoUno(getEstadoService().recuperarPorPais(pais));
                break;
            case 9:
                setEstadosTestigoDos(getEstadoService().recuperarPorPais(pais));
                break;
        }
    }

    /**
     * Metodo que carga los municipios de un estado seleccionado segun la persona
     * @param tipoPersona
     */
    public void consultaMuncipios(Integer tipoPersona, Integer tipoRegistro) {
        PersonaDTO persona = obtienePersona(tipoPersona, tipoRegistro);
        EstadoDTO estado = persona.getEntidadNacimiento();

        switch(tipoPersona) {
            case 1:
                setMunicipiosAdoptado(getMunicipioService().recuperarMunicipiosPorEstado(estado));
                break;
            case 2:
                setMunicipiosProgenitor(getMunicipioService().recuperarMunicipiosPorEstado(estado));
                break;
            case 3:
                setMunicipiosAdoptante(getMunicipioService().recuperarMunicipiosPorEstado(estado));
                break;
            case 4:
                setMunicipiosPadreUnoProgenitor(getMunicipioService().recuperarMunicipiosPorEstado(estado));
                break;
            case 5:
                setMunicipiosPadreDosProgenitor(getMunicipioService().recuperarMunicipiosPorEstado(estado));
                break;
            case 6:
                setMunicipiosPadreUnoAdoptante(getMunicipioService().recuperarMunicipiosPorEstado(estado));
                break;
            case 7:
                setMunicipiosPadreDosAdoptante(getMunicipioService().recuperarMunicipiosPorEstado(estado));
                break;
            case 8:
                setMunicipiosTestigoUno(getMunicipioService().recuperarMunicipiosPorEstado(estado));
                break;
            case 9:
                setMunicipiosTestigoDos(getMunicipioService().recuperarMunicipiosPorEstado(estado));
                break;
        }

    }
    /**
     * Metodo para recuperar una persona dependiendo su rol
     * @param tipoPersona
     * @return PersonaDTO
     */
    private PersonaDTO obtienePersona(Integer tipoPersona, Integer tipoRegistro) {
        AdopcionDTO adopcion = null;
        if(tipoRegistro==1) {
            adopcion = getAdopcionDTO();
        }else if(tipoRegistro==2){
            adopcion = getAdopcionHistoricoDTO();
        }else if (tipoRegistro==3){
            adopcion = getAdopcionEspecialDTO();
        }

        PersonaDTO persona = null;

        switch (tipoPersona) {
            case 1: //En caso de ser el adoptado
                persona = adopcion.getPersona();
                break;
            case 2: //En caso de ser el progenitor
                persona = adopcion.getProgenitor();
                break;
            case 3: //En caso de ser el adoptante
                persona = adopcion.getAdoptante();
                break;
            case 4: //En caso de ser el padre uno del progenitor
                persona = adopcion.getPadreUnoProgenitor();
                break;
            case 5: //En caso de ser el padre dos del progenitor
                persona = adopcion.getPadreDosProgenitor();
                break;
            case 6: //En caso de ser el padre uno del adoptante
                persona = adopcion.getPadreUnoAdoptante();
                break;
            case 7: //En caso de ser el padre dos del adoptante
                persona = adopcion.getPadreDosAdoptante();
                break;
            case 8:
                persona = adopcion.getTestigoUno();
                break;
            case 9:
                persona = adopcion.getTestigoDos();
                break;
        }
        return persona;
    }

    public void consultaLocalidadesInegi(Integer tipoPersona, Integer tipoRegistro) {
        //Obtenemos a la persona que se refiere
        PersonaDTO persona = obtienePersona(tipoPersona, tipoRegistro);
        MunicipioDTO municipio = persona.getDomicilio().getMunicipio();
        switch(tipoPersona) {
            case 1:
                setLocalidadesAdoptado(getLocalidadService().findAllByMunicipio(municipio));
                break;
            case 2:
                setLocalidadesProgenitor(getLocalidadService().findAllByMunicipio(municipio));
                break;
            case 3:
                setLocalidadesAdoptante(getLocalidadService().findAllByMunicipio(municipio));
                break;
            case 4:
                setLocalidadesPadreUnoProgenitor(getLocalidadService().findAllByMunicipio(municipio));
                break;
            case 5:
                setLocalidadesPadreDosProgenitor(getLocalidadService().findAllByMunicipio(municipio));
                break;
            case 6:
                setLocalidadesPadreUnoAdoptante(getLocalidadService().findAllByMunicipio(municipio));
                break;
            case 7:
                setLocalidadesPadreDosAdoptante(getLocalidadService().findAllByMunicipio(municipio));
                break;
            case 8:
                setLocalidadesTestigoUno(getLocalidadService().findAllByMunicipio(municipio));
                break;
            case 9:
                setLocalidadesTestigoDos(getLocalidadService().findAllByMunicipio(municipio));
                break;
        }
    }

    public void consultaEstadosInegi(Integer tipoPersona, Integer tipoRegistro) {
        PersonaDTO persona = obtienePersona(tipoPersona, tipoRegistro);
        PaisDTO pais = persona.getDomicilio().getPais();
        switch(tipoPersona) {
            case 1:
                setEstadosInegiAdoptado(getInegiEstadoService().recupearEstadosPorPais(pais));
                break;
            case 2:
                setEstadosInegiProgenitor(getInegiEstadoService().recupearEstadosPorPais(pais));
                break;
            case 3:
                setEstadosInegiAdoptante(getInegiEstadoService().recupearEstadosPorPais(pais));
                break;
            case 4:
                setEstadosInegiPadreUnoProgenitor(getInegiEstadoService().recupearEstadosPorPais(pais));
                break;
            case 5:
                setEstadosInegiPadreDosProgenitor(getInegiEstadoService().recupearEstadosPorPais(pais));
                break;
            case 6:
                setEstadosInegiPadreUnoAdoptante(getInegiEstadoService().recupearEstadosPorPais(pais));
                break;
            case 7:
                setEstadosInegiPadreDosAdoptante(getInegiEstadoService().recupearEstadosPorPais(pais));
                break;
            case 8:
                setEstadosInegiTestigoUno(getInegiEstadoService().recupearEstadosPorPais(pais));
                break;
            case 9:
                setEstadosInegiTestigoDos(getInegiEstadoService().recupearEstadosPorPais(pais));
                break;
        }

    }

    public void consultaMunicipiosInegi(Integer tipoPersona, Integer tipoRegistro) {
        PersonaDTO persona = obtienePersona(tipoPersona, tipoRegistro);
        EstadoDTO estado = persona.getDomicilio().getEstado();
        switch(tipoPersona) {
            case 1:
                setMunicipiosInegiAdoptado(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
                break;
            case 2:
                setMunicipiosInegiProgenitor(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
                break;
            case 3:
                setMunicipiosInegiAdoptante(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
                break;
            case 4:
                setMunicipiosInegiPadreUnoProgenitor(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
                break;
            case 5:
                setMunicipiosInegiPadreDosProgenitor(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
                break;
            case 6:
                setMunicipiosInegiPadreUnoAdoptante(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
                break;
            case 7:
                setMunicipiosInegiPadreDosAdoptante(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
                break;
            case 8:
                setMunicipiosInegiTestigoUno(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
                break;
            case 9:
                setMunicipiosInegiTestigoDos(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
                break;
        }
    }
}
