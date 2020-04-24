/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorme.monitorMain;

import java.util.Random;

public class GeraAleatorio {
    
    private Integer cpu, processo, memoria, disco;
    private Double ghz, memoDisp, cache, tempDis, velocDisc;
    
    public void aleatorioCpu() {
        Random aleatorio = new Random();
        cpu = aleatorio.nextInt(101);
        Random aleatorio2 = new Random();
        processo = aleatorio2.nextInt(301);

        ghz = (3.2 * cpu) / 100;
    }
    
    public void aleatorioMemoria() {
        
        Random aleatorioM = new Random();
        memoria = aleatorioM.nextInt(200);
        Random aleaCache = new Random();
        memoDisp = (200.0 / memoria);
        cache = aleaCache.nextDouble();
        
    }
    
    public void aleatorioDisco() {
        
        Random aleatorioDisc = new Random();
        disco = aleatorioDisc.nextInt(201);
        Random aleatorioTemp = new Random();
        tempDis = (200.0 / disco);
        velocDisc = aleatorioTemp.nextDouble();
        
    }
    
    public int getCpu() {
        return cpu;
    }
    
    public int getProcesso() {
        return processo;
    }
    
    public int getMemoria() {
        return memoria;
    }
    
    public int getDisco() {
        return disco;
    }
    
    public Double getGhz() {
       return ghz; 
    }
    
    public Double getMemoDisp() {
        return memoDisp;
    }
    
    public Double getCache() {
        return cache;
    }
    
    public Double getTempDis() {
        return tempDis;
    }
    
    public Double getVelocDisc() {
        return velocDisc;
    }  
        
}
