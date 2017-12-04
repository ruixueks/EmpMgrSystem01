package com.cheer.empmgrsystem.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// 过滤器经典使用场景：登录状态检查
@WebFilter(filterName = "authorizeFilter", urlPatterns = {"/*"})
public class AuthorizeFilter implements Filter
{

    /**
     * @see Filter#destroy()
     */
    public void destroy()
    {

    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException,
            ServletException
    {
        HttpServletResponse rsp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();

        if (this.checkUri(uri))
        {
            HttpSession session = req.getSession();
            Object obj = session.getAttribute("isLogin");

            // 看session里面是有登录状态isLogin=true
            if (obj == null || !(Boolean) obj)
            {
                String loginPath = req.getContextPath() + "/login.jsp";
                rsp.sendRedirect(loginPath);
            } else
            {
                chain.doFilter(request, response);
            }
        } else
        {
            chain.doFilter(request, response);
        }

    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig)
            throws ServletException
    {
        // TODO Auto-generated method stub
    }

    private boolean checkUri(String uri)
    {
        // 排除登录页面/登录Servlet以及静态资源（js、css、图片等）
        if (uri.endsWith("login.jsp") || uri.endsWith("/servlet/login") || uri.endsWith(".js") || uri.endsWith("" +
                ".css") || uri.endsWith(".img") || uri.endsWith(".png"))
        {
            return false;
        }

        return true;
    }

}
