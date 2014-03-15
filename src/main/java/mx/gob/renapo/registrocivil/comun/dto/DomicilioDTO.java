package mx.gob.renapo.registrocivil.comun.dto;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;

@Data

public class DomicilioDTO {

    public DomicilioDTO(){}

    private String calle;
	private String numeroExterior;
	private String numeroInteror;
	private ColoniaLocalidadDTO colonia; //TODO pk a catalogo de localidad de INEGI
	private CatalogoDTO tipoLocalidad; //TODO pk hacia localidad de INEGI
	private MunicipioDTO municipio; //TODO pk del catalogo de municipios
	private EstadoDTO estado; //TODO pk del catalogo de estados
	private String codigoPostal; 
	private PaisDTO pais;  //TODO pk del catalogo de pais

}
