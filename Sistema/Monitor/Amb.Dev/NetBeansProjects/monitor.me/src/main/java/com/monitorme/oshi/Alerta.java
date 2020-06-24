package com.monitorme.oshi;

import com.monitorme.telegram.MonitorMe;
import org.telegram.telegrambots.meta.TelegramBotsApi;

public class Alerta {

    private String categoriaAlerta, statusAlerta, msgAlerta;

    TelegramBotsApi telegram = new TelegramBotsApi();  //objeto telegram
    MonitorMe mensagem = new MonitorMe();

    //Metodos
    public void enviarAlerta(String categoriaAlerta, String statusAlerta, String msgAlerta) {
        if (categoriaAlerta == "gpu") {
            mensagem.enviarMensagem(Long.valueOf(1156684369), (statusAlerta+": "+ msgAlerta));
        }else if(categoriaAlerta == "memoria"){
            mensagem.enviarMensagem(Long.valueOf(1156684369), (statusAlerta+": "+ msgAlerta));
        }else if(categoriaAlerta == "cpu"){
            mensagem.enviarMensagem(Long.valueOf(1156684369), (statusAlerta+": "+ msgAlerta));
        }
    }

    @Override
    public String toString() {
        return "Alerta{" + "categoriaAlerta=" + categoriaAlerta + ", statusAlerta=" + statusAlerta + ", msgAlerta=" + msgAlerta + '}';
    }
}
