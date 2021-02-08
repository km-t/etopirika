<<<<<<< HEAD
package sample.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DataSourceConfig {
    
    @Bean
    public DataSource dataSource(){
        return
            new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("script/table.sql")
            .addScript("script/data.sql")
            .build();
    }   
    

}
=======
package sample.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DataSourceConfig {
    
    @Bean
    public DataSource dataSource(){
        return
            new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("script/table.sql")
            .addScript("script/data.sql")
            .build();
    }   
    

}
>>>>>>> fd9e0ee495a0a2213a540a8a7d39a78abd4c0920
