package com.higradius;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 3L;
    private Add add=new Add();

 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String custname = request.getParameter("custname");
        String custnum = request.getParameter("custnum");
        String invoice = request.getParameter("invoice");
        String amt = request.getParameter("amt");
        String duedate = request.getParameter("duedate");
      
        String notes = request.getParameter("notes");
        System.out.println(notes);
        ExecutionResponse exe = new ExecutionResponse();
        exe.setCustname(custname);
        exe.setCustnumber(custnum);
        exe.setInvoice(invoice);
        exe.setAmt(amt);
        exe.setDuedate(duedate);
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