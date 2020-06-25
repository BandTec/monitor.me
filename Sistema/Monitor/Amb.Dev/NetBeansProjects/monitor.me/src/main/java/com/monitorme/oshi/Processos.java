package com.monitorme.oshi;

import com.monitorme.jsensor.DadosGpu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;    
import java.util.logging.Level;
import java.util.logging.Logger;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.software.os.OperatingSystem.ProcessSort;
import oshi.util.FormatUtil;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A demonstration of access to many of OSHI's capabilities
 */
public class Processos {

    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    OperatingSystem os = si.getOperatingSystem();
    
    private List<String> oshiProcessos = new ArrayList<>();
    List<JSONObject> jsonProcessos = new ArrayList<>();
    
    //Retorna os 10 processos organizados
    public List retornaProcessos() {
        GlobalMemory memory = hal.getMemory();
        List<OSProcess> procs = Arrays.asList(os.getProcesses(10, ProcessSort.CPU));
        for(OSProcess processos : procs){

            oshiProcessos.add(String.valueOf(processos.getProcessID())); //Add numero do PID por processo
            oshiProcessos.add(String.valueOf(100d * (processos.getKernelTime() + processos.getUserTime()) / processos.getUpTime())); //Adiciona %CPU usada por processo
            oshiProcessos.add(String.valueOf(100d * processos.getResidentSetSize() / memory.getTotal())); //Adiciona %memoria utilizada por processo
            oshiProcessos.add(String.valueOf(FormatUtil.formatBytes(processos.getVirtualSize()))); //Adiciona qtd total de memoria (virtual) utilizada por processo
            oshiProcessos.add(String.valueOf(FormatUtil.formatBytes(processos.getResidentSetSize()))); //Adiciona qtd total de memoria (fisica) utilizada por processo
            oshiProcessos.add(String.valueOf(processos.getName())); //Adiciona nome do processo;
            oshiProcessos.add(String.valueOf(processos.getUser())); //Adiciona usuario do processo;

        }
        return oshiProcessos;
    }
    
    public String saveDadosProcessos(){;
        retornaProcessos();
        GlobalMemory memory = hal.getMemory();
        List<OSProcess> procs = Arrays.asList(os.getProcesses(10, ProcessSort.CPU));
        JSONObject json = new JSONObject();
          

        for(OSProcess pr : procs){
            oshiProcessos.add("PID" + pr.getProcessID());
            oshiProcessos.add("%CPU" + (100d * (pr.getKernelTime() + pr.getUserTime()) / pr.getUpTime()));
            oshiProcessos.add("%MEM" + 100d * pr.getResidentSetSize() / memory.getTotal());
            oshiProcessos.add("%VSZ" + FormatUtil.formatBytes(pr.getVirtualSize()));
            oshiProcessos.add("%RSS" + FormatUtil.formatBytes(pr.getResidentSetSize()));
            oshiProcessos.add("NOME" + pr.getName());
            oshiProcessos.add("USER" + pr.getUser());
        }
        
        try {
            json.put("procStatus", oshiProcessos);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return json.toString();
        
    }

}