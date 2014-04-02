package mx.gob.renapo.registrocivil.catalogos.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatEstadoDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.catalogos.entity.CatPais;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoService;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import mx.gob.renapo.registrocivil.util.impl.UtileriaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 18/03/14
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */

@Data
@Service
public class CatEstadoServiceImpl implements CatEstadoService {

    @Autowired
    private CatEstadoDAO estadoDAO;

    @Autowired
    private UtileriaService utileriaService;

    @Override
    public EstadoDTO findById(Long id) {
        EstadoDTO estadoDTO = null;
        CatEstado estadoEntity = estadoDAO.recuperarRegistro(id);

        if (estadoEntity != null) {
            estadoDTO = new EstadoDTO();
            estadoDTO.setId(estadoEntity.getId());
            estadoDTO.setIdRenapo(estadoEntity.getIdRenapo());
            estadoDTO.setNombreEstado(estadoEntity.getDescripcion());
            estadoDTO.setMunicipios(null);
            estadoDTO.setPais(null);
        }

        return estadoDTO;
    }

    @Override
    public List<EstadoDTO> findAll() {
        List<EstadoDTO> listaEstadosDTO = null;
        List<CatEstado> listaEstadosEntity = estadoDAO.listarRegistros();

        if (listaEstadosEntity != null && !listaEstadosEntity.isEmpty()) {
            listaEstadosDTO  = new ArrayList<EstadoDTO>();
            for (CatEstado estado : listaEstadosEntity) {
                EstadoDTO estadoDTO = new EstadoDTO();
                estadoDTO.setId(estado.getId());
                estadoDTO.setIdRenapo(estado.getIdRenapo());
                estadoDTO.setNombreEstado(estado.getDescripcion());
                estadoDTO.setPais(null);

                listaEstadosDTO.add(estadoDTO);
            }
        }

        return listaEstadosDTO;
    }

	@Override
	public List<EstadoDTO> recuperarPorPais(PaisDTO pais) {
		List<EstadoDTO> listaEstadosDTO = null;
		CatPais paisEntity = utileriaService.recupearPais(pais);
		List<CatEstado> listaEstadosEntity = estadoDAO.recuperarEstadosPorPais(paisEntity);
		
		if (listaEstadosEntity != null && !listaEstadosEntity.isEmpty()) {
            listaEstadosDTO  = new ArrayList<EstadoDTO>();
            for (CatEstado estado : listaEstadosEntity) {
                EstadoDTO estadoDTO = new EstadoDTO();
                estadoDTO.setId(estado.getId());
                estadoDTO.setIdRenapo(estado.getIdRenapo());
                estadoDTO.setNombreEstado(estado.getDescripcion());
                estadoDTO.setPais(null);

                listaEstadosDTO.add(estadoDTO);
            }
        }
		return listaEstadosDTO;
	}
}
