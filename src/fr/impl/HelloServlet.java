package fr.impl;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.beans.Hello;

@WebServlet(
    name = "hello",
    displayName = "My JEE 6 Servlet",
    description = "Ma première servlet avec annotations",
    loadOnStartup = 10,
    urlPatterns = { "/Hello1", "/Hello2" }
)
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB(name = "Hello")
    Hello hello;

    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String data = hello.sayHello();
        response.getWriter().printf("<p>%s</p>", data);
    }

}