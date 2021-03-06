package mx.gob.renapo.registrocivil.util;

import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.dto.DomicilioDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.entity.Domicilio;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import mx.gob.renapo.registrocivil.comun.entity.Usuario;
import java.util.Date;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 01/04/14
 * Time: 19:14
 * To change this template use File | Settings | File Templates.
 */
public interface UtileriaService {
    CatMunicipio recupearMunicipio(MunicipioDTO municipioDTO);

    CatInegiMunicipio recuperarInegiMunicipio(MunicipioDTO municipioDTO);

    CatEstado recuperarEstado(EstadoDTO estadoDTO);

    CatInegiEstado recupearInegiEstado(EstadoDTO estadoDTO);

    CatPais recupearPais(PaisDTO paisDTO);

    CatInegiPais recuperarPaisInegi(PaisDTO paisDTO);

    CatInegiLocalidad recuperarLocalidad(LocalidadDTO coloniaLocalidad);

    HashMap<String, Object> getDatosPersonales(String nombre, String primerApellido,
                 String segundoApellido, Date fechaNacimiento, String sexo, EstadoDTO estado, boolean isComponent);

    CatAtendioParto recuperarAtendioParto(CatAtendioPartoDTO catalogo);

    CatComparece recuperarComparece(CatCompareceDTO catalogo);

    CatTipoLocalidad recuperarTipoLocalidad(CatTipoLocalidadDTO tipoLocalidadDTO);

    CatDestinoCadaver recuperarDestinoCadaver(CatDestinoCadaverDTO catalogo);

    CatLugarFallece recuperarLugarFallece(CatLugarFalleceDTO catLugarFalleceDTO);

    CatEscolaridad recuperarEscolaridad(CatEscolaridadDTO catalogo);

    CatEstadoCivil recuperarEstadoCivil(CatEstadoCivilDTO catalogo);

    CatLugarParto recuperarLugarParto(CatLugarPartoDTO catalogo);

    CatParentesco recuperarParentesco(CatParentescoDTO catalogo);

    CatPuesto recuperarPuesto(CatPuestoDTO catalogo);

    CatRegimen recuperarRegimen(CatRegimenDTO catalogo);

    CatSituacionLaboral recuperarSituacionLaboral(CatSituacionLaboralDTO catalogo);

    CatTipoDivorcio recuperarTipoDivorcio(CatTipoDivorcioDTO catalogo);

    CatTipoDocumento recuperarTipoDocumento(CatTipoDocumentoDTO catalogo);

    CatTipoOperacion recuperarTipoOperacion(CatTipoOperacionDTO catalogo);

    CatTipoParto recuperarTipoParto(CatTipoPartoDTO catalogo);

    CatTipoSentencia recuperarTipoSentencia(CatTipoSentenciaDTO catalogo);

    CatOficialia recuperarOficialia(OficialiaDTO oficialiaDTO);

    Persona mapearDtoAEntityPersona (PersonaDTO personaDTO);

    Domicilio mapearDtoAEntityDomicilio (DomicilioDTO domicilioDTO);

    PersonaDTO mapearEntityDTOPersona(Persona persona);

    DomicilioDTO mapeaEntityADtoDomicilio(Domicilio domicilio);

    CatParentescoDTO mapearEntityADTOParentesco(CatParentesco parentesco);

    CatDestinoCadaverDTO mapearEntityADTODestinoCadaver(CatDestinoCadaver destinoCadaver);

    CatLugarFalleceDTO mapeaEntityADTOLugarFallece(CatLugarFallece lugarFallece);

    CatSituacionLaboralDTO mapearEntityADTOSituacionLaboral(CatSituacionLaboral  situacionLaboral);

    CatPuestoDTO mapearEntityADTOPuesto(CatPuesto puesto);

    CatEscolaridadDTO mapearEntityADTOEscolaridad(CatEscolaridad escolaridad);

    PaisDTO mapeaEntityADtoPais(CatPais paisEntity);

    EstadoDTO mapearEntityADtoEstado(CatEstado estado);

    MunicipioDTO mapearEntityADtoMunicipio(CatMunicipio municipioEntity);

    PaisDTO mapeaEntityInegiADtoPais(CatInegiPais inegiPais);

    EstadoDTO mapeaEntityInegiADtoEstado(CatInegiEstado inegiEstado);

    MunicipioDTO mapeaEntityInegiADtoMunicipio(CatInegiMunicipio municipio);

    LocalidadDTO mapeaEntityInegiADtoLocalidad(CatInegiLocalidad localidad);

    CatTipoOficialiaDTO mapeaEntityTipoOficialiaADTO(CatTipoOficialia tipoOficialiaEntity);

    OficialDTO mapeaEntityOficialADTO(CatOficial oficial);

    OficialiaDTO mapeaEntityOficialiaADTO(CatOficialia oficialia);

    CatEstadoCivilDTO mapeaEntityADtoEstadoCivil(CatEstadoCivil estadoCivil);

    CatTipoLocalidadDTO mapeaEntityADtoTipoLocalidad(CatTipoLocalidad tipoLocalidad);

    CatCompareceDTO mapeaEntityADtoComparece(CatComparece comparece);

    CatRegimenDTO mapeaEntityRegimenADTO(CatRegimen regimen);

    CatTipoDivorcioDTO mapeaEntityTipoDivorcioADTO(CatTipoDivorcio tipoDivorcio);
    
    String getStackTrace(Exception ex);

    String generarCadena(Usuario usuario, Date fechaRegistro, Long numeroActa, Integer acto,
                         Integer bis);

    PersonaDTO getPersona();

    int calcularEdadPersona(Date fechaNacimiento);
}
