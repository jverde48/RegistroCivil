package mx.gob.renapo.registrocivil.util;

import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.*;

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
        mapDatosPersonales.put("estado", estado.getNombre());

        return mapDatosPersonales;
    }

    public static CatEstado findById(Long id) {
        List<CatEstado> listaEstados = new ArrayList<CatEstado>();
        CatEstado estado1 = new CatEstado();
        estado1.setNombre("Guanajuato");
        estado1.setId(1L);
        estado1.setIdRenapo(1L);
        estado1.setMunicipios(null);

        listaEstados.add(estado1);

        estado1 = new CatEstado();
        estado1.setNombre("Durango");
        estado1.setId(2L);
        estado1.setIdRenapo(2L);
        estado1.setMunicipios(null);

        listaEstados.add(estado1);

        estado1 = new CatEstado();
        estado1.setNombre("Zacatecas");
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

    public static CatMunicipio mapearDTOAEntityMunicipio(MunicipioDTO municipioDTO) {
        CatMunicipio municipio = new CatMunicipio();
        municipio.setId(municipio.getId());
        municipio.setNombre(municipio.getNombre());
        return municipio;
    }

    public static CatEstado mapearDTOAEntityEstado(EstadoDTO estadoDTO) {

        CatEstado estado = new CatEstado();
        estado.setId(estadoDTO.getId());
        estado.setIdRenapo(estadoDTO.getIdRenapo());
        estado.setNombre(estadoDTO.getNombreEstado());
        return estado;

    }

    public static CatInegiPais mapearDTOEntityPaisInegi(PaisDTO paisDTO) {
        CatInegiPais inegiPais = new CatInegiPais();
        return inegiPais;
    }

    public static CatNacionalidad mapearDTOEntityNacionalidad(NacionalidadDTO catalogoDTO) {
        CatNacionalidad nacionalidad = new CatNacionalidad();
        nacionalidad.setId(catalogoDTO.getId());
        nacionalidad.setDescripcion(catalogoDTO.getNacionalidad());
        return nacionalidad;
    }

    public static CatInegiLocalidad mapearDTOEntityLocalidad(ColoniaLocalidadDTO coloniaLocalidad) {
        CatInegiLocalidad inegiLocalidad = new CatInegiLocalidad();
        inegiLocalidad.setId(coloniaLocalidad.getId());
        inegiLocalidad.setNombre(coloniaLocalidad.getNombreLocalidadColonia());
        return inegiLocalidad;
    }

    public static CatAtendioParto mapearDTOAEntityAtendioParto(CatalogoDTO catalogo) {
        CatAtendioParto atendioParto = new CatAtendioParto();
        atendioParto.setId(catalogo.getId());
        atendioParto.setDescripcion(catalogo.getDescripcion());
        return atendioParto;
    }

    public static CatComparece mapearDTOAEntityComparece(CatalogoDTO catalogo) {

        CatComparece comparece = new CatComparece();

        comparece.setId(catalogo.getId());
        comparece.setDescripcion(catalogo.getDescripcion());
        return comparece;
    }

    public static CatDestinoCadaver mapearDTOAEntityDestinoCadaver(CatalogoDTO catalogo) {

        CatDestinoCadaver destinoCadaver = new CatDestinoCadaver();
        destinoCadaver.setId(catalogo.getId());
        destinoCadaver.setDescripcion(catalogo.getDescripcion());
        return destinoCadaver;

    }

    public static CatEscolaridad mapearDTOAEntityEscolaridad(CatalogoDTO catalogo) {

        CatEscolaridad escolaridad = new CatEscolaridad();
        escolaridad.setId(catalogo.getId());
        escolaridad.setDescripcion(catalogo.getDescripcion());
        return escolaridad;

    }

    public static CatEstadoCivil mapearDTOAEntityEstadoCivil(CatalogoDTO catalogo) {

        CatEstadoCivil estadoCivil = new CatEstadoCivil();
        estadoCivil.setId(catalogo.getId());
        estadoCivil.setDescripcion(catalogo.getDescripcion());
        return estadoCivil;

    }

    public static CatLugarParto mapearDTOAEntityLugarParto(CatalogoDTO catalogo) {

        CatLugarParto lugarParto = new CatLugarParto();
        lugarParto.setId(catalogo.getId());
        lugarParto.setDescripcion(catalogo.getDescripcion());
        return lugarParto;

    }

    public static CatParentesco mapearDTOAEntityParentesco(CatalogoDTO catalogo) {

        CatParentesco parentesco = new CatParentesco();
        parentesco.setId(catalogo.getId());
        parentesco.setDescripcion(catalogo.getDescripcion());
        return parentesco;

    }

    public static CatPuesto mapearDTOAEntityPuesto(CatalogoDTO catalogo) {

        CatPuesto puesto = new CatPuesto();
        puesto.setId(catalogo.getId());
        puesto.setDescripcion(catalogo.getDescripcion());
        return puesto;

    }

    public static CatRegimen mapearDTOAEntityRegimen(CatalogoDTO catalogo) {
        CatRegimen regimen = new CatRegimen();
        regimen.setId(catalogo.getId());
        regimen.setDescripcion(catalogo.getDescripcion());
        return regimen;
    }

    public static CatSituacionLaboral mapearDTOAEntitySituacionLaboral
            (CatalogoDTO catalogo) {
        CatSituacionLaboral situacionLaboral = new CatSituacionLaboral();
        situacionLaboral.setId(catalogo.getId());
        situacionLaboral.setDescripcion(catalogo.getDescripcion());
        return situacionLaboral;
    }

    public static CatTipoDivorcio mapearDTOAEntityTipoDivorcio(CatalogoDTO catalogo) {
        CatTipoDivorcio tipoDivorcio = new CatTipoDivorcio();
        tipoDivorcio.setId(catalogo.getId());
        tipoDivorcio.setDescripcion(catalogo.getDescripcion());

        return tipoDivorcio;
    }

    public static CatTipoDocumento mapearDTOAEntityTipoDocumento(CatalogoDTO catalogo) {
        CatTipoDocumento tipoDocumento = new CatTipoDocumento();
        tipoDocumento.setId(catalogo.getId());
        tipoDocumento.setDescripcion(catalogo.getDescripcion());
        return tipoDocumento;
    }

    public static CatTipoOperacion mapearDTOAEntityTipoOperacion(CatalogoDTO catalogo) {
        CatTipoOperacion tipoOperacion = new CatTipoOperacion();
        tipoOperacion.setId(catalogo.getId());
        tipoOperacion.setDescripcion(catalogo.getDescripcion());
        return tipoOperacion;
    }

    public static CatTipoParto mapearDTOAEntityTipoParto(CatalogoDTO catalogo) {

        CatTipoParto tipoParto = new CatTipoParto();
        tipoParto.setId(catalogo.getId());
        tipoParto.setDescripcion(catalogo.getDescripcion());
        return  tipoParto;

    }

    public static CatTipoSentencia mapearDTOAEntityTipoSentencia(CatalogoDTO catalogo) {
        CatTipoSentencia tipoSentencia = new CatTipoSentencia();
        tipoSentencia.setId(catalogo.getId());
        tipoSentencia.setDescripcion(catalogo.getDescripcion());
        return tipoSentencia;
    }

    public static CatOficialia mapearDTOAEntityOficialia(OficialiaDTO oficialiaDTO) {
        CatOficialia oficialia = new CatOficialia();
        oficialia.setId(oficialiaDTO.getId());
        oficialia.setDescripcion(oficialiaDTO.getNombreOficialia());
        return oficialia;
    }

}
