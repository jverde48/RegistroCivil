package mx.gob.renapo.registrocivil.comun.dto;

import mx.gob.renapo.registrocivil.catalogos.dto.CatalogoDTO;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 1:32 PM
 * DTO para notas marginales
 */
public class NotasMarginalesDTO {

    private Long id;
    private Date fechaRegistro;
    private Boolean imprimible;
    private StringBuilder informacion;
    private CatalogoDTO tipoNotaMarginal;

}
