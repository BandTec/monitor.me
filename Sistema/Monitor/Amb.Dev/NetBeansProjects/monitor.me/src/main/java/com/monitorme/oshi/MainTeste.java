package com.monitorme.oshi;

import com.monitorme.jsensor.DadosGpu;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class MainTeste {

    public static void main(String[] args) {
        Memoria m = new Memoria();
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        CentralProcessor cpu = hal.getProcessor();
        DadosGpu g = new DadosGpu();
        
        //EXECUTE SEMPRE O NETBEANS COMO ADM, POIS PRECISA DE PERMISSAO ELEVADA PARA TER ACESSO AOS SENSORES
        
        //Sensores do Hardware
        System.out.println(m.sensoresHardware(hal.getSensors()));
        System.out.println(hal.getSensors().getFanSpeeds());
        System.out.println(hal.getSensors().getCpuTemperature());
        
        //Cpu
        System.out.println(hal.getGraphicsCards().getClass());
        
        //Gpu
        System.out.println(g.capturaGpuOshi(hal.getGraphicsCards()));
        
        //Gpu teste com tudo que a api Jsensors consegue abstrair
        System.out.println("\n\n");
        System.out.println("JSensors: " + g.capturaGpuJsensor());
        
        
        //Por algum motivo os processos não encerram, entao se testar lembre de encerrar aqui no canto >>> clicando no x
    }
}
