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

    //temperatura atual do processador
    public Double getTemperature() {
        return sensors.getCpuTemperature();
    }

    //uso do processador
    public void getUso() {
        try {
            
            long[] prevTicks = cpu.getSystemCpuLoadTicks();
            long[][] prevProcTicks = cpu.getProcessorCpuLoadTicks();

            Util.sleep(300);
            long[] ticks = cpu.getSystemCpuLoadTicks();

            long user = ticks[TickType.USER.getIndex()] - prevTicks[TickType.USER.getIndex()];
            long nice = ticks[TickType.NICE.getIndex()] - prevTicks[TickType.NICE.getIndex()];
            long sys = ticks[TickType.SYSTEM.getIndex()] - prevTicks[TickType.SYSTEM.getIndex()];
            long idle = ticks[TickType.IDLE.getIndex()] - prevTicks[TickType.IDLE.getIndex()];
            long iowait = ticks[TickType.IOWAIT.getIndex()] - prevTicks[TickType.IOWAIT.getIndex()];
            long irq = ticks[TickType.IRQ.getIndex()] - prevTicks[TickType.IRQ.getIndex()];
            long softirq = ticks[TickType.SOFTIRQ.getIndex()] - prevTicks[TickType.SOFTIRQ.getIndex()];
            long steal = ticks[TickType.STEAL.getIndex()] - prevTicks[TickType.STEAL.getIndex()];
            long totalCpu = user + nice + sys + idle + iowait + irq + softirq + steal;
            
            
            double[] load = cpu.getProcessorCpuLoadBetweenTicks(prevProcTicks);
            Integer somaProc = 0;
            Double total = 0.0;
            
            System.out.println(String.format("User: %.1f%%", (100d * user / totalCpu)));
            
            for (double avg : load) {
                somaProc ++;
                total += avg * 100;
//                System.out.println(String.format(" %.1f%%", avg * 100));
            }
            float usoCPU = (float)(total/somaProc);
            dadosCPU = usoCPU;
        } catch (Exception e) {
            System.out.println("erro: " + e);;
        }
    }
    
    public float consomeCpu(){
        getUso();
        return dadosCPU;
    }
    

//    public Double cpuPercent(){
//
//    }
    public static void main(String[] args) {
        Cpu cpu = new Cpu();
//        System.out.println(cpu.printProcessor());
//        System.out.println(cpu.getClock());
//        System.out.println(String.format("%.2fºC", cpu.getTemperature()));
        System.out.println(cpu.consomeCpu());
    }
}
