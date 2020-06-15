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
            List lista = jdbcTemplate.queryForList("select Email,Senha from tbl_Users"
                    + " where Email='" + email + "'and Senha='" + senha + "'or Email='" + email + "'and Senha='" + senha + "'");
            List ID = jdbcTemplate.queryForList("select IdUsers, Nome from tbl_Users"
            + " where Email='" + email + "'and Senha='" + senha + "'or Email='" + email + "'and Senha='" + senha + "'");
            if (lista.isEmpty() == false) {
              
                UsuarioLogado = 0;
                System.out.println(ID);
            } else {
              
                JOptionPane.showMessageDialog(null, "Usuário ou Senha inválidos!", "Login inválido", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
    }
   
            
}
