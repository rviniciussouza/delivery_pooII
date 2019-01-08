package br.edu.ifnmg.filter;

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
import javax.servlet.http.HttpSession;

import br.edu.ifnmg.model.Administrador;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName = "/LoginFilter", urlPatterns = ("/Login.xhtml"))
public class LoginAdminFilter implements Filter {


    public LoginAdminFilter() {
        // TODO Auto-generated constructor stub
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
		Administrador administrador = null;
        HttpSession session = ((HttpServletRequest)request).getSession();
         
        if (session != null){
              administrador = (Administrador)session.getAttribute("admin");
        }      

        if (administrador == null) {
        	chain.doFilter(request, response);        
        }else {        	
        	String contextPath = ((HttpServletRequest) request).getContextPath();
        	((HttpServletResponse)response).sendRedirect(contextPath + "/app/index.xhtml");
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
