package com.tliasweb.filter;

import jakarta.servlet.annotation.WebFilter;

import jakarta.servlet.*;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    //初始化方法, 只调用一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init: 初始化方法执行了");
    }

    //拦截到请求之后调用, 调用多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Demo:拦截到了请求");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Demo:拦截到了请求...放行后逻辑");
    }

    //销毁方法, 只调用一次
    @Override
    public void destroy() {
        System.out.println("destroy: 销毁方法执行了");
    }
}
