package com.tliasweb.filter;

import jakarta.servlet.annotation.WebFilter;

import jakarta.servlet.*;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class AbcFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Abc:拦截到了请求...放行前逻辑");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("Abc:拦截到了请求...放行后逻辑");
    }
}
