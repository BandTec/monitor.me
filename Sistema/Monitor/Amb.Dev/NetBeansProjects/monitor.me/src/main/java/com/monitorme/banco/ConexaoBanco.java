
package com.monitorme.banco;
import org.apache.commons.dbcp2.BasicDataSource;


public class ConexaoBanco {
     private BasicDataSource dataSource;

    public ConexaoBanco() {
        this.dataSource = new BasicDataSource();
        
        dataSource​.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        dataSource​.setUrl("jdbc:sqlserver://srvcowwellfare.database.windows.net:1433;database=bdcowwellfare;user=usercowwellfare;password=#Gfgrupo10b;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");  
        
        dataSource​.setUsername("usercowwellfare");
        
        dataSource​.setPassword("#Gfgrupo10b");
    
    
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }
    
    
     
    
}
