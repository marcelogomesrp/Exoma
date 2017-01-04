package br.usp.exoma.view;

import java.io.IOException;
import java.io.Serializable;
import javax.inject.Inject;
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
 *
 * @author marcelo
 */
//@WebFilter(urlPatterns="/logado/*", servletNames="{Faces Servlet}")
//@WebFilter(urlPatterns="/exoma/logado/*")
@WebFilter(filterName="loginFilter", urlPatterns={ "/logado/*" })
public class LoginFilter implements Filter, Serializable{
    @Inject
    private UserSession userSession;
    
    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain fc) throws IOException, ServletException {
        System.out.println("Filtro em acao***********************************************************************************************************");
        HttpServletRequest httpServletRequest = (HttpServletRequest) srequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) sresponse;  
        userSession = (UserSession)((HttpServletRequest)srequest).getSession().getAttribute("userSession");
        if(userSession == null){
            System.out.println("Injection falou****************");
            httpServletResponse.sendRedirect("/exoma/login.xhtml");
        }
        
        if(userSession.isLoggedIn()){
            fc.doFilter(srequest, sresponse);
        }else{
            //httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.xhtml");
            httpServletResponse.sendRedirect("/exoma/login.xhtml");
        } 
    }

    @Override
    public void destroy() {
    }

    
}
