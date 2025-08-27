/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-27 12:52:30 UTC+08:00
 ****************************************************/
package host.fariy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Lionel Johnson
 */
@MultipartConfig
@WebServlet("/demo2")
public class HttpServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HttpServletDemo GET 方法");
        
        // 解决get请求中文乱码问题
        req.setCharacterEncoding("UTF-8");
        
        // 1. 获取请求方式
        String method = req.getMethod();
        System.out.println("method: " + method);
        // 2. 获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println("contextPath: " + contextPath);
        // 3. 获取Servlet路径
        String servletPath = req.getServletPath();
        System.out.println("servletPath: " + servletPath);
        // 4. 获取get方式请求参数
        String queryString = req.getQueryString();
        System.out.println("queryString: " + queryString);
        // 5. 获取请求URI
        String requestURI = req.getRequestURI();
        System.out.println("requestURI: " + requestURI);
        // 6. 获取请求URL
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL: " + requestURL);
        // 7. 获取协议及版本
        String protocol = req.getProtocol();
        System.out.println("protocol: " + protocol);
        // 8. 获取客户机的IP地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println("remoteAddr: " + remoteAddr);
        // 9. 获取请求参数
        String username = req.getParameter("username");
        System.out.println("username: " + username);
        
        // 获取请求头 User-Agent
        String userAgent = req.getHeader("user-agent");
        System.out.println("userAgent: " + userAgent);
        
        // 设置响应数据
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("Hello, " + username);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HttpServletDemo POST 方法");
        // 解决post请求中文乱码问题
        req.setCharacterEncoding("UTF-8");
        
        // form-date 数据, 需要再 servlet类上添加 @MultipartConfig 注解
        System.out.println("--- form-date 数据 ---");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.printf("name=%s, age=%s\n", name, age);
        
        // x-www-form-urlencoded 数据
        System.out.println("--- x-www-form-urlencoded 数据 ---");
        String name1 = req.getParameter("name");
        String age1 = req.getParameter("age");
        System.out.printf("name=%s, age=%s\n", name1, age1);
        
        // Json 数据
//        System.out.println("--- Json 数据 ---");
//        BufferedReader reader = req.getReader();
//        StringBuilder sb = new StringBuilder();
//        String line;
//        while ((line = reader.readLine()) != null) {
//            sb.append(line);
//        }
//        String jsonBody = sb.toString();
//        System.out.println("jsonBody: " + jsonBody);
        
        System.out.println();
    }
}
