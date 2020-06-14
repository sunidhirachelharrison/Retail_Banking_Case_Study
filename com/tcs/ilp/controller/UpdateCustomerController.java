package com.tcs.ilp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.graalvm.compiler.nodes.calc.IsNullNode;

import com.tcs.ilp.bean.CustomerBean;
import com.tcs.ilp.service.CustomerService;


//@WebServlet("/UpdateCustomerController")
public class UpdateCustomerController extends HttpServlet {
//	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerBean fetchedCustomer=new CustomerBean();
		CustomerService cusService=new CustomerService();
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		
		String search_criteria=request.getParameter("searchCriteria");
		int search_value=Integer.parseInt(request.getParameter("searchValue"));
		//int search_value=request.getParameter("searchValue");
		
		fetchedCustomer=cusService.searchCustomer(search_value, search_criteria);
		
		if(fetchedCustomer!=null)
		{
			//show customer details
			session.setAttribute("searchCustomerStatus", "found");
			session.setAttribute("searchCustomerNotFound", null);
			session.setAttribute("customer_ssn_id", fetchedCustomer.getCustomer_ssn_id());
			session.setAttribute("customer_id", fetchedCustomer.getCustomer_id());
			session.setAttribute("customer_name", fetchedCustomer.getCustomer_name());
			session.setAttribute("customer_age", fetchedCustomer.getCustomer_age());
			session.setAttribute("customer_address", fetchedCustomer.getCustomer_address());
			session.setAttribute("customer_state", fetchedCustomer.getCustomer_state());
			session.setAttribute("customer_city", fetchedCustomer.getCustomer_city());
			
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/UpdateCustomer.jsp");
			out=response.getWriter();
			rd.forward(request, response);

		}
		else
		{
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/UpdateCustomer.jsp");
			session.setAttribute("searchCustomerStatus", null);
			session.setAttribute("searchCustomerNotFound", "not found");
//		    out=response.getWriter();
//			out.print("<font color=red>No customer exists with the specified ID!</font>");
			rd.forward(request, response);
		}
		
		
		
		//update customer info
		
		
		if(session.getAttribute("Customer_SSN_ID")!=null)		//or check button value set
		{
			
			int ssn_id=Integer.parseInt(request.getParameter("Customer_SSN_ID"));
			int cus_id=Integer.parseInt(request.getParameter("Customer_ID"));
			String old_name=request.getParameter("Old_Customer_Name");
			String new_name=request.getParameter("New_Customer_Name");
			if(new_name==null || new_name.equals(""))
			{
				new_name=old_name;
			}
			
			
			String old_address=request.getParameter("Old_Address");
			String new_address=request.getParameter("New_Address");

			if(new_address==null || new_address.equals(""))
			{
				new_address=old_address;
			}
			
			int old_age=Integer.parseInt(request.getParameter("Old_Age"));
			int new_age=Integer.parseInt(request.getParameter("New_Age"));
//			if(isNaN(new_age))
//			{
//				new_age=old_age;
//			}
			
//			CustomerBean cus_obj=new CustomerBean(ssn_id,cus_id,new_name,new_age,new_address);
		}
		
		
		
	}

}
