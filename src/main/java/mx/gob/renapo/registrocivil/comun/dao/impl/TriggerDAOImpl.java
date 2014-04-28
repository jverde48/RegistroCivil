package mx.gob.renapo.registrocivil.comun.dao.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.divorcio.entity.Divorcio;
import mx.gob.renapo.registrocivil.actos.matrimonio.dao.impl.MatrimonioDAOImpl;
import mx.gob.renapo.registrocivil.actos.matrimonio.entity.Matrimonio;
import mx.gob.renapo.registrocivil.actos.nacimiento.dao.impl.NacimientoDAOImpl;
import mx.gob.renapo.registrocivil.actos.nacimiento.entity.Nacimiento;
import mx.gob.renapo.registrocivil.catalogos.dao.impl.CatEstadoCivilDAOImpl;
import mx.gob.renapo.registrocivil.comun.dao.TriggerDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import mx.gob.renapo.registrocivil.comun.entity.Persona;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 4/27/14
 * Time: 10:52 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Data
public class TriggerDAOImpl implements TriggerDAO{

    private static Logger logger = Logger.getLogger(TriggerDAOImpl.class);

    @Autowired
    private NacimientoDAOImpl nacimientoDAO;

    @Autowired
    private CatEstadoCivilDAOImpl estadoCivilDAO;

    @Autowired
    private PersonaDAOImpl personaDAO;

    @Autowired
    private MatrimonioDAOImpl matrimonioDAO;

    public Nacimiento afectarNacimientoPorDefuncion(Nacimiento nacimiento) throws Exception {
        List<Matrimonio> matrimonios = null;
        Persona conyugue = null;

        nacimiento.setFechaBorrado(new Date());
        if(nacimiento.getRegistrado().getCadenaMatrimonio()!=null) {
           matrimonios = matrimonioDAO.consultaActaCadena(
                   nacimiento.getRegistrado().getCadenaMatrimonio());
            if(matrimonios!=null && !matrimonios.isEmpty()) {
                if(matrimonios.get(0).getContrayenteUno().getCadenaMatrimonio().equals(nacimiento.getRegistrado().getCadenaMatrimonio())) {
                    conyugue = matrimonios.get(0).getContrayenteUno();
                    conyugue.setEstadoCivil(estadoCivilDAO.recuperarRegistro(1L));
                    personaDAO.editarRegistro(conyugue);
                }

            }
        }
        nacimientoDAO.borrarRegistro(nacimiento);

        return null;

    }

    public Nacimiento afectarNacimientoPorReconocimientoAdopcion(Nacimiento nacimiento) throws Exception {

        nacimiento.setFechaActualizacion(new Date());
        nacimientoDAO.editarRegistro(nacimiento);

        return null;
    }

    public Matrimonio afectarMatrimonioPorDivorcion(Divorcio divorcio) throws Exception {

        Persona divorciadoUno = null;
        Persona divorciadoDos = null;

        divorcio.getActaMatrimonio().setFechaBorrado(new Date());
        divorcio.getActaMatrimonio().getContrayenteUno().setEstadoCivil(estadoCivilDAO.recuperarRegistro(1L));
        divorcio.getActaMatrimonio().getContrayenteDos().setEstadoCivil(estadoCivilDAO.recuperarRegistro(1L));

        divorciadoUno = divorcio.getActaMatrimonio().getContrayenteUno();
        divorciadoUno.setCadenaDivorcio(divorcio.getCadena());
        divorciadoDos = divorcio.getActaMatrimonio().getContrayenteDos();
        divorciadoDos.setCadenaDivorcio(divorcio.getCadena());
        matrimonioDAO.borrarRegistro(divorcio.getActaMatrimonio());
        personaDAO.editarRegistro(divorciadoUno);
        personaDAO.editarRegistro(divorciadoDos);

        return null;

    }

    public Matrimonio actualizaEstadoCivilContrayentesMatrimonio(Matrimonio matrimonio) throws Exception {

        Persona contrayenteUno = matrimonio.getContrayenteUno();
        Persona contrayenteDos = matrimonio.getContrayenteDos();

        contrayenteUno.setEstadoCivil(estadoCivilDAO.recuperarRegistro(2L));
        contrayenteUno.setCadenaMatrimonio(matrimonio.getCadena());
        contrayenteDos.setEstadoCivil(estadoCivilDAO.recuperarRegistro(2L));
        contrayenteDos.setCadenaMatrimonio(matrimonio.getCadena());

        personaDAO.editarRegistro(contrayenteUno);
        personaDAO.editarRegistro(contrayenteDos);


        return null;
    }



}
