package andrew.book;

import andrew.business.User;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BookOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";
        
        //Gets the current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }
        
        //Sets the URL to the correct page
        if (action.equals("join")) {
            url = "/index.jsp";
        }
        else if (action.equals("add")) {
            //Gets the users name, email, and sees which check boxes are checked
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String bookTitle = request.getParameter("bookTitle");
            String gauntletCheckBox = request.getParameter("gauntlet");
            String msCheckBox = request.getParameter("ms");
            String captainCheckBox = request.getParameter("captain");
            String antCheckBox = request.getParameter("ant");
            
            //Creates a new user with the info
            User user = new User(fullName, email, bookTitle);
            
            //Checks to make sure one book is selected or sends out message
            String message;
            if (gauntletCheckBox == null && msCheckBox == null && captainCheckBox == null
                    && antCheckBox == null) {
                message = "Please select at least one book.";
                url = "/index.jsp";
            } else {
                message = "";
                url = "/thanks.jsp";
            }
            
            //Sets Attributes for thanks.jsp
            request.setAttribute("user", user);
            request.setAttribute("message", message);
            request.setAttribute("gauntlet", gauntletCheckBox);
            request.setAttribute("ms", msCheckBox);
            request.setAttribute("captain", captainCheckBox);
            request.setAttribute("ant", antCheckBox);
        }
        
        //Forwards request and response to URL
        getServletContext().getRequestDispatcher(url).forward(request, response);
        
    }
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {
        doPost(request, response);
    }
}
