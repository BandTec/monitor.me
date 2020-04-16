
package com.monitorme.jsensor;

import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Disk;
import com.profesorfalken.jsensors.model.sensors.Fan;
import com.profesorfalken.jsensors.model.sensors.Load;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import java.util.List;

public class MonitorHDISK {

    Components components = JSensors.get.components();

    List<Disk> disks = components.disks;

    public void showHDISK() {
        if (disks != null) {
            for (final Disk disk : disks) {
                System.out.println("---------HDISK Abaixo-------------");
                System.out.println("Found HDISK component: " + disk.name);
                if (disk.sensors != null) {
                    System.out.println("Sensors: ");

                    //Print temperatures
                    List<Temperature> temps = disk.sensors.temperatures;
                    for (final Temperature temp : temps) {
                        System.out.println(temp.name + ": " + temp.value + " C");
                    }
                    
                    //Print Loads
                    List<Load> loads = disk.sensors.loads;
                    for (final Load load : loads) {
                        System.out.println(load.name + ": " + load.value + " Loads");
                    }

                    //Print fan speed
                    List<Fan> fans = disk.sensors.fans;
                    for (final Fan fan : fans) {
                        System.out.println(fan.name + ": " + fan.value + " RPM");
                    }
                }
                System.out.println("---------HDISK Acima-------------");
            }
        }
    }

//    public Components getComponents() {
//        return components;
//    }

    public List<Disk> getDisks() {
        return disks;
    }
    
}
