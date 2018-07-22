package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        String title = "Cart - Basic Webshop";

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        createCart() +
                        "</body></html>"
        );
    }

    private String createCart() {
        StringBuilder sb = new StringBuilder();
        double sumOfPrices = 0;

        sb.append("<table>\n");
        for (Item item : ItemStore.getItems()) {
            double price = item.getPrice();
            sumOfPrices += price;

            sb.append("<tr>\n");

            // NAME
            sb.append("<td>");
            sb.append(item.getName());
            sb.append("</td>\n");

            // PRICE
            sb.append("<td>");
            sb.append(price);
            sb.append("</td>\n");

            sb.append("</tr\n");
        }
        sb.append("</table>\n");

        // Sum of Price
        sb.append("<h2>Sum of Price: ");
        sb.append(sumOfPrices);
        sb.append(" USD</h2>");

        return sb.toString();
    }
}
