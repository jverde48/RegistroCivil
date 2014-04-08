package mx.gob.renapo.registrocivil.util.impl;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 02/04/14
 * Time: 20:06
 * To change this template use File | Settings | File Templates.
 */
public class FlashScopeFixerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        response.getWriter();
        HttpServletResponseWrapper wrapper =
                new HttpServletResponseWrapper((HttpServletResponse) response);
        wrapper.setBufferSize(1000000);
        chain.doFilter(request, wrapper);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
