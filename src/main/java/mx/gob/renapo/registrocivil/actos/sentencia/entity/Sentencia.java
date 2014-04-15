package mx.gob.renapo.registrocivil.actos.sentencia.entity;

import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.actos.matrimonio.entity.Matrimonio;
import mx.gob.renapo.registrocivil.comun.entity.*;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 10/04/14
 * Time: 01:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "SENTENCIA")
@EqualsAndHashCode(callSuper=false)
public class Sentencia extends SequenceGenerator implements Serializable {

    public Sentencia(){

    }

    /**
     * Propiedades que forman parte de la informacion del acta
     */

    @OneToOne
    @JoinColumn(name="ACTA_SENTENCIA", nullable = true)
    private Matrimonio actaMatrimonio;

    @Column(name = "CADENA", nullable = true)
    private String cadena;

    @Column(name = "LLAVE_ORIGINAL", nullable = true)
    private String llaveOriginal;

    @Column(name = "FECHA_EJECUTORIA", nullable = true)
    private Date fechaEjecutoria;

    @Column(name = "FECHA_REGISTRO", nullable = true)
    private Date fechaRegistro;

    @Column(name = "FECHA_RESOLUCION", nullable = true)
    private Date fechaResolucion;

    @Column(name = "JUEZ", nullable = true)
    private Date juez;

    /**
     * Propiedades de personas que forman parte del acto de sentencia
     */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "REGISTRADO", nullable = true)
    private Persona registrado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DECLARANTE", nullable = true)
    private Persona declarante;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RESPONSABLE", nullable = true)
    private Persona responsable;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TUTOR", nullable = true)
    private Persona tutor;

    //getters y setters

    public Matrimonio getActaMatrimonio() {
        return actaMatrimonio;
    }

    public void setActaMatrimonio(Matrimonio actaMatrimonio) {
        this.actaMatrimonio = actaMatrimonio;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getLlaveOriginal() {
        return llaveOriginal;
    }

    public void setLlaveOriginal(String llaveOriginal) {
        this.llaveOriginal = llaveOriginal;
    }

    public Date getFechaEjecutoria() {
        return fechaEjecutoria;
    }

    public void setFechaEjecutoria(Date fechaEjecutoria) {
        this.fechaEjecutoria = fechaEjecutoria;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public Date getJuez() {
        return juez;
    }

    public void setJuez(Date juez) {
        this.juez = juez;
    }

    public Persona getRegistrado() {
        return registrado;
    }

    public void setRegistrado(Persona registrado) {
        this.registrado = registrado;
    }

    public Persona getDeclarante() {
        return declarante;
    }

    public void setDeclarante(Persona declarante) {
        this.declarante = declarante;
    }

    public Persona getResponsable() {
        return responsable;
    }

    public void setResponsable(Persona responsable) {
        this.responsable = responsable;
    }

    public Persona getTutor() {
        return tutor;
    }

    public void setTutor(Persona tutor) {
        this.tutor = tutor;
    }





}
