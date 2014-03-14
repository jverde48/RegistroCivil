package mx.gob.renapo.registrocivil.util;

import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;

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
}
