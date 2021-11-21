package com.higradius;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 3L;
    private Add edit=new Add();

 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

   
        String invoice = request.getParameter("invoice");
        String amt = request.getParameter("amt");
        String notes = request.getParameter("notes");
        System.out.println(notes);
        ExecutionResponse exe = new ExecutionResponse();
      
        
        exe.setAmt(amt);
        
        exe.setNotes(notes);

        try {
            Add.Execution(exe);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

      response.getWriter().write("Hello");
    }
}