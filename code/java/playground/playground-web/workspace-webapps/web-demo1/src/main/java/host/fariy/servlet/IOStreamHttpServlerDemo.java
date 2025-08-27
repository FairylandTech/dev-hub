/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-27 15:43:28 UTC+08:00
 ****************************************************/
package host.fariy.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Lionel Johnson
 */
@WebServlet("/demo3")
public class IOStreamHttpServlerDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FileInputStream file = new FileInputStream("E:\\DevData\\174fb91b3d6248e3a41071b2ae386a89.jpg");
        
        ServletOutputStream outputStream = resp.getOutputStream();
        
        resp.setContentType("image/jpeg");
        resp.setHeader("Content-Disposition", "attachment;filename=kasha.jpg");
        
        byte[] buff = new byte[1024];
        int len;
        while ((len = file.read(buff)) != -1) {
            outputStream.write(buff, 0, len);
        }
        
        file.close();
    }
}
