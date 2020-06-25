package com.monitorme.banco;

import com.monitorme.tela.TelaLogin;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;

public class User {

    private int idTelegram;
    private Object x;
    public static Integer UsuarioLogado = null;

    public static Integer getUsuarioLogado() {
        return UsuarioLogado;
    }

    public User(String email, String senha) {

        try {
            TelaLogin login = new TelaLogin();
            ConexaoBanco dadosConexao = new ConexaoBanco();
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());
            List lista = jdbcTemplate.queryForList("select Email,Senha from tbl_Users"
                    + " where Email='" + email + "'and Senha='" + senha + "'or Email='" + email + "'and Senha='" + senha + "'");
            List ID = jdbcTemplate.queryForList("select idTelegram from tbl_Users"
                    + " where Email='" + email + "'and Senha='" + senha + "'or Email='" + email + "'and Senha='" + senha + "'");
            if (lista.isEmpty() == false) {
                JSONObject result = new JSONObject();
                
//                JSONArray jarr = new JSONArray(ID);

                UsuarioLogado = 0;
                result.put("Telegram", ID.get(0));
                
                JSONObject xt = new JSONObject(result.toString());
                JSONObject id = xt.getJSONObject("Telegram");
                this.idTelegram = id.getInt("idTelegram");

                System.out.println("seu Telegram é: " + getIdTelegram());
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou Senha inválidos!", "Login inválido", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }
    public int getIdTelegram() {
        return idTelegram;
    }

    public void setIdTelegram(int idTelegram) {
        this.idTelegram = idTelegram;
    }

    
}
