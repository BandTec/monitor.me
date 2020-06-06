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
    List<String> oshi = new ArrayList<>();

    private Double fanRPM, memoryGpu, memoryControllerGpu, videoEngineGpu, coreGpu, media = 0.0;
    private String nomeGpu;

    private List<Double> temperaturaGpu = new ArrayList<>();
    private List<Double> loadGpu = new ArrayList<>();

    //constructor
    public DadosGpu() {
    }

    //Metodos
    public List getLoadInfo() {
        Integer i = 0;
        for (final Gpu c : gpus) {
            List<Load> loads = c.sensors.loads;
            for (final Load x : loads) {
                i++;
                System.out.println(x.name + ": " + x.value);
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

        for (final Gpu g : gpus) {
            nomeGpu = g.name;
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
        }catch (Exception e) {
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

            System.out.println(dadosGpuToJson.toString());

            //Com esse String acima podemos guardar um unico campo
            //no banco de dados, e consumir esse JSON no front-end web
        } catch (JSONException ex) {
            Logger.getLogger(DadosGpu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dadosGpuToJson.toString();
    }

    //Getters
    public Double getMemoryGpu() {
        memoryGpu = loadGpu.get(3);
        return memoryGpu;
    }

    public Double getMemoryControllerGpu() {
        memoryControllerGpu = loadGpu.get(1);
        return memoryControllerGpu;
    }

    public Double getVideoEngineGpu() {
        videoEngineGpu = loadGpu.get(2);
        return videoEngineGpu;
    }

    public Double getCoreGpu() {
        coreGpu = loadGpu.get(0);
        return coreGpu;
    }

    @Override
    public String toString() {
        return "DadosGpu{" + "media=" + media + '}';
    }
}
