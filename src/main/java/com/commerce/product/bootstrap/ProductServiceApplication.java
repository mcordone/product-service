package com.commerce.product.bootstrap;

import com.commerce.product.service.ProductService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by jcordones13 on 3/4/17.
 */

@SpringBootApplication
//@ComponentScan
public class ProductServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args){
        new ProductServiceApplication()
        .configure(new SpringApplicationBuilder(ProductService.class))
        .run(args);
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
