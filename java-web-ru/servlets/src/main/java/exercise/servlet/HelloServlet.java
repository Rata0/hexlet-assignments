package exercise.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // BEGIN
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        String parameter = req.getParameter("name");
        String name = parameter == null ? "Guest" : parameter;
        String message = "Hello, " + name + "!";
        req.setAttribute("message", message);

        req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, res);
    }
    // END
}
