package com.cheer.empmgrsystem.web.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cheer.empmgrsystem.domain.Emp;
import com.cheer.empmgrsystem.service.EmpService;

/**
 * Servlet implementation class AddEmpServlet
 */
@WebServlet(name = "addEmpServlet", urlPatterns = { "/servlet/addEmpServlet" })
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		//String hiredate = request.getParameter("hiredate");
		String sal = request.getParameter("sal");
		
		
		EmpService empService = (EmpService)this.getServletContext().getAttribute("empService");
		
		
		Emp emp = new Emp();
		emp.setEmpno(Integer.valueOf(empno));
		emp.setEname(ename);
		emp.setJob(job);
		
		emp.setHiredate(new Date(1));
		
		emp.setSal(Double.valueOf(sal));
		System.out.println(empno);
		empService.save(emp);
		
		response.sendRedirect("../index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
