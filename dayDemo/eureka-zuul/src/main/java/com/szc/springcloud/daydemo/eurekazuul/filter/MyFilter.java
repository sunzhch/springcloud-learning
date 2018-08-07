package com.szc.springcloud.daydemo.eurekazuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: MyFilter
 * @Description: 路由过滤Filter
 * @Auther: sunzhichao
 * @Date: 2018/8/7 15:07
 * @Version: V1.0
 */
@Component
public class MyFilter extends ZuulFilter {
    /**
     * 路由之前
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤逻辑
     * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        System.out.println(request.getRequestURL().toString());
//        if (request.getRequestURL().toString().contains("/api-ribbon/")
//                || request.getRequestURL().toString().contains("/api-feign/")) {
            Object accessToken = request.getParameter("token");
            if(accessToken == null) {
                System.out.println("token is empty");
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                try {
                    ctx.getResponse().getWriter().write("Hey,guys,your token is empty.");
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                return null;
            }
//        } else {
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            try {
//                ctx.getResponse().getWriter().write("Hey,guys,your request-Path is uncorrect.");
//            }catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//            return null;
//        }

        System.out.println("Filter is over.");
        return null;
    }
}
