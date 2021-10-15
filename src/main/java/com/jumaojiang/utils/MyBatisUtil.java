package com.jumaojiang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * MyBatis
 *
 * @author wuhanwei
 * @version 1.0
 * @date 2021/10/11
 */
public class MyBatisUtil {

    private static final String resourceName = "MyBatis.xml";
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> threadLocal;

    static{
        threadLocal = new ThreadLocal<>();
        Reader resource = null;
        try {
            resource = Resources.getResourceAsReader(resourceName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(resource);
    }

    /**
     *  获取sqlSession
     * @return
     */
    public static SqlSession openSession() {
        if( threadLocal.get() == null ){
            SqlSession sqlSession = factory.openSession();
            threadLocal.set(sqlSession);
            return sqlSession;
        }
        return threadLocal.get();
    }


    /**
     * 关闭连接
     */
    public static void close(){
        threadLocal.get().close();
        threadLocal.remove();
    }
}
