package mx.gob.renapo.registrocivil.showcase.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import mx.gob.renapo.registrocivil.showcase.dto.PersonaDto;

@ManagedBean(name="registroBean")
@RequestScoped
public class RegistroBean {
    private Integer id;
    private String nombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String calle;
    private Integer numeroInterior;
    private Integer numeroExterior;
    private String colonia;
    private String estado;
    private String municipio;
    
    private List<String> listaMunicipios;
    private List<String> listaEstados;
    private List<PersonaDto> listaRegistro;
    private PersonaDto personaSeleccionada;
    
    private static Logger log = Logger.getLogger(RegistroBean.class);
    
    @PostConstruct
    public void cargaInformacion() {
        if (listaEstados == null) 
            listaEstados = new ArrayList<String>();
        
        listaEstados.add("Guanajuato");
        listaEstados.add("Queretaro");
    }
    
    public void cargaMunicipios() {
        if (listaMunicipios == null) 
            listaMunicipios = new ArrayList<String>();
        
        listaMunicipios.add("Apaseo el Alto");
    }
    
    public String registroPersona() {
        log.info("la lista" + listaRegistro);
        PersonaDto persona = new PersonaDto();
        persona.setNombre(getNombre());
        persona.setSegundoNombre(getSegundoNombre());
        persona.setApellidoPaterno(getApellidoPaterno());
        persona.setApellidoMaterno(getApellidoMaterno());
        persona.setCalle(getCalle());
        persona.setNumeroExterior(getNumeroExterior());
        persona.setNumeroInterior(getNumeroInterior());
        persona.setMunicipio(getMunicipio());
        persona.setEstado(getEstado());
        
        if (listaRegistro == null)
            listaRegistro = new ArrayList<PersonaDto>();
        
        listaRegistro.add(persona);
        
        log.info("la lista" + listaRegistro);
        return "";
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(Integer numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public Integer getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(Integer numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<PersonaDto> getListaRegistro() {
        return listaRegistro;
    }

    public void setListaRegistro(List<PersonaDto> listaRegistro) {
        this.listaRegistro = listaRegistro;
    }

    public PersonaDto getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(PersonaDto personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }

    public List<String> getListaMunicipios() {
        return listaMunicipios;
    }

    public void setListaMunicipios(List<String> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }

    public List<String> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<String> listaEstados) {
        this.listaEstados = listaEstados;
    }
}
