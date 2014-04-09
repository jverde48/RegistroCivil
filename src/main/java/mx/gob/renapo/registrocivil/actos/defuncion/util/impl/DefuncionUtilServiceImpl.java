package mx.gob.renapo.registrocivil.actos.defuncion.util.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.defuncion.dto.DefuncionDTO;
import mx.gob.renapo.registrocivil.actos.defuncion.dto.EstadisticosDefuncionDTO;
import mx.gob.renapo.registrocivil.actos.defuncion.entity.Defuncion;
import mx.gob.renapo.registrocivil.actos.defuncion.util.DefuncionUtilService;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: fase1_16
 * Date: 8/04/14
 * Time: 02:43 AM
 * To change this template use File | Settings | File Templates.
 */
@Data
@Service
public class DefuncionUtilServiceImpl implements DefuncionUtilService{

    @Autowired
    private UtileriaService utileriaService;


    @Override
    public DefuncionDTO mapearEntityDefuncionADTO(Defuncion defuncionEntity) {

        DefuncionDTO defuncionDTO = new DefuncionDTO();


        defuncionDTO.setFinado(utileriaService.mapearEntityDTOPersona(defuncionEntity.getFallecido()));
        defuncionDTO.setCodigoRespuesta(0);
        return defuncionDTO;
    }
}
