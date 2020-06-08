package com.monitorme.oshi;

import java.util.ArrayList;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PhysicalMemory;
import oshi.hardware.Sensors;

public class Memoria {

    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    CentralProcessor cpu = hal.getProcessor();

    
    private float porcentagemMemoria;
    private List<String> ramDisponivel = new ArrayList<>();
    private List<String> discosRigidos = new ArrayList<>();
    private List<String> dadosColetados = new ArrayList<>();
    //Atributos

    //MetodoMain
    public List dadosMemoria() {
        coletaMemoriaRam();
        coletaDiscosRigidos(hal.getDiskStores());
        
        dadosColetados.add(this.getRamDisponivel().toString());
        dadosColetados.add(this.getDiscosRigidos().toString());
        return dadosColetados;
    }

    //Metodos
    
    //Memoria Ram
    public List<String> coletaMemoriaRam() {
//        long ram = (hal.getMemory().getAvailable() / 1024)/ 1024;
        
        ramDisponivel.add("Avaiable: " + (hal.getMemory().getAvailable() / 1024)/ 1024);
        ramDisponivel.add("Page Size: " + hal.getMemory().getPageSize());
//        ramDisponivel.add("Memory Phisical: " + hal.getMemory().getPhysicalMemory());
        
        PhysicalMemory[] pmArray = hal.getMemory().getPhysicalMemory();
        if (pmArray.length > 0) {
            ramDisponivel.add("\n Physical Memory: ");
            for (PhysicalMemory pm : pmArray) {
                ramDisponivel.add("Bank Label: " + pm.getBankLabel());
                ramDisponivel.add("Manufacturer : " + pm.getManufacturer());
                ramDisponivel.add("Memory Type: " + pm.getMemoryType());
                ramDisponivel.add("Capacidade: " + ((pm.getCapacity()/1024)/1024));
                ramDisponivel.add("\n Velocidade de Clock: " + ((pm.getClockSpeed()/1024)/1024));
            }
        }
        ramDisponivel.add("Memoria Virtual: " + hal.getMemory().getVirtualMemory());
        ramDisponivel.add("Memoria Total: " + (hal.getMemory().getTotal()/ 1024)/ 1024);
        return ramDisponivel;
    }
    
    public float memoriaRamPorcentagem(){
        long usadoMem = hal.getMemory().getTotal() - hal.getMemory().getAvailable();
        return this.porcentagemMemoria = (float) ((100d * usadoMem) / hal.getMemory().getTotal());
    }
    
    //Disco Rigido
    public List<String> coletaDiscosRigidos(HWDiskStore[] diskStores) {
        for (HWDiskStore disk : diskStores) {
            discosRigidos.add("\n\n Modelo: " + disk.getModel());
//            discosRigidos.add("Nome: " + disk.getName()); // Talvez não seja necessário por isso deixei comentado
            discosRigidos.add("Serial: " + disk.getSerial());
            
            HWPartition[] partitions = disk.getPartitions();
            for (HWPartition part : partitions) {
                discosRigidos.add("\n | Identificacao " + part.getIdentification());
                discosRigidos.add("\n | MountPoint: " + part.getMountPoint());
                discosRigidos.add("\n | Name: " + part.getName());
                discosRigidos.add("\n | Tipo: " + part.getType());
                discosRigidos.add("\n | Uuid: " + part.getUuid());
            }
        }
        return discosRigidos;
    }

    public String teste(Sensors sensors){
        return "Sensors: " + sensors.toString();
    }
    
    //Getters & Setters
    public List<String> getRamDisponivel() {
        return ramDisponivel;
    }

    public List<String> getDiscosRigidos() {
        return discosRigidos;
    }
}
