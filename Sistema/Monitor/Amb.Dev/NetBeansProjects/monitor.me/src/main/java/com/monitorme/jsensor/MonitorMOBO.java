/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorme.jsensor;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Mobo;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import java.util.List;

/**
 *
 * @author gabri
 */
public class MonitorMOBO {

    Components components = JSensors.get.components();

    List<Mobo> mobos = components.mobos;

    public void showMOBO() {

        if (mobos != null) {
            for (final Mobo disk : mobos) {
                System.out.println("---------MOBO Abaixo-------------");
                System.out.println("Found MOBO component: " + disk.name);
                if (disk.sensors != null) {
                    System.out.println("Sensors: ");

                    //Print temperatures
                    List<Temperature> temps = disk.sensors.temperatures;
                    for (final Temperature temp : temps) {
                        System.out.println(temp.name + ": " + temp.value + " C");
                    }

                    //Print fan speed
                    List<Fan> fans = disk.sensors.fans;
                    for (final Fan fan : fans) {
                        System.out.println(fan.name + ": " + fan.value + " RPM");
                    }
                }
                System.out.println("---------MOBO Acima-------------");
            }
        }
    }

//    public Components getComponents() {
//        return components;
//    }

    public List<Mobo> getMobos() {
        return mobos;
    }
    
}
