package cn.edu.bistu.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Decrain on 2017/3/3.
 */


/*

        struts获取Servlet累的action support

*/
public class SuperAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, ServletContextAware {

    private static final long serialVersionUID = 1L;

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;

    protected ServletContext application;


    public void setServletRequest(HttpServletRequest request) {

        this.request = request;

        this.session = this.request.getSession();

    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setServletContext(ServletContext application) {
        this.application = application;
    }
}