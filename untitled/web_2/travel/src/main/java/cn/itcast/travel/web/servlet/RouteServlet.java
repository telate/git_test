package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.impl.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RouteService routeService=new RouteServiceImpl();


        // 接受参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        // 处理参数
        // 分类行id
         int cid=0;
        if(cidStr !=null && cidStr.length()>0){
            // 将字符串转换成int类型
             cid = Integer.parseInt(cidStr);
        }


        // 当前页数
        int currentPage=0;
        if(currentPageStr !=null && currentPageStr.length()>0){
            // 满足条件，则将字符床转换成int类型
            currentPage = Integer.parseInt(currentPageStr);
        }else{
            // 不满足条件，则默认当前页数为1
            currentPage=1;
        }


        // 每页显示的条数
        int pageSize=0;
        if(pageSizeStr !=null && pageSizeStr.length()>0){
            // 满足条件，则将字符床转换成int类型
            pageSize = Integer.parseInt(pageSizeStr);
        }else{
            // 不满足条件，则默认每页显示条数为5条
            pageSize=5;
        }


        // 调用service查询pageBean对象
        PageBean<Route> pb = routeService.PageQuery(cid, currentPage, pageSize);

        // 将pageBean对象，序列化为json
        writeValue(pb,response);

    }
}
