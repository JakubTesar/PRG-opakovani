package cz.educanet.Askfm;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "Servlet", value = "/Servlet/*")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        if(pathInfo == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        String[] pathParts = pathInfo.split("/");

        ServletContext cntx= req.getServletContext();
        String filename = ("images/"+pathParts[pathParts.length-1]);
        String mime = cntx.getMimeType(filename);
        if (mime == null) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        resp.setContentType(mime);
        File file = new File(filename);
        resp.setContentLength((int)file.length());

        FileInputStream in = new FileInputStream(file);
        OutputStream out = resp.getOutputStream();

        byte[] buf = new byte[1024];
        int count = 0;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        out.close();
        in.close();
    }
}