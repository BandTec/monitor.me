
package com.monitorme.hardware;


public class Monitoracao {
        
    // Atributos
    private Double utilizacaoCpu,
            velocCpu,
            processoCpu,
            dispoMemor,
            usoMemor,
            cacheMemor,
            atvDisco,
            velocDisco,
            respoDisco,
            gpu;
    
    //Construtor
    public Monitoracao(){
        
    }
    public Monitoracao(Double utilizacaoCpu,
           Double velocCpu,
           Double processoCpu,
           Double dispoMemor,
           Double usoMemor,
           Double cacheMemor,
           Double atvDisco,
           Double velocDisco,
           Double respoDisco,
           Double gpu) {
        this.utilizacaoCpu = utilizacaoCpu;
        this.velocCpu = velocCpu;
        this.processoCpu = processoCpu;
        this.dispoMemor = dispoMemor;
        this.usoMemor = usoMemor;
        this.cacheMemor = cacheMemor;
        this.atvDisco = atvDisco;
        this.velocDisco = velocDisco;
        this.respoDisco = respoDisco;
        this.gpu = gpu;
    }
    
    //Métodos
//    public Monitoracao () {
//        System.out.println("");
//    }
        
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
    
    // Getter & Setters //
    public Double getUtilizacaoCpu() {
        return utilizacaoCpu;
    }

    public void setUtilizacaoCpu(Double utilizacaoCpu) {
        this.utilizacaoCpu = utilizacaoCpu;
    }

    public Double getVelocCpu() {
        return velocCpu;
    }

    public void setVelocCpu(Double velocCpu) {
        this.velocCpu = velocCpu;
    }

    public Double getProcessoCpu() {
        return processoCpu;
    }

    public void setProcessoCpu(Double processoCpu) {
        this.processoCpu = processoCpu;
    }

    public Double getDispoMemor() {
        return dispoMemor;
    }

    public void setDispoMemor(Double dispoMemor) {
        this.dispoMemor = dispoMemor;
    }

    public Double getUsoMemor() {
        return usoMemor;
    }

    public void setUsoMemor(Double usoMemor) {
        this.usoMemor = usoMemor;
    }

    public Double getCacheMemor() {
        return cacheMemor;
    }

    public void setCacheMemor(Double cacheMemor) {
        this.cacheMemor = cacheMemor;
    }

    public Double getAtvDisco() {
        return atvDisco;
    }

    public void setAtvDisco(Double atvDisco) {
        this.atvDisco = atvDisco;
    }

    public Double getVelocDisco() {
        return velocDisco;
    }

    public void setVelocDisco(Double velocDisco) {
        this.velocDisco = velocDisco;
    }

    public Double getRespoDisco() {
        return respoDisco;
    }

    public void setRespoDisco(Double respoDisco) {
        this.respoDisco = respoDisco;
    }

    public Double getGpu() {
        return gpu;
    }

    public void setGpu(Double gpu) {
        this.gpu = gpu;
    }
    
}
