package mx.gob.renapo.registrocivil.catalogos.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatInegiMunicipioDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.MunicipioDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiMunicipio;
import mx.gob.renapo.registrocivil.catalogos.service.CatInegiMunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 23/03/14
 * Time: 01:26
 * To change this template use File | Settings | File Templates.
 */

@Data
@Service
public class CatInegiMunicipioServiceImpl implements CatInegiMunicipioService {

    @Autowired
    private CatInegiMunicipioDAO catInegiMunicipioDAO;

    @Override
    public MunicipioDTO findById(Long id) {
        MunicipioDTO municipioDTO = null;
        CatInegiMunicipio inegiMunicipio = catInegiMunicipioDAO.recuperarRegistro(id);

        if (inegiMunicipio != null) {
            municipioDTO = new MunicipioDTO();
            municipioDTO.setId(inegiMunicipio.getId());
            municipioDTO.setNombreMunicipio(inegiMunicipio.getDescripcion());
        }

        return municipioDTO;
    }

    @Override
    public List<MunicipioDTO> findAll() {
        List<MunicipioDTO> listaMunicipios = null;
        List<CatInegiMunicipio> listaInegiMunicipio = catInegiMunicipioDAO.listarRegistros();

        if (listaMunicipios != null && !listaMunicipios.isEmpty()) {
            listaMunicipios = new ArrayList<MunicipioDTO>();

            for (CatInegiMunicipio inegiMunicipio : listaInegiMunicipio) {
                MunicipioDTO municipio = new MunicipioDTO();
                municipio.setId(inegiMunicipio.getId());
                municipio.setNombreMunicipio(inegiMunicipio.getDescripcion());

                listaMunicipios.add(municipio);
            }
        }

        return listaMunicipios;
    }
}
