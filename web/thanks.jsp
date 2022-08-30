<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Thanks!</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Thanks for your order</h1>
        <p>Here is the information that you entered:</p>
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
                        ${item.quantity}
                    </td>
                </tr>
            </c:forEach>
                <tr>
                    <td><b>Total</b></td>
                    <td></td>
                    <td></td>
                    <td>${item.grandTotal}</td>
                    <td></td>
                </tr>
            </table>
            <p>To order another book, click on the button below.</p>
        </span>
        <form action="" method="post">
            <input type="hidden" name="action" value="restart">
            <input type="submit" class="button" value="Order More?">
        </form>
    </body>
</html>
