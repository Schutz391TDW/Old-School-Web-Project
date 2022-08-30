<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Cart</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Your cart</h1>
        <span class="info">
            <table>
                <tr>
                    <th>Cover</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>Amount</th>
                    <th>Quantity</th>
                    <th></th>
                </tr>
            <c:forEach var="item" items="${cart.items}">
                <tr>
                    <td>
                        <img src= "<c:out value='${item.product.cover}' />">
                    </td>
                    <td>
                        <c:out value='${item.product.title}' />
                    </td>
                    <td>
                        ${item.product.priceCurrencyFormat}
                    </td>
                    <td>
                        ${item.totalCurrencyFormat}
                    </td>
                    <td>
                        <form action="" method="post">
                            <input type="hidden" name="productCode"
                                   value="<c:out value='${item.product.code}'/>">
                            <input type="text" name="quantity"
                                   value="<c:out value='${item.quantity}'/>" id="quantity">
                            <input type="submit" class="button" value="Update">
                        </form>
                    </td>
                    <td>
                        <form action="" method="post">
                            <input type="hidden" name="productCode"
                                   value="<c:out value='${item.product.code}'/>">
                            <input type="hidden" name="quantity" value="0">
                            <input type="submit" class="button" value="Remove Item">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </table>
        </span>
        <p><b>To change the quantity</b>, enter the new quantity and
            click on the Update button.</p>
        
        <form action="" method="post">
            <input type="hidden" name="action" value="shop">
            <input type="submit" class="button" value="Continue Shopping">
        </form>
        
        <form action="" method="post">
            <input type="hidden" name="action" value="checkout">
            <input type="submit" class="button" value="Checkout">
        </form>
    </body>
</html>
