
package com.monitorme.banco;

import com.monitorme.jsensor.DadosGpu;
import com.monitorme.oshi.Cpu;
import com.monitorme.oshi.Memoria;
import java.time.LocalDateTime;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author igor
 */
public class InserirBanco {
     ConexaoBanco dadosConexao = new ConexaoBanco();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());
        DadosGpu gpu = new DadosGpu();
        Memoria memo = new Memoria();
        Cpu cpu = new Cpu();
        
        
        public void InserirBanco(){
//        jdbcTemplate.update("insert into tbl_HardHistories(UserId, OshiStatus, GPUStatus, createdAt, updatedAt, CpuStatus) values (?,?,?,?,?,?)",
//                     User.idUser,memo.saveDadosMemoria(),"gpu.saveDadosGpu()",LocalDateTime.now(),LocalDateTime.now(), cpu.saveDadosCpu());
}
}
