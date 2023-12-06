import com.cskaoyan.demo11.bean.Account;
import com.cskaoyan.demo11.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Projectname: mybatis-homework11
 * @Filename:
 * @Author: an
 * @Data:2023/12/6 17:46
 * @Description: TODO
 */
public class AccountTest {

        @Test
        public  void Yest() throws IOException {
                String resource="config.xml";
                // 1.读取配置文件
                InputStream inputStream = Resources.getResourceAsStream(resource);
                // 2.创建一个SqlSessionFactory
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                // 3.通过SqlSessionFactory获得一个SqlSession
                SqlSession sqlSession = sqlSessionFactory.openSession();
                AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
                List<Account> accounts = mapper.queryAccountByNameAndAddress("山文", "楚水");
                System.out.println(accounts);
        }
        @Test
        public  void Test() throws IOException {
                String resource="config.xml";
                // 1.读取配置文件
                InputStream inputStream = Resources.getResourceAsStream(resource);
                // 2.创建一个SqlSessionFactory
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                // 3.通过SqlSessionFactory获得一个SqlSession
                SqlSession sqlSession = sqlSessionFactory.openSession();
                AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
                Account account=new Account();
                account.setName("无涯");
                account.setEmail("1245324@qq.com");
                List<Account> accounts = mapper.queryAccountByCondition(account);
                System.out.println(accounts);
        }
        @Test
        public  void Test1() throws IOException {
                String resource="config.xml";
                // 1.读取配置文件
                InputStream inputStream = Resources.getResourceAsStream(resource);
                // 2.创建一个SqlSessionFactory
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                // 3.通过SqlSessionFactory获得一个SqlSession
                SqlSession sqlSession = sqlSessionFactory.openSession();
                AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
                Account account=new Account();
                account.setId(4);
              account.setName("安源");
                account.setPhone("123343267");
                List<Account> accounts = mapper.queryAccountByCondition1(account);
                System.out.println(accounts);
        }

        @Test
        public  void Test2() throws IOException {
                String resource="config.xml";
                // 1.读取配置文件
                InputStream inputStream = Resources.getResourceAsStream(resource);
                // 2.创建一个SqlSessionFactory
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                // 3.通过SqlSessionFactory获得一个SqlSession
                SqlSession sqlSession = sqlSessionFactory.openSession();
                AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
//                Account account=new Account();
//                account.setAge(20);
                List<Account> accounts = mapper.queryAccountByCondition2(20);
                System.out.println(accounts);
        }

}

