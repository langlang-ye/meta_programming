package com.ykl.dao;

import com.langlang.io.Resources;
import com.langlang.sqlSession.SqlSession;
import com.langlang.sqlSession.SqlSessionFactoryBuilder;
import com.ykl.pojo.Person;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.util.List;

/**
 * @author langlang.ye
 * @date 2021/5/16
 */
public class PersonDaoImpl implements PersonDao {

    private SqlSession getSqlSession() throws DocumentException, PropertyVetoException, ClassNotFoundException {
        var resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        var sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        return sqlSessionFactory.openSession();
    }

    @Override
    public List<Person> findAll() throws Exception {
        var sqlSession = getSqlSession();
        List<Person> users = sqlSession.selectList("com.ykl.dao.PersonDao.findAll");
        return users;
    }

    @Override
    public Person findByCondition(Person person) throws Exception {
        var sqlSession = getSqlSession();
        Person p = sqlSession.selectOne("com.ykl.dao.PersonDao.findByCondition", person);
        return p;
    }

    @Override
    public void savePerson(Person user) throws Exception {
        var sqlSession = getSqlSession();
        sqlSession.update("com.ykl.dao.PersonDao.savePerson", user);
        //    sqlSession.commit();
    }

    @Override
    public void updatePerson(Person user) throws Exception {
        var sqlSession = getSqlSession();
        sqlSession.update("com.ykl.dao.PersonDao.updatePerson", user);
    }

    @Override
    public void deletePerson(Person person) throws Exception {
        var sqlSession = getSqlSession();
        sqlSession.update("com.ykl.dao.PersonDao.deletePerson", person);
    }

    @Override
    public Person selectPersonById(int id) throws Exception {
        var sqlSession = getSqlSession();
        Person p = sqlSession.selectOne("com.ykl.dao.PersonDao.selectPersonById", id);
        return p;
    }
}
