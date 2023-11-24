# 作业一：
1. 使用虚拟映射的方式部署资源文件，同桌之间互相访问测试,要求仅通过ip地址便可以访问到（如果自己可以访问到，别人访问不到，则是防火墙的问题，关闭防火墙），要求将相关操作步骤记录下来，并尝试使用自己的语言说明Tomcat是如何处理请求的
---

解答：
- 步骤一：准备资源文件首先，你有一些资源文件（例如HTML、CSS、JavaScript等）需要部署。放在一个名为myresources的文件夹。

- 步骤二：编辑Tomcat配置文件打开Tomcat的server.xml文件。这个文件通常位于Tomcat的conf目录下。在<Host>标签中添加一个Context标签，用于虚拟映射path 属性定义了访问资源的路径，可以是任何路径，这里设为 /myresources。docBase 属性定义了资源文件的实际路径保存并关闭 server.xml 文件。
- 步骤三：关闭防火墙确保关闭服务器上的防火墙，以便其他人可以访问。
- 步骤四：重启 Tomcat 服务器重启 Tomcat 服务器以应用配置更改。
- 步骤五：访问资源文件现在，可以通过使用 Tomcat 所在机器的 IP 地址和之前配置的虚拟路径访问资源。Tomcat会根据:当浏览器请求静态资源时，Tomcat 会根据配置的 <Context> 元素将请求映射到相应的资源路径。Tomcat 会检查资源文件是否存在，如果存在，就会将该文件发送给浏览器。如果不存在，Tomcat 将返回404错误。

# 作业二：
2. 把我们上课谈到到的设置三种ROOT的方式做下尝试, 试着语言说明分别是什么情况(报错?冲突?优先级?)
---

解答：

在 Tomcat 中，有三种设置 ROOT 上下文路径的方式，分别是修改 server.xml、在 conf/Catalina/localhost/ 目录下创建 XML 文件、以及在 webapps 目录下直接创建 ROOT 目录。下面我将简要说明每种方式的情况：

1. 修改 server.xml

    步骤：
    - 打开 conf/server.xml 文件。
    在 <Host> 元素内部，将 <Context> 元素的 path 属性设置为 /，如下所示：
        ```xml
        <Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true">

            <!-- 设置 ROOT 上下文路径 -->
            <Context path="/" docBase="your-root-app" />

        </Host>
        ```
    - 保存并关闭 server.xml 文件。
    - 重启 Tomcat 服务器。

    结果：

    通过这种方式设置 ROOT 上下文路径，访问 Tomcat 根目录将直接访问 your-root-app 应用程序。例如，http://localhost:8080/ 将访问 http://localhost:8080/your-root-app。

2. 在 conf/Catalina/localhost/ 目录下创建 XML 文件
    步骤：

    - 在 conf/Catalina/localhost/ 目录下创建一个 XML 文件，例如 ROOT.xml。
    - 在 XML 文件中设置 Context 元素的 path 和 docBase 属性，如下：
        ```xml
        <Context path="" docBase="your-root-app" />
        ```
    - 保存并关闭 XML 文件。
    - 重启 Tomcat 服务器。

    结果：

    这种方式通过在 conf/Catalina/localhost/ 目录下创建 XML 文件，会将 ROOT 上下文路径设置为指定的应用程序。访问 Tomcat 根目录将直接访问 your-root-app 应用程序，类似于第一种方式。

3. 在 webapps 目录下创建 ROOT 目录
    步骤：

    - 在 Tomcat 的 webapps 目录下创建一个名为 ROOT 的目录。
    - 将你的 ROOT 应用程序放置在这个目录中。
    - 重启 Tomcat 服务器。

    结果：

    通过在 webapps 目录下创建 ROOT 目录，你可以直接将 ROOT 应用程序部署在 Tomcat 根路径。这是最简单的一种方式。访问 Tomcat 根目录将直接访问 ROOT 应用程序。

优先级和冲突：

当采用多种方式设置 ROOT 上下文路径时，它们的优先级如下：

- conf/server.xml 中的配置优先级最高。
- 其次是 conf/Catalina/localhost/ 目录下的 XML 文件。
- 最后是在 webapps 目录下创建 ROOT 目录。

如果存在多个配置方式，Tomcat 将按照上述优先级使用第一个找到的配置。因此，建议在部署中只选择一种方式，以避免潜在的冲突。