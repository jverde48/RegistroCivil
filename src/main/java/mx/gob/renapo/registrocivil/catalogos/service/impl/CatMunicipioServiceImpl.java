package mx.gob.renapo.registrocivil.catalogos.service.impl;

import mx.gob.renapo.registrocivil.catalogos.dao.CatMunicipioDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.MunicipioDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatMunicipioService;
import mx.gob.renapo.registrocivil.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.gob.renapo.registrocivil.catalogos.entity.CatMunicipio;

import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/20/14
 * Time: 2:40 PM
 * Implementacion de service de catalogo de municipios
 */
@Service
public class CatMunicipioServiceImpl implements CatMunicipioService {


    @Autowired
    private CatMunicipioDAO municipioDAO;

    public List<MunicipioDTO> findAll() {

     List<CatMunicipio> listaMunicipiosEntity = municipioDAO.listarRegistros();
     List<MunicipioDTO> municipios = new ArrayList<MunicipioDTO>();
     for(CatMunicipio municipioEntity: listaMunicipiosEntity) {
         municipios.add(Utileria.mapearEntityADtoMunicipio(municipioEntity));
     }

        return municipios;

    }

    public MunicipioDTO findById(Long id) {
        CatMunicipio municipio = municipioDAO.recuperarRegistro(id);
        return Utileria.mapearEntityADtoMunicipio(municipio);
    }

    public CatMunicipioDAO getMunicipioDAO() {
        return municipioDAO;
    }

    public void setMunicipioDAO(CatMunicipioDAO municipioDAO) {
        this.municipioDAO = municipioDAO;
    }


}
