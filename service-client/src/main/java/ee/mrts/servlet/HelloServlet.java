package ee.mrts.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ee.mrts.service.HelloService;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @EJB(lookup = "java:global/service-ear/service-ejb-impl/HelloServiceImpl!ee.mrts.service.HelloService")
    private HelloService helloService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            final String hello = helloService.sayHello();
            out.println("<p>HelloService says: " + hello);
        }
    }

    @Override
    public String getServletInfo() {
        return "HelloServlet tests HelloService";
    }
}
