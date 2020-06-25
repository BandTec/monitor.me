package com.monitorme.oshi;

import com.monitorme.banco.ConexaoBanco;
import com.monitorme.jsensor.DadosGpu;
import java.time.LocalDateTime;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;
import oshi.software.os.OperatingSystem;

public class MainTeste {

    public static void main(String[] args) {
        Memoria m = new Memoria();
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        CentralProcessor cpu = hal.getProcessor();
        OperatingSystem os = si.getOperatingSystem();
        DadosGpu g = new DadosGpu();
        Processos proc = new Processos();

        Cpu cpux = new Cpu();
        ConexaoBanco dadosConexao = new ConexaoBanco();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());
        DadosGpu gpu = new DadosGpu();
        Memoria memo = new Memoria();
        
//        System.out.println("memo.getDadosMemoriaRam()  " + memo.getDadosMemoriaRam());
//        JSONArray xt = new JSONArray(memo.getDadosMemoriaRam());
//        JSONObject y = xt.getJSONObject(0);
////        int valor = y.getInt("MemoriaVirtual");
//        System.out.println(y.get("MemoriaVirtual"));
//        jdbcTemplate.update("insert into tbl_HardHistories(UserId, OshiStatus, GPUStatus, createdAt, updatedAt, CpuStatus) values (?,?,?,?,?,?)",
//                2, memo.saveDadosMemoria(), "gpu.saveDadosGpu()", LocalDateTime.now(), LocalDateTime.now(), cpux.saveDadosCpu());
//        List select = jdbcTemplate.queryForList("select * from tbl_HardHistories");
//        System.out.println(select);
            
    }
}
