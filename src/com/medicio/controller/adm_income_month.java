package com.medicio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.medicio.dao.CustomerDAO;
import com.medicio.model.AppHistoryDetails;
import com.medicio.model.DoctorDetails;

@WebServlet("/adm_income_month")
public class adm_income_month extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adm_income_month() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		

	      //CREATE OBJECT OF DAO CLASS
   	    CustomerDAO cdaoobj = new CustomerDAO();
   	    AppHistoryDetails appobj=new AppHistoryDetails();
		String appointment_date = request.getParameter("appointment_date");
		appobj.setAppointment_date(appointment_date);

		appobj.setAppointment_date(request.getParameter("appointment_date"));	
		System.out.println("U enter:"+request.getParameter("appointment_date"));
	 	   int replyfromdao=cdaoobj.income_month(appobj);
	 	   String msg="";
	 	  
	 	 Integer intInstance = new Integer(replyfromdao);      
	 	 String number = intInstance.toString();
	 	  
	 	   request.setAttribute("servermsg", number);
	 	   RequestDispatcher rd=request.getRequestDispatcher("/adm_income_month.jsp");
	 	   rd.forward(request, response);
	 	   
 		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
