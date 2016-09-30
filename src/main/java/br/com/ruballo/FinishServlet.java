package br.com.ruballo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcosarruda on 9/24/16.
 */
@WebServlet("/finish")
public class FinishServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Enumeration<String> paramNames = request.getParameterNames();
        StringBuffer query = new StringBuffer();
        while(paramNames.hasMoreElements()){
            String param = paramNames.nextElement();
            if(param.startsWith("service")){
                Integer serviceId = Integer.parseInt(param.substring(7, param.length()));
                query.append("UPDATE SERVICE " +
                                " SET STATUS='"+request.getParameter(param)+"', SERVICE_DATE_UPDATED=DATETIME('now', 'localtime') " +
                                " WHERE SERVICE_ID="+serviceId+"; ");
            }
        }

        try {
            SQLiteDB.executeUpdate(query.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/finish.jsp");
        rd.forward(request, response);
    }
}
