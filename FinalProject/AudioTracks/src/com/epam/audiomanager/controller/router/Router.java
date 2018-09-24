package com.epam.audiomanager.controller.router;

public class Router {
    private String pagePath;
    private RouteType routeType = RouteType.FORWARD;

    public String getPagePath(){
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType == null ? RouteType.FORWARD : routeType;
    }
}
