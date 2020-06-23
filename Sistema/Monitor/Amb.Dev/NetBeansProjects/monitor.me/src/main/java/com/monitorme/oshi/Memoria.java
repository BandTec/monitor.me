package com.monitorme.oshi;

import static com.monitorme.oshi.SystemInfoTest.oshi;
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
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class Memoria {

    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    CentralProcessor cpu = hal.getProcessor();
    OperatingSystem os = si.getOperatingSystem();
    FileSystem fs = os.getFileSystem();

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

        dadosRam.add("Avaiable: " + (hal.getMemory().getAvailable() / 1024) / 1024);
        dadosRam.add("Page Size: " + hal.getMemory().getPageSize());
//        dadosRam.add("Memory Phisical: " + hal.getMemory().getPhysicalMemory());

        PhysicalMemory[] pmArray = hal.getMemory().getPhysicalMemory();
        if (pmArray.length > 0) {
            dadosRam.add("\n Physical Memory: ");
            for (PhysicalMemory pm : pmArray) {
                dadosRam.add("Bank Label: " + pm.getBankLabel());
                dadosRam.add("Manufacturer : " + pm.getManufacturer());
                dadosRam.add("Memory Type: " + pm.getMemoryType());
                dadosRam.add("Capacidade: " + ((pm.getCapacity() / 1024) / 1024));
                dadosRam.add("\n Velocidade de Clock: " + ((pm.getClockSpeed() / 1024) / 1024));
            }
        }
        dadosRam.add("Memoria Virtual: " + hal.getMemory().getVirtualMemory());
        dadosRam.add("Memoria Total: " + (hal.getMemory().getTotal() / 1024) / 1024);
        return dadosRam;
    }

    //Porcetagem da memória que está sendo gasta
    public float getPorcentagemRam() {
        long usadoMem = hal.getMemory().getTotal() - hal.getMemory().getAvailable();
        return this.porcentagemMemoria = (float) ((100d * usadoMem) / hal.getMemory().getTotal());
    }

    //Disco Rigido
    public List<String> coletaDiscosRigidos(HWDiskStore[] diskStores) {
        for (HWDiskStore disk : diskStores) {
            discosRigidos.add("Modelo: " + disk.getModel());
//            discosRigidos.add("Nome: " + disk.getName()); // Talvez não seja necessário por isso deixei comentado
            discosRigidos.add("Serial: " + disk.getSerial());

            HWPartition[] partitions = disk.getPartitions();
            for (HWPartition part : partitions) {
                discosRigidos.add("Identificacao: " + part.getIdentification());
                discosRigidos.add("MountPoint: " + part.getMountPoint());
                discosRigidos.add("Name: " + part.getName());
                discosRigidos.add("Tipo: " + part.getType());
                discosRigidos.add("Uuid: " + part.getUuid());
                discosRigidos.add("Minor: " + part.getMajor());
                discosRigidos.add("Major: " + part.getMinor());
            }
        }
        return discosRigidos;
    }

//    pegar a quantia total de espaço disponivel
    public List<String> getHdDisponivel() {
        OSFileStore[] fsArray = fs.getFileStores();
        List<String> diskName = new ArrayList<>();
        String hdDisponivel;
        for (OSFileStore fs : fsArray) {
            hdDisponivel = String.valueOf((fs.getMount())) + String.format(" %.2f", Double.valueOf(((fs.getUsableSpace() / 1024) / 1024) / 1024));
            diskName.add(hdDisponivel);
        }
        return diskName;
    }

//    pegar a capacidade total de HD
    public List<String> getHdTotal() {
        OSFileStore[] fsArray = fs.getFileStores();
        List<String> disksFree = new ArrayList<>();
        String hdTotal;

        for (OSFileStore fs : fsArray) {
            hdTotal = String.valueOf((fs.getMount())) + (String.valueOf(FormatUtil.formatBytes(fs.getTotalSpace())));
            disksFree.add(hdTotal);
        }

        return disksFree;
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

    public String saveDadosMemoria() {

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
