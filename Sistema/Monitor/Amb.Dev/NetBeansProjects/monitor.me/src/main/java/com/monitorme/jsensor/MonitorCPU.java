/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorme.jsensor;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Cpu;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import java.util.List;

/**
 *
 * @author gabri
 */
public class MonitorCPU {

    Components components = JSensors.get.components();
    List<Cpu> cpus = components.cpus;

    public void showCPU() {
        if (cpus != null) {
            for (final Cpu cpu : cpus) {
                System.out.println("---------CPU Abaixo-------------");
                System.out.println("Found CPU component: " + cpu.name);
                if (cpu.sensors != null) {
                    System.out.println("Sensors: ");

                    //Print temperatures
                    List<Temperature> temps = cpu.sensors.temperatures;
                    for (final Temperature temp : temps) {
                        System.out.println(temp.name + ": " + temp.value + " C");
                    }
                    //Print Loads
                    List<Load> loads = cpu.sensors.loads;
                    for (final Load load : loads) {
                        System.out.println(load.name + ": " + load.value + " Loads");
                    }

                    //Print fan speed
                    List<Fan> fans = cpu.sensors.fans;
                    for (final Fan fan : fans) {
                        System.out.println(fan.name + ": " + fan.value + " RPM");
                    }
                }
                System.out.println("---------CPU Acima-------------");
            }
        }
    }

//    public Components getComponents() {
//        return components;
//    }

    public List<Cpu> getCpus() {
        return cpus;
    }
    
}
