package com.jxy.springMvc;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

/**
 * 以Tomcatjava启动spring项目
 * 1.关键点，设置Tomcat扫描包的上下文路径
 */
public class Appication {
    public static final int SERVER_PORT = 80;
    public static void main(String[] args) throws ServletException, LifecycleException {
        startTomcat();
    }
    public static void startTomcat() throws ServletException, LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(SERVER_PORT);

        //读取路径
        StandardContext context = (StandardContext)
                tomcat.addWebapp("/",
                        new File("src/main").getAbsolutePath());
        // 禁止重新载入
        context.setReloadable(false);
        tomcat.start();
        // 异步等待请求执行
        tomcat.getServer().await();
    }
}
