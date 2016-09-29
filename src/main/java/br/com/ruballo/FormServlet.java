package br.com.ruballo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by marcosarruda on 9/24/16.
 */
@WebServlet("form")
public class FormServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("officeSelect", mountOfficeSelect());
        //request.setAttribute("serviceSelect", mountServiceSelect());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    private String mountOfficeSelect(){
        try{
            return SQLiteDB.getOfficesSelects();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    private String mountServiceSelect(){
        try{
            return SQLiteDB.getServiceSelects();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int officeId = Integer.parseInt(request.getParameter("officeId"));
        request.setAttribute("officeId", officeId);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("services.jsp");
        rd.forward(request, response);
    }
}
