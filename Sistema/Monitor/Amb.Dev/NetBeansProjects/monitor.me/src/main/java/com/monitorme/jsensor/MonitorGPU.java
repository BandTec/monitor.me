/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorme.jsensor;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import java.util.List;

/**
 *
 * @author gabri
 */
public class MonitorGPU {
    Components components = JSensors.get.components();
    List<Gpu> gpus = components.gpus;
    
    public void showGPU(){
        if (gpus != null) {
            for (final Gpu gpu : gpus) {
                System.out.println("---------GPU Abaixo-------------");
                System.out.println("Found GPU component: " + gpu.name);
                if (gpu.sensors != null) {
                    System.out.println("Sensors: ");

                    //Print temperatures
                    List<Temperature> temps = gpu.sensors.temperatures;
                    for (final Temperature temp : temps) {
                        System.out.println(temp.name + ": " + temp.value + " C");
                    }
                }
                System.out.println("---------GPU Acima-------------");
            }
        }
    }

//    public Components getComponents() {
//        return components;
//    }

    public List<Gpu> getGpus() {
        return gpus;
    }
    
}
