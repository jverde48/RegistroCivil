package mx.gob.renapo.registrocivil.comun.entity;


import mx.gob.renapo.registrocivil.catalogos.entity.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/3/14
 * Time: 1:19 PM
 * Clase  que representa la entidad de Persona en la BBDD
 */

@Entity
@Table(name = "PERSONA")

public class Persona extends SequenceGenerator implements Serializable{

    @Column(name = "CADENA", nullable = true)
    private String cadena;

    @Column(name = "CADENA_DEFUNCION", nullable = true)
    private String cadenaDefuncion;

    @Column(name = "CADENA_MATRIMONIO", nullable = true)
    private String cadenaMatrimonio;

    @Column(name = "CADENA_DIVORCIO", nullable = true)
    private String cadenaDivorcio;

    @Column(name = "CADENA_RECONOCIMIENTO", nullable = true)
    private String cadenaReconocimiento;

    @Column(name = "CADENA_ADOPCION_SIMPLE", nullable = true)
    private String cadenaAdopcionSimple;

    @Column(name = "CERTIFICADO_NACIMIENTO", nullable = true)
    private String certificadoNacimiento;

    @Column(name = "CURP", nullable = true)
    private String curp;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "PRIMER_APELLIDO", nullable = false)
    private String primerApellido;

    @Column(name = "SEGUNDO_APELLIDO", nullable = true)
    private String segundoApellido;

    @Column(name = "EDAD", nullable = true)
    private  Integer edad;

    @Column(name = "FECHA_NACIMIENTO", nullable = true)
    private Date fechaNacimiento;

    @Column(name = "FECHA_NACIMIENTO_INCORRECTA", nullable = true)
    private String fechaNacimientoIncorrecta;

    @Column(name ="FINADO", nullable = true)
    private boolean finado;

    @Column(name = "SEXO", nullable = false)
    private char sexo;

    @OneToOne
    @JoinColumn(name = "PAIS", nullable = true)
    private CatPais pais;

    @OneToOne
    @JoinColumn(name = "ENTIDAD", nullable = true)
    private CatEstado entidad;

    @OneToOne
    @JoinColumn(name = "MUNICIPIO", nullable = true)
    private CatMunicipio municipio;


    @Column(name = "LOCALIDAD", nullable = true)
    private String localidad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DOMICILIO", nullable = true)
    private Domicilio domicilio;

    @OneToOne
    @JoinColumn(name = "ESTADO_CIVIL", nullable = true)
    private CatEstadoCivil estadoCivil;

    @Column(name = "CRIP", nullable = true)
    private String crip;

  //Getters y Setters
	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

    public String getCadenaDefuncion() {
        return cadenaDefuncion;
    }

    public void setCadenaDefuncion(String cadenaDefuncion) {
        this.cadenaDefuncion = cadenaDefuncion;
    }

    public String getCadenaMatrimonio() {
        return cadenaMatrimonio;
    }

    public void setCadenaMatrimonio(String cadenaMatrimonio) {
        this.cadenaMatrimonio = cadenaMatrimonio;
    }

    public String getCadenaDivorcio() {
        return cadenaDivorcio;
    }

    public void setCadenaDivorcio(String cadenaDivorcio) {
        this.cadenaDivorcio = cadenaDivorcio;
    }

    public String getCadenaReconocimiento() {
        return cadenaReconocimiento;
    }

    public void setCadenaReconocimiento(String cadenaReconocimiento) {
        this.cadenaReconocimiento = cadenaReconocimiento;
    }

    public String getCadenaAdopcionSimple() {
        return cadenaAdopcionSimple;
    }

    public void setCadenaAdopcionSimple(String cadenaAdopcionSimple) {
        this.cadenaAdopcionSimple = cadenaAdopcionSimple;
    }

    public String getCertificadoNacimiento() {
		return certificadoNacimiento;
	}

	public void setCertificadoNacimiento(String certificadoNacimiento) {
		this.certificadoNacimiento = certificadoNacimiento;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaNacimientoIncorrecta() {
		return fechaNacimientoIncorrecta;
	}

	public void setFechaNacimientoIncorrecta(String fechaNacimientoIncorrecta) {
		this.fechaNacimientoIncorrecta = fechaNacimientoIncorrecta;
	}

    public boolean isFinado() {
        return finado;
    }

    public void setFinado(boolean finado) {
        this.finado = finado;
    }

    public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public CatPais getPais() {
		return pais;
	}

	public void setPais(CatPais pais) {
		this.pais = pais;
	}

	public CatEstado getEntidad() {
		return entidad;
	}

	public void setEntidad(CatEstado entidad) {
		this.entidad = entidad;
	}

	public CatMunicipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(CatMunicipio municipio) {
		this.municipio = municipio;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public CatEstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(CatEstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

    public String getCrip() {
        return crip;
    }

    public void setCrip(String crip) {
        this.crip = crip;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cadena == null) ? 0 : cadena.hashCode());
		result = prime
				* result
				+ ((certificadoNacimiento == null) ? 0 : certificadoNacimiento
						.hashCode());
		result = prime * result + ((curp == null) ? 0 : curp.hashCode());
		result = prime * result
				+ ((domicilio == null) ? 0 : domicilio.hashCode());
		result = prime * result + ((edad == null) ? 0 : edad.hashCode());
		result = prime * result + ((entidad == null) ? 0 : entidad.hashCode());
		result = prime * result
				+ ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result
				+ ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
		result = prime
				* result
				+ ((fechaNacimientoIncorrecta == null) ? 0
						: fechaNacimientoIncorrecta.hashCode());
		result = prime * result
				+ ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result
				+ ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result
				+ ((primerApellido == null) ? 0 : primerApellido.hashCode());
		result = prime * result
				+ ((segundoApellido == null) ? 0 : segundoApellido.hashCode());
		result = prime * result + sexo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (cadena == null) {
			if (other.cadena != null)
				return false;
		} else if (!cadena.equals(other.cadena))
			return false;
		if (certificadoNacimiento == null) {
			if (other.certificadoNacimiento != null)
				return false;
		} else if (!certificadoNacimiento.equals(other.certificadoNacimiento))
			return false;
		if (curp == null) {
			if (other.curp != null)
				return false;
		} else if (!curp.equals(other.curp))
			return false;
		if (domicilio == null) {
			if (other.domicilio != null)
				return false;
		} else if (!domicilio.equals(other.domicilio))
			return false;
		if (edad == null) {
			if (other.edad != null)
				return false;
		} else if (!edad.equals(other.edad))
			return false;
		if (entidad == null) {
			if (other.entidad != null)
				return false;
		} else if (!entidad.equals(other.entidad))
			return false;
		if (estadoCivil == null) {
			if (other.estadoCivil != null)
				return false;
		} else if (!estadoCivil.equals(other.estadoCivil))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (fechaNacimientoIncorrecta == null) {
			if (other.fechaNacimientoIncorrecta != null)
				return false;
		} else if (!fechaNacimientoIncorrecta
				.equals(other.fechaNacimientoIncorrecta))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (primerApellido == null) {
			if (other.primerApellido != null)
				return false;
		} else if (!primerApellido.equals(other.primerApellido))
			return false;
		if (segundoApellido == null) {
			if (other.segundoApellido != null)
				return false;
		} else if (!segundoApellido.equals(other.segundoApellido))
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Persona [cadena=" + cadena + ", nombre=" + nombre
				+ ", primerApellido=" + primerApellido + ", segundoApellido="
				+ segundoApellido + "]";
	}

}
