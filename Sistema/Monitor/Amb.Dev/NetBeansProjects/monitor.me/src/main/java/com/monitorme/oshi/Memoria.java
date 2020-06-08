package com.monitorme.oshi;

import java.util.ArrayList;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HWPartition;
import oshi.hardware.HardwareAbstractionLayer;

public class Memoria {

    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    CentralProcessor cpu = hal.getProcessor();

    private GlobalMemory ramDisponivel;
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
    private GlobalMemory coletaMemoriaRam() {
        this.ramDisponivel = hal.getMemory();
        return ramDisponivel;
    }

    public List<String> coletaDiscosRigidos(HWDiskStore[] diskStores) {
        for (HWDiskStore disk : diskStores) {
            discosRigidos.add("\n\n Modelo: " + disk.getModel());
//            discosRigidos.add("Nome: " + disk.getName()); // Talvez não seja necessário por isso deixei comentado
            discosRigidos.add("Serial: " + disk.getSerial());
            
            HWPartition[] partitions = disk.getPartitions();
            for (HWPartition part : partitions) {
                discosRigidos.add("\n\n | Identificacao " + part.getIdentification());
                discosRigidos.add("\n | MountPoint: " + part.getMountPoint());
                discosRigidos.add("\n | Name: " + part.getName());
                discosRigidos.add("\n | Tipo: " + part.getType());
                discosRigidos.add("\n | Uuid: " + part.getUuid());
            }
        }
        return discosRigidos;
    }

    //Getters & Setters
    public GlobalMemory getRamDisponivel() {
        return ramDisponivel;
    }

    public List<String> getDiscosRigidos() {
        return discosRigidos;
    }
}
