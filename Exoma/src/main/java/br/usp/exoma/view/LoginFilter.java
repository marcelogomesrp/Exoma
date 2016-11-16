package br.usp.exoma.view;

import java.io.IOException;
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
@WebFilter(urlPatterns="/logado/*", servletNames="{Faces Servlet}")
public class LoginFilter implements Filter{
    @Inject
    private UserSession userSession;
    
    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) srequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) sresponse;        
        if(userSession.isLoggedIn()){
            fc.doFilter(srequest, sresponse);
        }else{
            //httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.xhtml");
            httpServletResponse.sendRedirect("login");
        }       
    }

    @Override
    public void destroy() {
    }

    
}
