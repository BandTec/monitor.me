package com.monitorme.oshi;

import com.monitorme.banco.ConexaoBanco;
import com.monitorme.jsensor.DadosGpu;
import java.time.LocalDateTime;
import java.util.List;
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

        ConexaoBanco dadosConexao = new ConexaoBanco();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());
        DadosGpu gpu = new DadosGpu();
        Memoria memo = new Memoria();

//        jdbcTemplate.update("insert into tbl_HardHistories(UserId, OshiStatus, GPUStatus, createdAt, updatedAt) values (?,?,?,?,?)",
//                2, memo.saveDadosMemoria(), "gpu.saveDadosGpu()", LocalDateTime.now(), LocalDateTime.now());
//        List select = jdbcTemplate.queryForList("select * from tbl_HardHistories");
//        System.out.println(select);
            

//        System.out.println(g.getNomeGpu());
//        System.out.println(g.getMemoryGpu());
//        System.out.println(g.capturaNomeGpuOshi());
//EXECUTE SEMPRE O NETBEANS COMO ADM, POIS PRECISA DE PERMISSAO ELEVADA PARA TER ACESSO AOS SENSORES
//Sensores do Hardware
//        System.out.println(m.sensoresHardware(hal.getSensors()));
//        System.out.println(hal.getSensors().getFanSpeeds());
//        System.out.println(hal.getSensors().getCpuTemperature());
//        
//        //Cpu
//        System.out.println(hal.getGraphicsCards().getClass());
//        
//        //Gpu
//        System.out.println(g.capturaGpuOshi(hal.getGraphicsCards()));
//        
//        //Gpu teste com tudo que a api Jsensors consegue abstrair
//        System.out.println("\n\n");
//        System.out.println("JSensors: " + g.capturaGpuJsensor());
//          System.out.println(">> "+ proc.saveDadosProcessos());
//        //Processos
//        System.out.println("\n\n");        
////        System.out.println(proc.printProcesses(os, hal.getMemory()));
//        System.out.println("Processos: " + proc.retornaProcessos());        
//Por algum motivo os processos não encerram, entao se testar lembre de encerrar aqui no canto >>> clicando no x
//Dados Cpu vindos do Oshi
        Cpu cpux = new Cpu();
        System.out.println(cpux.saveDadosCpu());
//        System.out.println(cpux.printProcessor());
//        System.out.println(cpux.getClock());
//        System.out.println(String.format("%.2fºC", cpux.getTemperature()));
//        System.out.println(cpux.getUso());
//          System.out.println(m.getHdDisponivel());
//        System.out.println(m.saveDadosMemoria());
//          System.out.println(m.coletaDadosMemoria(hal.getDiskStores()));
    }
}
