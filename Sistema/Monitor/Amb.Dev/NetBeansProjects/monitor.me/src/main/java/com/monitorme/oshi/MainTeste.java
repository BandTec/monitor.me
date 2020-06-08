package com.monitorme.oshi;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class MainTeste {

    public static void main(String[] args) {
        Memoria m = new Memoria();
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        CentralProcessor cpu = hal.getProcessor();
        

        System.out.println(m.dadosMemoria());
    }
}
