package com.monitorme.jsensor;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import oshi.SystemInfo;
import oshi.hardware.GraphicsCard;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class DadosGpu {

    //JSensors
    Components components = JSensors.get.components();
    List<Gpu> gpus = components.gpus;
    //Oshi
    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    OperatingSystem os = si.getOperatingSystem();
    List<String> gpuOshi = new ArrayList<>();

    private Double fanRPM, memoryGpu, memoryControllerGpu, videoEngineGpu, coreGpu, media = 0.0;
    private String nomeGpu;

    private List<Double> temperaturaGpu = new ArrayList<>();
    private List<Double> loadGpu = new ArrayList<>();
    List<String> gpuJSensor = new ArrayList<>();

    //Metodos
    //Tentando capturar GPU com oshi
    public List<String> capturaGpuOshi(GraphicsCard[] cards) {
        gpuOshi.add("Graphics Cards:");
        if (cards.length == 0) {
            gpuOshi.add(" None detected.");
        } else {
            for (GraphicsCard card : cards) {
                gpuOshi.add("\nName: " + card.getName());
                gpuOshi.add("\nId: " + card.getDeviceId());
                gpuOshi.add("\nFabricante: " + card.getVendor());
                gpuOshi.add("\nInformações de fábricação: " + card.getVersionInfo());
                gpuOshi.add("\nVRam total: " + ((card.getVRam() / 1024) / 1024));
            }
        }

        return gpuOshi;
    }

    public List<String> capturaGpuJsensor() {
        for (final Gpu g : gpus) {
            nomeGpu = g.name;
            List<Load> loads = g.sensors.loads;
            for (final Load loadGpu : loads) {
                System.out.println("\n " + loadGpu.name + ": " + loadGpu.value);
                gpuJSensor.add(loadGpu.name + ": " + loadGpu.value);
            }

            List<Fan> fans = g.sensors.fans;
            for (final Fan fansGpu : fans) {
                System.out.println(fansGpu.name + ": " + fansGpu.value);
                gpuJSensor.add(fansGpu.name + ": " + fansGpu.value);
            }

            List<Temperature> temp = g.sensors.temperatures;
            for (final Temperature tempGpu : temp) {
                System.out.println(tempGpu.name + ": " + tempGpu.value);
                gpuJSensor.add(tempGpu.name + ": " + tempGpu.value + "\n");
            }
        }
        return gpuJSensor;
    }

    //Metodo Main, deve ser chamado primeiro
    public List getLoadInfo() {
        Integer i = 0;
        for (final Gpu c : gpus) {
            List<Load> loads = c.sensors.loads;
            for (final Load x : loads) {
                i++;
                if (x.name.startsWith("Load GPU Core")) {
                    loadGpu.add(x.value);
                } else if (x.name.startsWith("Load GPU Memory Controller")) {
                    loadGpu.add(x.value);
                } else if (x.name.startsWith("Load GPU Video Engine")) {
                    loadGpu.add(x.value);
                } else if (x.name.startsWith("Load GPU Memory")) {
                    loadGpu.add(x.value);
                }
            }
        }
        return loadGpu;
    }

    public String getNomeGpu() {
        try {
            for (GraphicsCard c : hal.getGraphicsCards()) {
                this.nomeGpu = c.getName();
            }
            return nomeGpu;
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return nomeGpu;
    }

    public Double getMediaTemperatura() {
        try {
            Double soma = 0.0;
            for (final Gpu g : gpus) {

                List<Temperature> temps = g.sensors.temperatures;
                for (final Temperature t : temps) {
                    temperaturaGpu.add(t.value);
                }
                for (Integer i = 0; i < temperaturaGpu.size(); i++) {
                    soma += temperaturaGpu.get(i);
                }
            }
            media = soma / temperaturaGpu.size();
        } catch (Exception e) {
            System.out.println(e);
        }
        return media;
    }

    public Double getFanRpm() {
        for (final Gpu g : gpus) {
            List<Fan> fans = g.sensors.fans;
            System.out.println("fans encontradas = " + fans);
            for (final Fan fan : fans) {
                System.out.println(fan.name + ": " + fan.value + " RPM");
            }
        }
        return fanRPM;
    }

    public String saveDadosGpu() {
        getLoadInfo();
        JSONObject dadosGpuToJson = new JSONObject();

        try {
            dadosGpuToJson.put("nomeGpu", getNomeGpu());
            dadosGpuToJson.put("coreGpu", getCoreGpu());
            dadosGpuToJson.put("fanGpu", getFanRpm());
            dadosGpuToJson.put("temperaturaMedia", getMediaTemperatura());
            dadosGpuToJson.put("memoriaCtrlGpu", getMemoryControllerGpu());
            dadosGpuToJson.put("memoriaVRamGpu", getMemoryGpu());
            dadosGpuToJson.put("videoEngineGpu", getVideoEngineGpu());

            //Com esse String acima podemos guardar um unico campo
            //no banco de dados, e consumir esse JSON no front-end web
        } catch (JSONException ex) {
            Logger.getLogger(DadosGpu.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return dadosGpuToJson.toString();
    }

    //Getters
    public Double getMemoryGpu() {
        getLoadInfo();
        memoryGpu = loadGpu.get(3);
        
        if (memoryGpu == null || memoryGpu == 0) {
            for(GraphicsCard c : hal.getGraphicsCards()){
                this.memoryGpu = Double.valueOf(c.getVRam());
                System.out.println(this.memoryGpu);
            }
        }
        return memoryGpu;
    }

    public Double getMemoryControllerGpu() {
        getLoadInfo();
        memoryControllerGpu = loadGpu.get(1);
        return memoryControllerGpu;
    }

    public Double getVideoEngineGpu() {
        getLoadInfo();
        videoEngineGpu = loadGpu.get(2);
        return videoEngineGpu;
    }

    public Double getCoreGpu() {
        getLoadInfo();
        coreGpu = loadGpu.get(0);
        return coreGpu;
    }
}
