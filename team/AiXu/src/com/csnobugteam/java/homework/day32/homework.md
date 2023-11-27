# 作业一：
1. 使用虚拟映射的方式部署资源文件，同桌之间互相访问测试,要求仅通过ip地址便可以访问到（如果自己可以访问到，别人访问不到，则是防火墙的问题，关闭防火墙），要求将相关操作步骤记录下来，并尝试使用自己的语言说明Tomcat是如何处理请求的
---
解答：
- 步骤一：准备资源文件首先，你有一些资源文件（例如HTML、CSS、JavaScript等）需要部署。放在一个名为myresources的文件夹。

- 步骤二：编辑Tomcat配置文件打开Tomcat的server.xml文件。这个文件通常位于Tomcat的conf目录下。在<Host>标签中添加一个Context标签，用于虚拟映射path 属性定义了访问资源的路径，可以是任何路径，这里设为 /myresources。docBase 属性定义了资源文件的实际路径保存并关闭 server.xml 文件。
- 步骤三：关闭防火墙确保关闭服务器上的防火墙，以便其他人可以访问。
- 步骤四：重启 Tomcat 服务器重启 Tomcat 服务器以应用配置更改。
- 步骤五：访问资源文件现在，可以通过使用 Tomcat 所在机器的 IP 地址和之前配置的虚拟路径访问资源。Tomcat会根据:当浏览器请求静态资源时，Tomcat 会根据配置的 <Context> 元素将请求映射到相应的资源路径。Tomcat 会检查资源文件是否存在，如果存在，就会将该文件发送给浏览器。如果不存在，Tomcat 将返回404错误。
---
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

---
# 作业三：
3.浏览器输入http://www.cskaoyan.com，自己动手抓包，用自己的语言分析整个请求的处理流程

---
当你在浏览器中输入 http://www.cskaoyan.com 并按下回车键时，浏览器会执行以下步骤，涉及到 DNS 解析、建立 TCP 连接、发起 HTTP 请求等：

1. DNS 解析：
浏览器首先会进行 DNS 解析，将域名 www.cskaoyan.com 解析为相应的 IP 地址。这个过程通常会先查看浏览器缓存，如果没有缓存或缓存过期，浏览器会向本地 DNS 服务器发出请求。本地 DNS 服务器会递归地查询直至找到对应的 IP 地址。

2. 建立 TCP 连接：
使用得到的 IP 地址，浏览器将尝试与 www.cskaoyan.com 上的服务器建立 TCP 连接。这个过程通常经过三次握手，确保客户端和服务器之间的通信能够稳定建立。

3. 发起 HTTP 请求：
一旦建立了 TCP 连接，浏览器就会通过该连接发送一个 HTTP 请求。这个请求包含了一些头部信息（如 Host、User-Agent 等）和一个路径，用于指定请求的资源。在这里，路径可能是 /，表示请求网站的根目录。

4. 服务器处理请求：
服务器收到请求后，会根据路径找到对应的资源。在这个例子中，服务器可能会找到网站的首页。

5. 服务器返回响应：
服务器将找到的资源封装在一个 HTTP 响应中，包括状态码、响应头和响应体。状态码告诉浏览器请求的处理结果，响应头包含了一些元信息，而响应体则包含了实际的页面内容。

6. 浏览器渲染：
浏览器接收到响应后，会解析响应体中的 HTML、CSS、JavaScript 等内容，并根据这些内容渲染页面。如果页面中包含其他资源（如图片、样式表、脚本等），浏览器会发起额外的请求来获取这些资源。

7. 页面显示：
最终，浏览器会将渲染好的页面显示给用户。

抓包分析：
使用抓包工具（如Wireshark、Fiddler、Chrome Developer Tools等），你可以捕捉整个过程中的网络数据包，包括 DNS 解析、TCP 握手、HTTP 请求和响应等。通过分析这些数据包，你可以深入了解请求的详细信息，包括请求头、响应头、状态码等。

总体而言，这个过程是一个典型的浏览器发起 HTTP 请求并渲染页面的流程。