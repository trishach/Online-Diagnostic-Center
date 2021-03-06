package com.medicio.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medicio.dao.CustomerDAO;
import com.medicio.model.DoctorDetails;

@WebServlet("/adm_auth_doc")
public class adm_auth_doc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adm_auth_doc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String department = request.getParameter("department");
	      
	      //CREATE OBJECT OF DAO CLASS
   	    CustomerDAO cdaoobj = new CustomerDAO();
   	    
	      		
	      //CALL DAO METHOD
   	    List<DoctorDetails> doctlist = cdaoobj.fetchAllRecord(department);
	    String nextviewpage="";
	    
	    if(doctlist.size() > 0)
	    {
	    	request.setAttribute("custinformationlist", doctlist);
	    	nextviewpage ="adm_auth_doc.jsp";
	    }
	    else
	    {
	    	request.setAttribute("servermsg", "NO RECORDS FOUND");
	    	nextviewpage ="adm_auth_doc.jsp";
	    }
	          
	    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
   	rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
