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
import java.util.ArrayList;

/**
 * Created by marcosarruda on 9/24/16.
 */
@WebServlet("/form")
public class FormServlet extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("list", mountOfficeSelect());
        //request.setAttribute("serviceSelect", mountServiceSelect());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/form.jsp");
        rd.forward(request, response);
    }

    private ArrayList<Office> mountOfficeSelect(){
        try{
            return SQLiteDB.getOfficesSelects();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    private ArrayList<Service> mountServiceSelect(int officeId){
        try{
            return SQLiteDB.getServiceSelects(officeId);
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
        request.setAttribute("services", mountServiceSelect(officeId));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/services.jsp");
        rd.forward(request, response);
    }
}
