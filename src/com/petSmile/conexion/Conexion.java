package com.petSmile.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;



public class Conexion {
	
private static BasicDataSource dataSource=null;
	
	private static DataSource getDataSource() {
		if (dataSource==null) {
			dataSource= new BasicDataSource();
			dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
			//dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); MYsql
			dataSource.setUsername("usuario");
			dataSource.setPassword("password");
			dataSource.setUrl("jdbc:mariadb://localhost:3306/clinica?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
			//dataSource.setUrl("jdbc:mysql://localhost:3306/clinica"); Mysql
			dataSource.setInitialSize(20);
			dataSource.setMaxIdle(15);
			dataSource.setMaxTotal(20);
			dataSource.setMaxWaitMillis(5000);
		}
		return dataSource;
	}
	
	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}


}
