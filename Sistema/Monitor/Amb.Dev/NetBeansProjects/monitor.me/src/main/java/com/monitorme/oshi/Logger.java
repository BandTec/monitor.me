/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monitorme.oshi;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Pichau
 */
public class Logger {
   
    private String caminho;
    private String[] tipos = {"info", "error"};
    private Date date;
    private final DateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
    private final DateFormat horaFormatada = new SimpleDateFormat("HH:mm:ss");

    public Logger() {
        String os = System.getProperty("os.name").toLowerCase();

        this.caminho = os.contains("win") ? "C:/Logfy/" : "/var/log/";
    }

    public void criarDiretorio() {
        try {
            if (!Files.exists(Paths.get(caminho))) {
                Files.createDirectory(Paths.get(caminho));
            }
        } catch (Exception e) {
            System.out.println("Erro apresentado ao criar diretório.");
        }
    }

    public void criaLog() {
        try {
            for (String extensao : tipos) {
                extensao += ".txt";
                if (!Files.exists(Paths.get(caminho + extensao))) {
                    Files.createFile(Paths.get(caminho + extensao));
                    Files.write(Paths.get(caminho + extensao),
                            ("data;hora;local;info\n").getBytes(),
                            StandardOpenOption.APPEND);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao criar arquivos.");
        }
    }

    public void editarLog(String local, String tipoDeLog, String informacao) {
        try {
            date = new Date();
            String data = dataFormatada.format(date);
            String hora = horaFormatada.format(date);

            tipoDeLog += ".txt";
            String infoLog = String.format("%s;%s;%s;%s\n", data, hora, local, informacao);

            Files.write(Paths.get(caminho + tipoDeLog),
                    (infoLog).getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            System.out.println("Erro ao escrever log.");
        }
    }

    
}
