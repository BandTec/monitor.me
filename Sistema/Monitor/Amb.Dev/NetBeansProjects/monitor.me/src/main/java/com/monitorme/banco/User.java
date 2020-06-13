package com.monitorme.banco;

import com.monitorme.tela.TelaLogin;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.JdbcTemplate;

public class User {

    public static Integer UsuarioLogado = null;

    public static Integer getUsuarioLogado() {
        return UsuarioLogado;
    }

    public User(String email, String senha) {
        try {
               
            TelaLogin login = new TelaLogin();
            ConexaoBanco dadosConexao = new ConexaoBanco();
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());
            List lista = jdbcTemplate.queryForList("select Email,Senha from tblUsers"
                    + " where Email='" + email + "'and Senha='" + senha + "'or Email='" + email + "'and Senha='" + senha + "'");
            List ID = jdbcTemplate.queryForList("select IdUsers from tblUsers"
            + " where Email='" + email + "'and Senha='" + senha + "'or Email='" + email + "'and Senha='" + senha + "'");
            if (lista.isEmpty() == false) {
                String split = lista.toString();
                String[] split2 = split.split("=", 5);
                String[] comp = split2[4].split("}");
                System.out.println(comp[0]);
                UsuarioLogado = Integer.valueOf(comp[0]);
               
            } else {
              
                JOptionPane.showMessageDialog(null, "Usuário ou Senha inválidos!", "Login inválido", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
    }
   
            
}
