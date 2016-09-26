package br.com.ruballo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by marcosarruda on 9/24/16.
 */
@WebServlet("form")
public class FormServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paramViadinho = request.getParameter("isViadinho");
        //int width = Integer.parseInt(paramWidth);

        String paramHeight = request.getParameter("isGayzola");
        //int height = Integer.parseInt(paramHeight);

        //long area = width * height;

        response.sendRedirect("finish.jsp");
    }
}
