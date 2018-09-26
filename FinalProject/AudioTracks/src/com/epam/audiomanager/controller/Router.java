package com.epam.audiomanager.controller;

import com.epam.audiomanager.exception.ProjectException;
import com.epam.audiomanager.util.constant.ConstantPathPages;

public class Router {
    private String pagePath = ConstantPathPages.PATH_PAGE_LOGIN;
    private RouteType routeType = RouteType.FORWARD;

    public String getPagePath(){
        return pagePath;
    }

    public void setPagePath(String pagePath) throws ProjectException {
        if (pagePath != null) {
            this.pagePath = pagePath;
        } else {
            throw new ProjectException("Wrong page path!");
        }
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteTypeRedirect() {
        this.routeType = RouteType.REDIRECT;
    }
}