package mx.gob.renapo.registrocivil.comun.dao.impl;

import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.catalogos.entity.CatPais;
import mx.gob.renapo.registrocivil.comun.dao.PersonaDAO;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Green4
 * Date: 21/04/14
 * Time: 06:46 PM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class PersonaDAOImpl extends GeneralDAOImpl<Persona> implements PersonaDAO {
    @Override
    public List<Persona> findByCurp(String curp) {
        Session session = getSession();
        Criteria criteria = null;
        List<Persona> lista = null;
        try {
            session.beginTransaction();
            criteria = session.createCriteria(Persona.class);
            criteria.add(Restrictions.eq("curp", curp))
                    .add(Restrictions.isNull("fechaBorrado"));
            lista = criteria.list();

            if (lista != null && !lista.isEmpty()) {
                for (Persona persona : lista) {
                    if (persona.getPais() != null)
                        Hibernate.initialize(persona.getPais());

                    if (persona.getEntidad() != null)
                        Hibernate.initialize(persona.getEntidad());

                    if (persona.getMunicipio() != null)
                        Hibernate.initialize(persona.getMunicipio());

                    if (persona.getEstadoCivil() != null)
                        Hibernate.initialize(persona.getEstadoCivil());

                    if (persona.getDomicilio() != null) {
                        Hibernate.initialize(persona.getDomicilio());
                        if (persona.getDomicilio().getLocalidad() != null)
                            Hibernate.initialize(persona.getDomicilio().getLocalidad());

                        if (persona.getDomicilio().getMunicipio() != null)
                            Hibernate.initialize(persona.getDomicilio().getMunicipio());

                        if (persona.getDomicilio().getEstado() != null)
                            Hibernate.initialize(persona.getDomicilio().getEstado());

                        if (persona.getDomicilio().getPais() != null)
                            Hibernate.initialize(persona.getDomicilio().getPais());

                        if (persona.getDomicilio().getTipoLocalidad() != null)
                            Hibernate.initialize(persona.getDomicilio().getTipoLocalidad());
                    }
                }
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return lista;
    }

    @Override
    //TODO cambiar cadena por cadena nacimiento
    public List<Persona> findByCadena(String cadena) {
        Session session = getSession();
        Criteria criteria = null;
        List<Persona> lista = null;
        try {
            session.beginTransaction();
            criteria = session.createCriteria(Persona.class);
            criteria.add(Restrictions.eq("cadena", cadena))
                    .add(Restrictions.isNull("fechaBorrado"));
            lista = criteria.list();

            if (lista != null && !lista.isEmpty()) {
                for (Persona persona : lista) {
                    if (persona.getPais() != null)
                        Hibernate.initialize(persona.getPais());

                    if (persona.getEntidad() != null)
                        Hibernate.initialize(persona.getEntidad());

                    if (persona.getMunicipio() != null)
                        Hibernate.initialize(persona.getMunicipio());

                    if (persona.getEstadoCivil() != null)
                        Hibernate.initialize(persona.getEstadoCivil());

                    if (persona.getDomicilio() != null) {
                        Hibernate.initialize(persona.getDomicilio());
                        if (persona.getDomicilio().getLocalidad() != null)
                            Hibernate.initialize(persona.getDomicilio().getLocalidad());

                        if (persona.getDomicilio().getMunicipio() != null)
                            Hibernate.initialize(persona.getDomicilio().getMunicipio());

                        if (persona.getDomicilio().getEstado() != null)
                            Hibernate.initialize(persona.getDomicilio().getEstado());

                        if (persona.getDomicilio().getPais() != null)
                            Hibernate.initialize(persona.getDomicilio().getPais());

                        if (persona.getDomicilio().getTipoLocalidad() != null)
                            Hibernate.initialize(persona.getDomicilio().getTipoLocalidad());
                    }
                }
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return lista;
    }

    @Override
    public List<Persona> findByDatosPersonales(HashMap<String, Object> datosPersonales) {
        Session session = getSession();
        Criteria criteria = null;
        List<Persona> lista = null;
        try {
            session.beginTransaction();
            criteria = session.createCriteria(Persona.class);
            criteria.add(Restrictions.allEq(datosPersonales));
            lista = criteria.list();

            if (lista != null && !lista.isEmpty()) {
                for (Persona persona : lista) {
                    if (persona.getPais() != null)
                        Hibernate.initialize(persona.getPais());

                    if (persona.getEntidad() != null)
                        Hibernate.initialize(persona.getEntidad());

                    if (persona.getMunicipio() != null)
                        Hibernate.initialize(persona.getMunicipio());

                    if (persona.getEstadoCivil() != null)
                        Hibernate.initialize(persona.getEstadoCivil());

                    if (persona.getDomicilio() != null) {
                        Hibernate.initialize(persona.getDomicilio());
                        if (persona.getDomicilio().getLocalidad() != null)
                            Hibernate.initialize(persona.getDomicilio().getLocalidad());

                        if (persona.getDomicilio().getMunicipio() != null)
                            Hibernate.initialize(persona.getDomicilio().getMunicipio());

                        if (persona.getDomicilio().getEstado() != null)
                            Hibernate.initialize(persona.getDomicilio().getEstado());

                        if (persona.getDomicilio().getPais() != null)
                            Hibernate.initialize(persona.getDomicilio().getPais());

                        if (persona.getDomicilio().getTipoLocalidad() != null)
                            Hibernate.initialize(persona.getDomicilio().getTipoLocalidad());
                    }
                }
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return lista;
    }
}
