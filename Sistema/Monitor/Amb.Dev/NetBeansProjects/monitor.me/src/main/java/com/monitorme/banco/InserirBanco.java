
package com.monitorme.banco;

import com.monitorme.jsensor.DadosGpu;
import com.monitorme.oshi.Memoria;
import java.time.LocalDateTime;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author igor
 */
public class InserirBanco {
     ConexaoBanco con = new ConexaoBanco();
      JdbcTemplate template2 = new  JdbcTemplate(con.getDataSource());
      DadosGpu gpu = new DadosGpu();
      Memoria memo = new Memoria();
      
      
      public void InserirInforHardware(){
          template2.update("INSERT INTO tbl_HardwareHistories(Data, OshiStatus, GPUStatus, id_idUsers) VALUES (?,?,?,?)",
                     LocalDateTime.now(),memo.coletaMemoriaRam(),gpu.saveDadosGpu());
      }
}
