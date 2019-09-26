package com.dfqx.config.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {
    private static Logger log= LoggerFactory.getLogger(AccessFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        log.info("send{} request to {}",request.getMethod(),request.getRequestURI().toString());
        Object accessToken= request.getParameter("accessToken");
        if(null==accessToken){
            log.warn("accessToken  is empty!!");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return  null;
        }
        log.info("accessToken ok!!");
        return null;
    }
}
