
package andrew.cart;

import andrew.business.*;
import andrew.data.ProductIO;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CartServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext sc = getServletContext();
        
        String action = request.getParameter("action");
        if (action == null) {
            action = "cart";
        }
        String url = "/index.jsp";
        
        //When restarting sets url to index
        if (action.equals("restart")){
            url = "/index.jsp";
        }
        if (action.equals("shop")) {
            url = "/index.jsp";
        } else if (action.equals("cart")) {
            String productCode = request.getParameter("productCode");
            String quantityString = request.getParameter("quantity");
            
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }
            int quantity;
            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity < 0) {
                    quantity = 1;
                }
            } catch (NumberFormatException nfe) {
                quantity = 1;
            }
            
            //Sets path for items
            String path = sc.getRealPath("/WEB-INF/books.txt");
            Product product = ProductIO.getProduct(productCode, path);
            
            //Updates and removes items from cart
            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);
            if (quantity > 0) {
                cart.addItem(lineItem);
            } else if (quantity == 0) {
                cart.removeItem(lineItem);
            } 
            session.setAttribute("cart", cart);
            url = "/cart.jsp";
        } else if (action.equals("checkout")) {
            url = "/thanks.jsp";
        } else if (action.equals("restart")) {
            url ="/index.jsp";
        }
        
        sc.getRequestDispatcher(url)
                .forward(request, response);
    }
    
}
