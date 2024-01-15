package util;

import dao.EmployeesMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.InputStream;
import java.util.Properties;

public class MyBatisUtil {

    public static SqlSessionFactory sesFact = null;
    private static SqlSessionFactory factory = null;

    public static SqlSessionFactory getSqlSessionFactory() {
            return factory;
    }

    public void myBatisConnection() {
        String resource = "src/main/resources/mybatis-config.xml";
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resource);
            Properties prop = new Properties();
            prop.setProperty("driver", "com.mysql.cj.jdbc.Driver");
            prop.setProperty("url", "jdbc:mysql://localhost:3306/fooddelivery");
            prop.setProperty("user", "root");
            prop.setProperty("password", "JAutomation@123");
            PooledDataSource ds = new PooledDataSource();
            ds.setDriver(prop.getProperty("driver"));
            ds.setUrl(prop.getProperty("url"));
            ds.setUsername(prop.getProperty("user"));
            ds.setPassword(prop.getProperty("password"));
            TransactionFactory trFact = new JdbcTransactionFactory();
            Environment environment = new Environment("development", trFact, ds);
            Configuration config = new Configuration(environment);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(config);
            config.addMapper(EmployeesMapper.class);
            sesFact = new SqlSessionFactoryBuilder().build(config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
