package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "ayUserFiler", urlPatterns = "/*")

public class AyUserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws
    ServletException {
        System.out.println("--------------------> init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("--------------------> doFilter");

    }

    @Override
    public void destroy(){
        System.out.println("--------------------> destroy");
    }

}
