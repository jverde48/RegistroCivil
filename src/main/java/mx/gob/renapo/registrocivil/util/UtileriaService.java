package mx.gob.renapo.registrocivil.util;

import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.dto.DomicilioDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.entity.Domicilio;
import mx.gob.renapo.registrocivil.comun.entity.Persona;

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

    public HashMap<String, String> getDatosPersonales(String nombre, String primerApellido,
                 String segundoApellido, Date fechaNacimiento, String sexo, CatEstado estado);

    CatAtendioParto recuperarAtendioParto(CatAtendioPartoDTO catalogo);

    CatComparece recuperarComparece(CatCompareceDTO catalogo);

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
}