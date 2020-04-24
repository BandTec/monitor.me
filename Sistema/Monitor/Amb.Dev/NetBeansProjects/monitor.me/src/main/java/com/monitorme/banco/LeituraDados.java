
package com.monitorme.banco;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;


public class LeituraDados {
    public static void main(String[] args) {
        
        ConexaoBanco con = new ConexaoBanco();
        JdbcTemplate template = new  JdbcTemplate(con.getDataSource());
     
        
        
        List usuario = template.queryForList("select * from usuario");
        System.out.println(usuario);
        
       //List teste = template.queryForList("select * from dados_arduino");
        //System.out.println(teste);
    }
    
    
}
