package config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Created by jcordones13 on 5/24/17.
 */
@TestConfiguration(value = "TestConfig.class")
@PropertySource("classpath:testAppProperty.yml")
@MapperScan("com.commerce.product.mapper")
public class TestConfig {

  @Autowired
  private Environment env;

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean
  public DataSource dataSource(){
    DataSource dataSource = new DataSource();
    dataSource.setUrl(env.getProperty("url"));
    dataSource.setUsername(env.getProperty("username"));
    dataSource.setPassword(env.getProperty("password"));
    dataSource.setDriverClassName(env.getProperty("driver-class-name"));
    return dataSource;
  }

  @Bean
  public DataSourceTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
          throws Exception {
    SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
    sfb.setDataSource(dataSource);


    SqlSessionFactory factory = sfb.getObject();
    factory.getConfiguration().setMapUnderscoreToCamelCase(true);
    return factory;
  }
}
