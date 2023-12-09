## Mybatis简单使用

#### 目录

* Mybatis整体框架

* 快速入门（quick start）

* 动态代理Mapper实现类

* mybatis-config.xml详解

* 动态sql

* 缓存

* 高级查询

* SpringBoot集成Mybatis

* Mybatis Generator的使用

* Mybatis整合分页插件 pageHelper

* 从配置文件到简单执行mybatis功能---再到运用其完整语法。查询，慢加载，缓存。

  



* 选择mybatis的原因

  mybatis是个持久化框架，支持普通SQL查询，存储及高级映射，mybatis是直接基于JDBC做了简单的映射包装，所有从性能角度来看，JDBC>Mybatis>Hibernate

  解决JDBC硬编码

## 1.mybatis 整体框架

![img](https://img2018.cnblogs.com/blog/1456626/201903/1456626-20190327200843495-1926482501.png)

![img](https://img2018.cnblogs.com/blog/1456626/201903/1456626-20190327200855552-2120429717.png)

## 2.快速入门（quick start）







![image-20231207092601771](/Users/honghaomingdemac/Library/Application Support/typora-user-images/image-20231207092601771.png)

####  2.1 引入依赖（pom.xml）

test/mybatis/sql/lombok。   properties-

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>mybatis-homework11</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.1</version>
            <scope>compile</scope>
        </dependency>
    <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.14</version>
        </dependency> 
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.33</version>
        </dependency>
 <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.30</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

</project>
```

![image-20231207092148182](/Users/honghaomingdemac/Library/Application Support/typora-user-images/image-20231207092148182.png)

![image-20231207092231091](/Users/honghaomingdemac/Library/Application Support/typora-user-images/image-20231207092231091.png)

![image-20231207092254471](/Users/honghaomingdemac/Library/Application Support/typora-user-images/image-20231207092254471.png)

![image-20231207092315159](/Users/honghaomingdemac/Library/Application Support/typora-user-images/image-20231207092315159.png)

![image-20231207092326327](/Users/honghaomingdemac/Library/Application Support/typora-user-images/image-20231207092326327.png)

![image-20231207092430267](/Users/honghaomingdemac/Library/Application Support/typora-user-images/image-20231207092430267.png)

#### 2.2全局配置文件（mybatis-config.xml）

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>

    <!-- 环境的配置，其实就是去配置数据库连接-->
  <!-- 环境，可以配置多个，default：指定采用哪个环境 -->
    <environments default="development">
      <!-- id：唯一标识 -->
        <environment id="development">
          <!-- 事务管理器，JDBC类型的事务管理器 -->
            <transactionManager type="JDBC"/>
          <!-- 数据源，池类型的数据源 -->
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url"                   value="jdbc:mysql://mysql.aixudebug.top:3306/cs_wangdao_os?useSSL=false&amp;characterEncoding=utf8"/>
                <property name="username" value="hhm"/>
                <property name="password" value="hhm12345"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <package name="com.cskaoyan.demo11.mapper"/>
    </mappers>

</configuration>
```

#### 2.3配置Map.xml(AccountMapper.xml)

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.cskaoyan.demo11.mapper.AccountMapper">

    <select id="queryAccountByNameAndAddress" resultType="com.cskaoyan.demo11.bean.Account">
    select * from account
        <where>
        <if test="name!=null">
            and name=#{name}
        </if>
            <if test="address!=null">
         and address=#{address}
            </if>
        </where>
    </select>

    <select id="queryAccountByCondition" resultType="com.cskaoyan.demo11.bean.Account">
        select * from account
        <where>
            <choose>
            <when test="account.name!=null">
               name=#{account.name}
            </when>
                <when test="account.address!=null">
                    address=#{account.address}
                </when>
            </choose>
            <if test="account.email!=null">
               and email=#{account.email}
            </if>
        </where>
    </select>

    <select id="queryAccountByCondition1" resultType="com.cskaoyan.demo11.bean.Account">
        select * from account
        <where>
            <choose>
                <when test="account.id!=0">
                    id=#{account.id}
                </when>
                <when test="account.name!=null">
                    name=#{account.name}
                </when>
                <otherwise >
                    phone=#{account.phone}
                </otherwise>
            </choose>
        </where>
    </select>

    <select id="queryAccountByCondition2" resultType="com.cskaoyan.demo11.bean.Account">
        select * from account
        <where>
            <choose>
                <when test="age gte 0  and age lt 18">
                        age=18
                </when>
                <otherwise>
                    age>18
                </otherwise>>
            </choose>>
        </where>>
    </select>
</mapper>
```

#### 2.4配置Mapper.java

```java
package com.cskaoyan.demo11.mapper;
import com.cskaoyan.demo11.bean.Account;
import org.apache.ibatis.annotations.Param;
import java.util.List;

//有一个账户表：里面有 id name address email phone age
//        1.练习，根据name或者address来查询。如果name传了则拼接。 如果address传了则拼接。
//        且两者是and的关系

public interface AccountMapper {
//1.练习，根据name或者address来查询。如果name传了则拼接。 如果address传了则拼接。
    List<Account> queryAccountByNameAndAddress(@Param("name") String name, @Param("address") String address);

    // 如果传了 名字就根据名字查； 如果传了address，就拼接address；如果传了email就根据email查
    List<Account> queryAccountByCondition(@Param("account") Account account);

    // 如果传了id，就根据id查； 否则，如果名字不为空，根据name来查；  否则，根据手机号查
    List<Account> queryAccountByCondition1(@Param("account") Account account);

    // 如果年龄输入小于0.则不拼接；如果在18岁以下，就拼接 age=18; 否则，就拼接年龄>18
    List<Account> queryAccountByCondition2(Integer age);

}

```

#### 2.5配置MybatisUtil.java

```java
public class MybatisUtil {
    /*
在 MyBatis 中，SqlSessionFactory 是一个关键的接口，负责创建和管理 SqlSession 对象。
SqlSessionFactory 实例的创建是相对耗费资源的操作，因为它会加载配置信息、映射文件等，
并构建数据库连接池等资源。为了避免在每次执行数据库操作时都创建一个新的 SqlSessionFactory 实例，
常常会将其设计为一个单例模式，即只创建一个全局唯一的 SqlSessionFactory 实例。**/
    private static SqlSessionFactory sqlSessionFactory;

    static {
        // 1.创建SqlSessionFactory
        InputStream inputStream = null;
        try {
            // 加载 MyBatis 配置文件
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // SqlSessionFactory创建比较困难。 所以mybatis为我们提供了一个builder。
        // 专门用于建造 SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession getSqlSession() {
        return getSqlSession(false);
    }

    public static SqlSession getSqlSession(boolean autoCommit) {
        return sqlSessionFactory.openSession(autoCommit);
    }
}
```

这两个方法是用来获取 `SqlSession` 对象的辅助方法，通常用于执行数据库操作。

1. **`getSqlSession()` 方法：**
    - 返回一个默认的 `SqlSession` 对象。
    - 默认情况下，不启用自动提交事务。

2. **`getSqlSession(boolean autoCommit)` 方法：**
    - 接受一个 `boolean` 类型的参数 `autoCommit`，用于设置是否自动提交事务。
    - 如果 `autoCommit` 为 `true`，则创建的 `SqlSession` 将自动提交事务。
    - 如果 `autoCommit` 为 `false`，则需要手动调用 `commit()` 方法来提交事务。

这两个方法通常用于在进行数据库操作之前获取一个 `SqlSession` 对象。在 MyBatis 中，`SqlSession` 负责执行SQL语句、管理事务等数据库操作。当你需要执行一些数据库操作时，首先需要通过 `getSqlSession()` 或 `getSqlSession(true/false)` 获取一个 `SqlSession` 对象，然后在这个对象上执行相应的操作，最后记得关闭 `SqlSession`。

使用这种方式可以确保在执行数据库操作时能够得到正确配置的 `SqlSession`，而且可以方便地控制事务的提交行为。例如，如果你希望一系列的数据库操作是一个事务，可以在调用 `getSqlSession(false)` 获取一个非自动提交事务的 `SqlSession`，在操作完成后手动调用 `commit()` 提交事务。如果其中任何一个操作出现问题，你可以调用 `rollback()` 回滚整个事务。

MyBatis（之前叫做iBatis）是一个用于Java语言的持久层框架，它通过XML或注解配置来映射Java对象与数据库表之间的关系。在MyBatis中，动态代理是一个重要的特性，它用于自动生成实现了接口的代理类，从而简化了数据访问层的编写。

#### 2.6 test测试

可以通过使用 `@Before` 注解来减少重复代码，将初始化部分放到一个方法中，并在测试方法执行之前调用。这样，你只需要在测试方法中关注具体的测试逻辑，而初始化部分则由 `@Before` 注解的方法负责。以下是一个简化后的示例：

```java
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountMapperTest {

    private SqlSession sqlSession;
    private AccountMapper mapper;

    @Before
    public void setUp() throws IOException {
        String resource = "config.xml";
        // 1. 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 2. 创建一个 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 3. 通过 SqlSessionFactory 获得一个 SqlSession
        sqlSession = sqlSessionFactory.openSession();
        // 4. 通过 SqlSession 获得 Mapper 接口的实例
        mapper = sqlSession.getMapper(AccountMapper.class);
    }

    @Test
    public void testQueryAccountByNameAndAddress() {
        List<Account> accounts = mapper.queryAccountByNameAndAddress("山文", "楚水");
        System.out.println(accounts);
    }

    @Test
    public void testQueryAccountByCondition() {
        Account account = new Account();
        account.setName("无涯");
        account.setEmail("1245324@qq.com");
        List<Account> accounts = mapper.queryAccountByCondition(account);
        System.out.println(accounts);
    }
}
```

![image-20231209140627946](/Users/honghaomingdemac/Library/Application Support/typora-user-images/image-20231209140627946.png)



在上述示例中，`@Before` 注解标记的 `setUp` 方法会在每个测试方法执行之前被调用，确保了初始化步骤的共用。这样，你可以专注于每个测试方法的具体逻辑，而不必重复相同的初始化代码。

#### 动态代理

MyBatis的动态代理主要用于实现**Mapper接口的代理类**，这些接口中定义了数据库操作的方法。动态代理的原理是在运行时动态生成代理类，该代理类实现了目标接口并负责调用SQL语句执行数据库操作。

以下是MyBatis动态代理的一般流程：

1. **定义Mapper接口：** 在Java中定义一个接口，其中声明了数据库操作的方法，这些方法的名称和参数与实际的SQL语句相关。

    ```java
    public interface UserMapper {
        User getUserById(int userId);
        List<User> getAllUsers();
        void insertUser(User user);
        // 其他数据库操作方法
    }
    ```

2. **编写Mapper XML或使用注解：** 通过XML文件或注解方式配置SQL语句与接口方法的映射关系。

    ```xml
    <!-- UserMapper.xml -->
    <mapper namespace="com.example.UserMapper">
        <select id="getUserById" resultType="com.example.User">
            SELECT * FROM users WHERE id = #{userId}
        </select>
        <!-- 其他 SQL 映射 -->
    </mapper>
    ```

3. **MyBatis配置文件：** 配置MyBatis全局设置，包括数据源、事务管理等。

    ```xml
    <!-- mybatis-config.xml -->
    <configuration>
        <environments default="development">
            <environment id="development">
                <transactionManager type="JDBC"/>
                <dataSource type="POOLED">
                    <!-- 数据源配置 -->
                </dataSource>
            </environment>
        </environments>
        <mappers>
            <mapper resource="com/example/UserMapper.xml"/>
            <!-- 其他 Mapper 配置 -->
        </mappers>
    </configuration>
    ```

4. **获取SqlSession和Mapper：** 在代码中通过MyBatis的SqlSessionFactory获取SqlSession，然后通过SqlSession获取Mapper。

    ```java
    String resource = "path/to/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    ```

5. **动态代理的生成和执行：** 当调用Mapper接口的方法时，MyBatis会通过动态代理生成一个实现了该接口的代理类，并在代理类中执行相应的SQL语句。

    ```java
    User user = userMapper.getUserById(1);
    ```

在上述步骤中，动态代理的实现过程是由MyBatis框架完成的。MyBatis会根据Mapper接口的方法生成相应的SQL语句，并将其执行，最后将结果返回给调用方。

总体来说，MyBatis的动态代理是一种非常方便的方式，通过简单的接口定义和配置，就可以实现复杂的数据库操作。

## Mybatis的查询

MyBatis 的查询语法主要通过 XML 文件或者注解进行配置，这些配置文件包括 SQL 语句、参数映射、结果映射等。以下是 MyBatis 查询的主要语法：

### 1. 基本查询

#### 通过 XML 文件配置 SQL 语句：

```xml
<!-- 在 Mapper XML 文件中配置查询语句 -->
<select id="getUserById" resultType="User">
    SELECT * FROM users WHERE user_id = #{userId}
</select>
```

#### 通过注解配置：

```java
// 在 Mapper 接口中使用注解配置查询语句
@Select("SELECT * FROM users WHERE user_id = #{userId}")
User getUserById(@Param("userId") int userId);
```

### 2. 参数传递

#### 通过 XML 文件传递参数：

```xml
<!-- 在 Mapper XML 文件中配置带参数的查询语句 -->
<select id="getUserByUsername" resultType="User">
    SELECT * FROM users WHERE username = #{username}
</select>
```

#### 通过注解传递参数：

```java
// 在 Mapper 接口中使用注解传递参数
@Select("SELECT * FROM users WHERE username = #{username}")
User getUserByUsername(@Param("username") String username);
```

### 3. 动态 SQL

MyBatis 提供了动态 SQL 的支持，可以根据条件动态生成 SQL 语句。

#### XML 文件中的动态 SQL：

```xml
<!-- 在 Mapper XML 文件中配置动态 SQL -->
<select id="getUsersByCondition" resultType="User">
    SELECT * FROM users
    <where>
        <if test="username != null">
            AND username = #{username}
        </if>
        <if test="email != null">
            AND email = #{email}
        </if>
    </where>
</select>
```

#### 注解中的动态 SQL：

```java
// 在 Mapper 接口中使用注解配置动态 SQL
@Select({
    "<script>",
    "SELECT * FROM users",
    "<where>",
    "   <if test='username != null'> AND username = #{username} </if>",
    "   <if test='email != null'> AND email = #{email} </if>",
    "</where>",
    "</script>"
})
List<User> getUsersByCondition(@Param("username") String username, @Param("email") String email);
```

### 4. 结果映射

#### XML 文件中的结果映射：

```xml
<!-- 在 Mapper XML 文件中配置结果映射 -->
<resultMap id="userResultMap" type="User">
    <id property="userId" column="user_id"/>
    <result property="username" column="username"/>
    <result property="email" column="email"/>
</resultMap>
```

#### 注解中的结果映射：

```java
// 在 Mapper 接口中使用注解配置结果映射
@Results({
    @Result(property = "userId", column = "user_id", id = true),
    @Result(property = "username", column = "username"),
    @Result(property = "email", column = "email")
})
@Select("SELECT * FROM users WHERE user_id = #{userId}")
User getUserById(@Param("userId") int userId);
```

### 5. 分页查询

#### 基于 RowBounds 的分页：

```java
List<User> getUsersByPage(RowBounds rowBounds);
```

#### 基于参数传递的分页：

```xml
<select id="getUsersByPage" resultType="User">
    SELECT * FROM users
    LIMIT #{start}, #{pageSize}
</select>
```

### 注意事项：

- **#{} 和 ${} 的区别：**
    - `#{}` 是 MyBatis 的参数占位符，会进行预编译，防止 SQL 注入。
    - `${}` 是直接替换为参数的值，存在 SQL 注入的风险，不建议在动态 SQL 中使用。

- **动态 SQL 中的 `<script>` 标签：** 在动态 SQL 中，可以使用 `<script>` 标签包裹 SQL 语句，使得多条语句可以作为一个整体被解析。

~~~sql
在MyBatis中，`<script>`标签是用于包装动态SQL的标签，主要用于在XML中书写复杂的动态SQL语句。`<script>`标签允许在其中包含各种条件语句、循环语句等，以动态生成最终的SQL语句。

下面是一些使用`<script>`标签的常见场景：

### 1. 条件判断：

```xml
<select id="getUserByCondition" resultType="User">
    <script>
        SELECT * FROM users
        <where>
            <if test="id != null">
                AND id = #{id}
            </if>
            <if test="username != null">
                AND username = #{username}
            </if>
        </where>
    </script>
</select>
```

在这个例子中，`<script>`标签用于包装动态SQL，`<if>`标签用于条件判断。根据传入的参数，动态生成不同的SQL语句。

### 2. 循环：

```xml
<select id="getUserByIds" resultType="User">
    <script>
        SELECT * FROM users
        WHERE id IN
        <foreach item="id" collection="ids" open="(" separator="," close=")">
            #{id}
        </foreach>
    </script>
</select>
```

在这个例子中，`<foreach>`标签用于循环遍历传入的集合（`ids`），并将其中的元素拼接到SQL语句中。

### 3. 多个SQL语句：

```xml
<update id="updateUser" parameterType="User">
    <script>
        UPDATE users
        SET
        <if test="username != null">username = #{username},</if>
        <if test="password != null">password = #{password},</if>
        WHERE id = #{id}
    </script>
</update>
```

在这个例子中，`<script>`标签用于包装多个SQL语句。根据传入的参数，动态生成不同的更新语句。

总的来说，`<script>`标签使得在MyBatis XML配置文件中编写动态SQL变得更加灵活，可以根据条件、循环等动态生成不同的SQL语句，以满足不同的需求。
~~~



- **缓存的使用：** MyBatis 提供了一级缓存和二级缓存。一级缓存是在 SqlSession 内部的缓存，它的作用域是同一个 SqlSession。二级缓存是在整个应用程序级别的缓存，可以跨多个 SqlSession。在使用缓存时，需要注意缓存的清理和更新，以确保数据的一致性。

- **日志记录：** 在开发和调试阶段，配置合适的日志级别，以便记录生成的 SQL 语句、参数和执行时间等信息，有助于排查问题和性能调优。

    ```xml
    <!-- 在 mybatis-config.xml 中配置日志 -->
    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>
    ```

    **事务管理：** MyBatis 不会自动提交事务，需要手动调用 `commit` 方法。在进行数据库写操作时，确保配置了正确的事务管理器，并在需要的地方进行事务的提交或回滚。

    1. **批量操作：** MyBatis 支持批量插入、更新和删除操作，可以通过 `insertList`、`updateList` 和 `deleteList` 等方法来实现。批量操作通常能提升性能，但需要注意数据库驱动的支持和配置。

    2. **异常处理：** 在进行数据库操作时，适当处理异常情况是非常重要的。MyBatis 会将数据库操作可能抛出的异常包装成 `PersistenceException`，可以捕获该异常进行处理。

        ```java
        try {
            // 执行数据库操作
        } catch (PersistenceException e) {
            // 处理异常
        }
        ```

    3. **数据库连接池：** 配置合适的数据库连接池对于应用程序的性能和稳定性非常重要。常用的连接池包括 Apache DBCP、C3P0、HikariCP 等，选择适合项目需求的连接池进行配置。

    4. **使用参数映射：** 在进行参数传递时，使用 `@Param` 注解进行参数映射，以避免参数名和数据库字段名的冲突，确保参数传递的准确性。

        ```java
        User getUserById(@Param("userId") int userId);
        ```

    5. **适当使用 resultMap：** 在结果映射时，适当使用 resultMap 进行结果的映射，有助于提高代码的可维护性和可读性。

    以上是一些在使用 MyBatis 进行数据库操作时的额外注意事项。在实际项目中，根据具体情况，还需要考虑数据库性能、表设计、索引的使用等方面的问题，以确保数据库操作的高效和稳定。

### mybatis多表查询

1.引入依赖（pom.xml） 

2. 全局配置文件（mybatis-config.xml）
3. 3.配置Map.xml(AccountMapper.xml)

多表查询是在 MyBatis 中经常遇到的需求，它涉及到联合查询、嵌套查询、关联映射等操作。以下是一些多表查询的语法和注意细节：

### 1. 联合查询

联合查询使用 SQL 的 `JOIN` 操作，可以在 Mapper XML 文件中编写 SQL 语句进行定义。常见的联合查询有 INNER JOIN、LEFT JOIN 等。以下是一个简单的例子：

```xml
<!-- 在 Mapper XML 文件中定义联合查询 -->
<select id="getUsersWithOrders" resultType="User">
    SELECT u.*, o.order_id, o.order_date
    FROM users u
    INNER JOIN orders o ON u.user_id = o.user_id
</select>
```

### 2. 嵌套查询

嵌套查询用于在一个查询中包含另一个查询，可以通过 MyBatis 的 `association` 和 `collection` 元素来配置。例如，查询用户及其关联的订单：

```xml
<!-- 在 Mapper XML 文件中配置嵌套查询 -->
<select id="getUserWithOrders" resultType="User">
    SELECT * FROM users WHERE user_id = #{userId}
    <collection property="orders" ofType="Order" resultMap="orderResultMap">
        SELECT * FROM orders WHERE user_id = #{userId}
    </collection>
</select>
```

### 3. 关联映射

关联映射是 MyBatis 中一对一或一对多关系的映射方式，可以通过 `association` 和 `collection` 元素来配置。以下是一个一对多关系的例子：

```xml
<!-- 在 Mapper XML 文件中配置一对多关联映射 -->
<resultMap id="userResultMap" type="User">
    <id property="userId" column="user_id"/>
    <result property="username" column="username"/>
    <!-- 配置一对多关联映射 -->
    <collection property="orders" ofType="Order" resultMap="orderResultMap">
        <id property="orderId" column="order_id"/>
        <result property="orderDate" column="order_date"/>
    </collection>
</resultMap>
```

### 注意事项：

1. **避免N+1查询问题：** 在进行一对多查询时，避免因为关联查询次数过多导致的性能问题。可以使用 `fetchType` 属性控制懒加载，或者通过 `JOIN` 查询一次性获取所有需要的数据。

2. **使用别名：** 在多表查询中，使用表的别名有助于提高查询语句的可读性和简洁性。

    ```sql
    SELECT u.*, o.order_id, o.order_date
    FROM users u
    JOIN orders o ON u.user_id = o.user_id
    ```

3. **了解数据库关联关系：** 在进行多表查询之前，了解数据库表之间的关联关系是非常重要的，以便编写正确的联合查询或关联映射。

4. **合理利用缓存：** 在进行多表查询时，需要注意缓存的使用，确保缓存的一致性。

5. **使用合适的连接方式：** 在联合查询时，选择适当的连接方式（`INNER JOIN`、`LEFT JOIN`等）根据实际需求，以确保查询结果符合预期。

以上是一些在 MyBatis 中进行多表查询的语法和注意细节。根据实际需求，可以使用不同的查询方式和映射关系，以实现复杂的数据库操作。



```xml

```











### Myabtis注意事项：



##### **MyBatis 不建议使用 `*` 访问数据**

的主要原因是潜在的性能和维护性问题。以下是一些使用 `*` 的问题和建议：

1. **性能问题：**
   - 当使用 `*` 时，查询语句会选择表中的所有列。这可能导致不必要的数据传输，增加网络开销和查询时间。
   - 查询的结果集中可能包含大量不需要的字段，浪费了带宽和资源。

2. **维护性问题：**
   - 使用 `*` 使得 SQL 查询变得不透明，难以理解。维护人员可能不清楚查询中涉及的确切列。
   - 当表结构发生变化时，可能会影响到使用 `*` 的所有查询，增加了维护的复杂性。

3. **数据冗余和安全问题：**
   - 返回不必要的列可能导致数据冗余，增加了应用程序处理的数据量。
   - 对于敏感信息，如果无意中被检索到并返回给客户端，可能导致安全问题。

4. **版本控制问题：**
   - 如果使用 `*`，当表结构变化时，查询的结果可能会改变，导致可能在不同版本之间出现问题。

为了解决这些问题，建议在查询语句中显式指定需要的列，而不是使用 `*`。这样可以提高查询的性能，使查询更加明确和易于维护。例如，使用类似以下的语法：

```sql
SELECT column1, column2, column3
FROM your_table
WHERE ...
```

通过明确指定列，可以确保只检索应用程序需要的数据，提高查询效率，并降低数据传输和存储的成本。




##### 常见的注意事项：

1. **数据库连接管理：** MyBatis本身不提供数据库连接池，因此你需要确保在项目中配置一个合适的数据库连接池，比如Apache DBCP、C3P0或HikariCP。合理的连接池配置对于数据库访问性能至关重要。

2. **SQL注入：** 尽量避免使用字符串拼接的方式构建SQL语句，以防止SQL注入攻击。最好使用参数化的SQL语句，MyBatis会负责将参数值安全地注入到SQL中。

   ```
   javaCopy code
   // 避免字符串拼接，使用参数化的SQL语句
   @Select("SELECT * FROM users WHERE username = #{username} AND password = #{password}")
   User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
   ```

3. **事务管理：** MyBatis本身不提供事务管理，因此你需要确保在项目中正确配置事务管理器，并在需要的地方使用`@Transactional`注解或手动管理事务。

4. **懒加载：** MyBatis支持懒加载，但在使用时需要注意懒加载可能引发的N+1查询问题。可以通过配置来开启或关闭懒加载，根据具体情况进行选择。

   ```
   xmlCopy code
   <!-- 在 mybatis-config.xml 中配置懒加载 -->
   <settings>
       <setting name="lazyLoadingEnabled" value="true"/>
   </settings>
   ```

5. **结果映射：** 确保正确配置结果映射，使得查询结果能够正确地映射到对应的Java对象。注意数据库列名和Java对象属性名的大小写敏感性。

6. **缓存配置：** MyBatis提供了一级缓存和二级缓存，确保正确配置缓存以提高查询性能。但要注意缓存可能引发的数据一致性问题，特别是在多表更新操作后，需要手动清理缓存。

7. **Mapper接口和XML文件对应关系：** MyBatis默认会按照Mapper接口的全限定名去寻找对应的XML文件。确保Mapper接口和XML文件的命名和包路径对应正确。

8. **使用Mapper动态代理：** 尽量使用Mapper接口的方式，而不是直接使用SqlSession执行SQL语句。使用Mapper接口可以使代码更具有结构性和可维护性。
