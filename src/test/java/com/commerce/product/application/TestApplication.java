package com.commerce.product.application;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Created by jcordones13 on 3/4/17.
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.commerce.product")
@PropertySource("classpath:testProperty.yml")
public class TestApplication extends SpringBootServletInitializer {

    public static void main(String[] args){
        new TestApplication()
        .configure(new SpringApplicationBuilder(TestApplication.class))
        .run(args);
    }

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

  /*@Bean
  public DataSource dataSource() {
    PooledDataSource dataSource = new PooledDataSource("", dataSource.getUrl(), dbUser, dbPass);
    dataSource.setPoolMaximumActiveConnections(maxActiveConnections);
    dataSource.setPoolMaximumIdleConnections(maxIdleConnections);
    dataSource.setPoolMaximumCheckoutTime(maxCheckoutTime);
    dataSource.setPoolTimeToWait(timeToWait);
    dataSource.setPoolPingQuery(pingQuery);
    dataSource.setPoolPingEnabled(pingEnabled);
    dataSource.setPoolPingConnectionsNotUsedFor(connectionsNotUserdFor);
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

    if (usePageHelper) {
      Properties prop = new Properties();
      prop.setProperty("dialect", dialect);
      prop.setProperty("offsetAsPageNum", offsetAsPageNum);
      prop.setProperty("rowBoundsWithCount", rowBoundsWithCount);
      prop.setProperty("pageSizeZero", pageSizeZero);
      prop.setProperty("reasonable", reasonable);

      PageHelper pagePlugin = new PageHelper();
      pagePlugin.setProperties(prop);

      Interceptor[] plugins = {pagePlugin};
      sfb.setPlugins(plugins);
    }

    SqlSessionFactory factory = sfb.getObject();
    factory.getConfiguration().setMapUnderscoreToCamelCase(true);
    return factory;
  }*/

    /*@Bean
    @ConfigurationProperties(prefix="datasource.db-product")
    public DataSource productDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate productJdbcTemplate(){
        return new JdbcTemplate(productDataSource());
    }

    @Beans
    public ProductRepository jdbcPersonRepository() {
        ProductRepository personRepo = new JdbcProductRepository();
        personRepo.setJdbcTemplate(productJdbcTemplate());
        return personRepo;
    }*/
}
