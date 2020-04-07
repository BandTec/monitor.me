
package com.monitorme.hardware;

public class Monitoracao {
    
    private Double utilizacaoCpu;
    private Double velocCpu;
    private Double processoCpu;
    private Double dispoMemor;
    private Double usoMemor;
    private Double cacheMemor;
    private Double atvDisco;
    private Double velocDisco;
    private Double respoDisco;
    
     public Monitoracao () {
        System.out.println("");
    }
        
     private void getCpu() {
         this.processoCpu = 0.0;
         this.utilizacaoCpu= 0.0;
         this.velocCpu = 0.0;
    }
     private void getMemoria() {
         this.dispoMemor = 0.0;
         this.usoMemor = 0.0;
         this.cacheMemor = 0.0;
    }
    private void getDisco() {
         this.velocDisco = 0.0;
         this.atvDisco = 0.0;
         this.respoDisco = 0.0;
    }
}
