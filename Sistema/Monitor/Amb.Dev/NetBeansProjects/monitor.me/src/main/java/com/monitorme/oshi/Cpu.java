/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorme.oshi;

import static com.monitorme.oshi.SystemInfoTest.oshi;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.TickType;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Sensors;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;
import oshi.util.Util;

public class Cpu {

    DecimalFormat df = new DecimalFormat();
    private SystemInfo si = new SystemInfo();
    private HardwareAbstractionLayer hal = si.getHardware();
    private CentralProcessor cpu = hal.getProcessor();
    private Sensors sensors = hal.getSensors();
    private float dadosCPU;
    private List<Double> listFloatCpu = new ArrayList<>();
    long[] freq;

    //informaçoes do processador
    public String printProcessor() {
        return cpu.getProcessorIdentifier().getName();
    }

    //velocidade de clock de cada processador lógico
    public StringBuilder getClock() {
        freq = cpu.getCurrentFreq();
        StringBuilder sb = new StringBuilder("Current Frequencies: ");

        if (freq[0] > 0) {
            for (int i = 0; i < freq.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(FormatUtil.formatHertz(freq[i]));
            }
        }
        return sb;
    }

    public Double getTemperature() {
        return sensors.getCpuTemperature();
    }

    public float getUso() {
        try {

            CentralProcessor cp = hal.getProcessor();
            long[] prevTicks = cp.getSystemCpuLoadTicks();
            Util.sleep(1000);
            float usoCPU = (float) (cp.getSystemCpuLoadBetweenTicks(prevTicks) * 100d);
            dadosCPU = usoCPU;
        } catch (Exception e) {
            System.out.println("erro: " + e);;
        }
        return dadosCPU;
    }
}
