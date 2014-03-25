package mx.gob.renapo.registrocivil.showcase;

import mx.gob.renapo.registrocivil.ws.consultaWS.ConsultaWS;
import mx.gob.renapo.registrocivil.ws.consultaWS.ConsultaWS_Service;

public class TestWS {

    public static void main(String[] args) {
        ConsultaWS_Service ws = new ConsultaWS_Service();
        ConsultaWS cws = ws.getConsultaWSPort();
        System.out.println(cws.consultaNAcurp("GUANAJUATO", "LERE020914HCMNVN01", "82ecea11b613f91798c51d53049d567e8bfccf9c"));
    }

}
