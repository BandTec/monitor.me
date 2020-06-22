package com.monitorme.oshi;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
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
    private List<String> dadosRam = new ArrayList<>();
    private List<String> discosRigidos = new ArrayList<>();
    private List<String> dadosColetados = new ArrayList<>();
    //Atributos

    //MetodoMain
    public List dadosMemoria() {
        coletaMemoriaRam();
        coletaDiscosRigidos(hal.getDiskStores());
        
        dadosColetados.add(this.getDadosMemoriaRam().toString());
        dadosColetados.add(this.getDiscosRigidos().toString());
        return dadosColetados;
    }

    //Metodos
    
    //Memoria Ram
    public List<String> coletaMemoriaRam() {
//        long ram = (hal.getMemory().getAvailable() / 1024)/ 1024;
        
        dadosRam.add("Avaiable: " + (hal.getMemory().getAvailable() / 1024)/ 1024);
        dadosRam.add("Page Size: " + hal.getMemory().getPageSize());
//        dadosRam.add("Memory Phisical: " + hal.getMemory().getPhysicalMemory());
        
        PhysicalMemory[] pmArray = hal.getMemory().getPhysicalMemory();
        if (pmArray.length > 0) {
            dadosRam.add("\n Physical Memory: ");
            for (PhysicalMemory pm : pmArray) {
                dadosRam.add("Bank Label: " + pm.getBankLabel());
                dadosRam.add("Manufacturer : " + pm.getManufacturer());
                dadosRam.add("Memory Type: " + pm.getMemoryType());
                dadosRam.add("Capacidade: " + ((pm.getCapacity()/1024)/1024));
                dadosRam.add("\n Velocidade de Clock: " + ((pm.getClockSpeed()/1024)/1024));
            }
        }
        dadosRam.add("Memoria Virtual: " + hal.getMemory().getVirtualMemory());
        dadosRam.add("Memoria Total: " + (hal.getMemory().getTotal()/ 1024)/ 1024);
        return dadosRam;
    }
    
    //Porcetagem da memória que está sendo gasta
    public float getPorcentagemRam(){
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
                discosRigidos.add("\n | Minor: " + part.getMajor());
                discosRigidos.add("\n | Major: " + part.getMinor());
            }
        }
        return discosRigidos;
    }

    //Getters & Setters
    public List<String> getDadosMemoriaRam() {
        coletaMemoriaRam();
        return dadosRam;
    }

    public List<String> getDiscosRigidos() {
        coletaDiscosRigidos(hal.getDiskStores());
        return discosRigidos;
    }
    
    public String saveDadosMemoria(){
        
        JSONObject dadosMemoToJson = new JSONObject();
        
        try {
            dadosMemoToJson.put("porcentRam", String.format(" %.2f", getPorcentagemRam()));
            dadosMemoToJson.put("dadosRam", getDadosMemoriaRam());
            dadosMemoToJson.put("dadosDiscosRigidos", getDiscosRigidos());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        return dadosMemoToJson.toString();
    }
}
