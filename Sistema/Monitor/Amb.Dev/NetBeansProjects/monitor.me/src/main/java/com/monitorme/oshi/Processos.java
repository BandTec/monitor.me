package com.monitorme.oshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
    
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.software.os.OperatingSystem.ProcessSort;
import oshi.util.FormatUtil;

/**
 * A demonstration of access to many of OSHI's capabilities
 */
public class Processos {

    Memoria m = new Memoria();
    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    CentralProcessor cpu = hal.getProcessor();
    OperatingSystem os = si.getOperatingSystem();
    private List<String> oshi = new ArrayList<>();
    
    //Retorna os 10 processos organizados
    public List retornaProcessos(GlobalMemory memory) {
        List<OSProcess> procs = Arrays.asList(os.getProcesses(10, ProcessSort.CPU));
        for(OSProcess processos : procs){
            System.out.println("\nPID: " + processos.getProcessID());
            System.out.println("%CPU: " + 100d * (processos.getKernelTime() + processos.getUserTime()) / processos.getUpTime());
            oshi.add(String.valueOf(processos.getProcessID())); //Add numero do PID por processo
            oshi.add(String.valueOf(100d * (processos.getKernelTime() + processos.getUserTime()) / processos.getUpTime())); //Adiciona %CPU usada por processo
            oshi.add(String.valueOf(100d * processos.getResidentSetSize() / memory.getTotal())); //Adiciona %memoria utilizada por processo
            oshi.add(String.valueOf(FormatUtil.formatBytes(processos.getVirtualSize()))); //Adiciona qtd total de memoria (virtual) utilizada por processo
            oshi.add(String.valueOf(FormatUtil.formatBytes(processos.getResidentSetSize()))); //Adiciona qtd total de memoria (fisica) utilizada por processo
            oshi.add(String.valueOf(processos.getName())); //Adiciona nome do processo;
            oshi.add(String.valueOf(processos.getUser())); //Adiciona usuario do processo;
            oshi.add(String.valueOf(processos.getUser())); //Adiciona usuario do processo;
            

        }
//        System.out.println(oshi);
        return oshi;

    }

    public List printProcesses(OperatingSystem os, GlobalMemory memory) {
        oshi.add("My PID: " + os.getProcessId() + " with affinity "
                + Long.toBinaryString(os.getProcessAffinityMask(os.getProcessId())));
        oshi.add("Processes: " + os.getProcessCount() + ", Threads: " + os.getThreadCount());
        // Sort by highest CPU
        List<OSProcess> procs = Arrays.asList(os.getProcesses(10, ProcessSort.CPU));

        oshi.add("   PID  %CPU %MEM       VSZ       RSS Name");
        for (int i = 0; i < procs.size() && i < 10; i++) {
            OSProcess p = procs.get(i);
            oshi.add(String.format(" %5d %5.1f %4.1f %9s %9s %s", p.getProcessID(),
                    100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime(),
                    100d * p.getResidentSetSize() / memory.getTotal(), FormatUtil.formatBytes(p.getVirtualSize()),
                    FormatUtil.formatBytes(p.getResidentSetSize()), p.getName()));
        }
        return oshi;
    }

}