package com.monitorme.banco;
import org.apache.commons.dbcp2.BasicDataSource;

public class DadosConexao {
     private BasicDataSource dataSource;

    public DadosConexao(){
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        dataSource.setUrl("jdbc:sqlserver://srvseventeam.database.windows.net:1433;database=bdseventeam;user=userseventeam@srvseventeam;password=#Gfgrupo7b;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        
        dataSource.setUsername("usercowwellfare");
        dataSource.setPassword("#Gfgrupo10b");
        
    }
    
    public BasicDataSource getDataSource(){
        return dataSource;
    }
     
       
}   