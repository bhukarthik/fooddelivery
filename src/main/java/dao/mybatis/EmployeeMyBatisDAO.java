package dao.mybatis;

import bin.Employees;
import dao.EmployeesMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.MyBatisUtil;
import static util.MyBatisUtil.sesFact;

public class EmployeeMyBatisDAO implements EmployeesMapper{
    private static final Logger LOGGER = (Logger) LogManager.getLogger(EmployeeMyBatisDAO.class);
    @Override
    public void addEmployees(Employees employees) {
        MyBatisUtil myBatisUtil = new MyBatisUtil();
        myBatisUtil.myBatisConnection();
        SqlSession sqlSession = sesFact.openSession();
        try{
            EmployeesMapper userMapper = sqlSession.getMapper(EmployeesMapper.class);
            userMapper.addEmployees(employees);
            sqlSession.commit();
            LOGGER.info("Employee Record Created");
        }finally{
            sqlSession.close();
        }
    }
    @Override
    public Employees getEmployeesById(int empId) {
        MyBatisUtil myBatisUtil = new MyBatisUtil();
        myBatisUtil.myBatisConnection();
        SqlSession sqlSession = sesFact.openSession();
        try{
            EmployeesMapper userMapper = sqlSession.getMapper(EmployeesMapper.class);
            Employees employees= userMapper.getEmployeesById(empId);
            LOGGER.info("Employee Id "+employees.getEmpId());
            LOGGER.info("Employee First Name "+employees.getFirstName());
            LOGGER.info("Employee Last Name "+employees.getFirstName());
            LOGGER.info("Employee Phone Number "+employees.getPhoneNumber());
            LOGGER.info("Transportation Mode "+employees.getTransportationmodesvehicleid());
            return employees;
        }finally{
            sqlSession.close();
        }
    }

    public int getNumberOfEmployees() {
        int numberOfEmployees = 0;
        MyBatisUtil myBatisUtil = new MyBatisUtil();
        myBatisUtil.myBatisConnection();
        try (SqlSession session = sesFact.openSession()) {
            numberOfEmployees = session.selectOne("getNumberOfEmployees");
            LOGGER.info("Total Count " + numberOfEmployees);
        }
        return numberOfEmployees;
    }
}
