package dao.mybatis;

import bin.Employees;
import dao.EmployeesMapper;
import dao.impl.EmployeesDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import static util.MyBatisUtil.sesFact;

public class EmployeeDAO implements EmployeesMapper{
    private static final Logger LOGGER = (Logger) LogManager.getLogger(EmployeeDAO.class);
    @Override
    public void addEmployees(Employees employees) {
        MyBatisUtil myBatisUtil = new MyBatisUtil();
        myBatisUtil.myBatisConnection();
        SqlSession sqlSession = sesFact.openSession();
        try{
            EmployeesMapper userMapper = sqlSession.getMapper(EmployeesMapper.class);
            userMapper.addEmployees(employees);
            sqlSession.commit();
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
            return userMapper.getEmployeesById(empId);
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
