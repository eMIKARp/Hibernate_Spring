package pl.myhibernateapp.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JpaConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean createEMF(JpaVendorAdapter adapter, DataSource ds) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPersistenceUnitName("myLibrary");
		emf.setDataSource(ds);
		emf.setJpaVendorAdapter(adapter);
		emf.setPackagesToScan("pl.myhibernateapp.model");
		return emf;
	}
	
	@Bean
	public JpaVendorAdapter createVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        return adapter;
	}
	
	@Bean
	public DataSource createDS() {
		BasicDataSource ds = new BasicDataSource();
       	ds.setUrl("jdbc:mysql://localhost:3306/library");
        ds.setUsername("root");
        ds.setPassword("Polska01");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setInitialSize(5);
		return ds;
	}
	
	
}
