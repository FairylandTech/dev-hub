/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-27 12:22:19 UTC+08:00
 ****************************************************/
package host.fariy.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author Lionel Johnson
 */
@WebServlet("/demo1")
public class ServletDemo implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化方式被调用...");
    }
    
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("ServletDemo service()...");
    }
    
    @Override
    public String getServletInfo() {
        return "";
    }
    
    @Override
    public void destroy() {
        
    }
}
