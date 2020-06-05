package com.monitorme.telegram;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

public class TelegramBot {

    private final String endpoint = "https://api.telegram.org/";
    private final String token;

    public TelegramBot(String token) {
        this.token = token;

    }

    public HttpResponse sendMessage(Integer chatId, String text) throws UnirestException {
        return Unirest.post(endpoint + "bot" + token + "/sendMessage")
                .field("chat_id", chatId)
                .field("text", text)
                .asJson();
    }

    public HttpResponse getUpdates(Integer offset) throws UnirestException {
        return Unirest.post(endpoint + "bot" + token + "/getUpdates")
                .field("offset", offset)
                .asJson();
    }
  
    
    
  //   public void run() throws UnirestException {
  //     int last_update_id = 0; 
  //     HttpResponse response;}
    
    
}
