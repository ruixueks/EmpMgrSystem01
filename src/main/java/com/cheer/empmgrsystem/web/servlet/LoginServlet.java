package com.cheer.empmgrsystem.web.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cheer.empmgrsystem.domain.User;


@WebServlet(name = "login", urlPatterns = {"/servlet/login"})
public class LoginServlet extends HttpServlet
{
    private static final Logger LOGGER = LogManager.getLogger(LoginServlet.class);

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
    	//HttpSession session = request.getSession();
    	//session.setAttribute("username",username);
    	response.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8");  
        PrintWriter out = response.getWriter();  
          
        String username = request.getParameter("username");  
        String password = request.getParameter("password");  
          
        List<User> list = Db.getAll();  
        for(User u: list){  
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){  
                request.getSession().setAttribute("user", u);  
                response.sendRedirect("../hello.jsp");  
                return;  
            }  
        }  
          
        out.write("您的应户名或密码错误"); 
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {

        this.doGet(request, response);
    }

}
class Db{  
    public static List<User> list = new ArrayList<User>();  
    static{  
        list.add(new User("aaa","123"));  
        list.add(new User("bbb","123"));  
        list.add(new User("ccc","123"));  
    }
      
    public static List<User> getAll(){  
        return list;  
    }  
} 
