package mx.gob.renapo.registrocivil.comun.dto;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class DomicilioDTO {

    public DomicilioDTO(){}

    private String calle;
	private String numeroExterior;
	private String numeroInteror;
    private String codigoPostal;

    @Autowired
    private ColoniaLocalidadDTO colonia; //TODO pk a catalogo de localidad de INEGI

    @Autowired
    private CatTipoLocalidadDTO tipoLocalidad; //TODO pk hacia localidad de INEGI

    @Autowired
	private MunicipioDTO municipio; //TODO pk del catalogo de municipios

    @Autowired
    private EstadoDTO estado; //TODO pk del catalogo de estados

    @Autowired
    private PaisDTO pais;  //TODO pk del catalogo de pais

}
