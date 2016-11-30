package com.ss.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName = "/lf",urlPatterns="/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        super();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String reqUrl = req.getRequestURI().substring(req.getRequestURI().indexOf("/",1),req.getRequestURI().length());
		  if(!"/login.jsp".equals(reqUrl) && !"/login".equals(reqUrl)&& !"/loginC".equals(reqUrl))  
          {  
              //ȡ��session. ���û��session���Զ��ᴴ��һ��, ������false��ʾû��ȡ�õ�session������ΪsessionΪ��.  
			 // HttpSession session = req.getSession(false);  
              //���session��û���κζ���.  
              if(req.getSession() == null ||req.getSession().getAttribute("user")==null)  
              {  
                  res.sendRedirect(req.getContextPath() + "/login");  
                  //����  
                  return;  
              }  
            
                
          }  
		  //�ѵ�¼ ��ת��ҳ
		  if("/login.jsp".equals(reqUrl)|| "/login".equals(reqUrl)){
		  if(req.getSession() != null &&req.getSession().getAttribute("user")!=null)  {
			  res.sendRedirect("main");
			  return;  
		  }
		  }
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
