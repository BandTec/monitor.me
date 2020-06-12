package com.monitorme.banco;

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

            ConexaoBanco dadosConexao = new ConexaoBanco();
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());
            List lista = jdbcTemplate.queryForList("select login,email,senha,fkComputador from usuario"
                    + " where login='" + email + "'and senha='" + senha + "'or email='" + email + "'and senha='" + senha + "'");
            
            if (lista.isEmpty() == false) {
                String split = lista.toString();
                String[] split2 = split.split("=", 5);
                String[] comp = split2[4].split("}");
                System.out.println(comp[0]);
                UsuarioLogado = Integer.valueOf(comp[0]);
                //Gui, coloca no Log a info abaixo
//                logger.info("Logado com sucesso");
            } else {
                //Gui, coloca no Log a info abaixo
//                logger.info("Usuário não encontrado");
                JOptionPane.showMessageDialog(null, "Usuário ou Senha inválidos!", "Login inválido", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }
}
