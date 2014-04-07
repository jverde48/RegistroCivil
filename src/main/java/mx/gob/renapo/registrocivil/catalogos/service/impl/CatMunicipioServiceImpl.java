package mx.gob.renapo.registrocivil.catalogos.service.impl;

import mx.gob.renapo.registrocivil.catalogos.dao.CatMunicipioDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.MunicipioDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatMunicipioService;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import mx.gob.renapo.registrocivil.util.impl.UtileriaServiceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.catalogos.entity.CatMunicipio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: Alejandro Diaz Date: 3/20/14 Time: 2:40 PM
 * Implementacion de service de catalogo de municipios
 */
@Service
public class CatMunicipioServiceImpl implements CatMunicipioService {

    private static Logger logger = Logger.getLogger(CatInegiMunicipioServiceImpl.class);

	@Autowired
	private CatMunicipioDAO municipioDAO;

    @Autowired
    private UtileriaService utileriaService;

	public List<MunicipioDTO> findAll() {
        List<MunicipioDTO> municipios = new ArrayList<MunicipioDTO>();
        try {
            List<CatMunicipio> listaMunicipiosEntity = municipioDAO
                    .listarRegistros();

            for (CatMunicipio municipioEntity : listaMunicipiosEntity) {
                municipios.add(utileriaService.mapearEntityADtoMunicipio(municipioEntity));
            }
        }catch (Exception e) {
           logger.error("Error: " + e);
        }
		return municipios;

	}

	public MunicipioDTO findById(Long id) {
        CatMunicipio municipio = null;
        try {
            municipio = municipioDAO.recuperarRegistro(id);
        }catch (Exception e) {
          logger.error("Error: " + e);
        }
		return utileriaService.mapearEntityADtoMunicipio(municipio);
	}

	public CatMunicipioDAO getMunicipioDAO() {
		return municipioDAO;
	}

	public void setMunicipioDAO(CatMunicipioDAO municipioDAO) {
		this.municipioDAO = municipioDAO;
	}

	@Override
	public List<MunicipioDTO> recuperarMunicipiosPorEstado(EstadoDTO estado) {
		CatEstado estadoEntity = utileriaService.recuperarEstado(estado);
		List<CatMunicipio> listaMunicipiosEntity = municipioDAO
				.recuperarMunicipiosPorEstado(estadoEntity);
		List<MunicipioDTO> municipios = new ArrayList<MunicipioDTO>();
		for (CatMunicipio municipioEntity : listaMunicipiosEntity) {
			municipios.add(utileriaService.mapearEntityADtoMunicipio(municipioEntity));
		}

		return municipios;
	}

}
