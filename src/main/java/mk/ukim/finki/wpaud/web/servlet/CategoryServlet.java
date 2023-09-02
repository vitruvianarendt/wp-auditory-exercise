package mk.ukim.finki.wpaud.web.servlet;

import mk.ukim.finki.wpaud.model.Category;
import mk.ukim.finki.wpaud.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet ( name = "category-servlet", urlPatterns = "/servlet/category")
public class CategoryServlet extends HttpServlet {

    private final CategoryService categoryService;
    public CategoryServlet(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ipAddress = req.getRemoteAddr();
        String clientAgent = req.getHeader("User-Agent");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>User info</h3>");
        out.format("IP Address: %s<br/>", ipAddress);
        out.format("Client Agent: %s", clientAgent);
        out.println("<h3>Category List</h3>");
        out.println("<ul>");
        categoryService.listCategories().stream().forEach(r->
                out.format("<li>%s (%s)</li>", r.getName(), r.getDescription()));
        out.println("</ul>");
        out.println("<h3>Add New Category</h3>");
        out.println("<form method='post' action='/servlet/category'>");
        out.println("<label for='name'>Name:</label><input id='name' type='text' name='name'/>");
        out.println("<label for='desc'>Description:</label><input id='desc' type='text' name='description'/>");
        out.println("<input type='submit' value='Submit'/>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("name");
        String categoryDescription = req.getParameter("description");
        categoryService.create(categoryName, categoryDescription);
        resp.sendRedirect("/servlet/category");
    }

}
