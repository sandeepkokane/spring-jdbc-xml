package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.ProductDao;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Spring JDBC Project -> CRUD Operations" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ProductDao productDao = context.getBean("productDao",ProductDao.class);
        
    }
}
