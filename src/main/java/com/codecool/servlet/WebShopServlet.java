package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "WebShopServlet", urlPatterns = {"/"})
public class WebShopServlet extends HttpServlet {

    private static List<Item> availableItems = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        generateItems();
        PrintWriter out = response.getWriter();

        String add_id = request.getParameter("add_id");
        if (add_id != null) ItemStore.add(availableItems.get(Integer.valueOf(add_id)));

        String remove_id = request.getParameter("remove_id");

        String title = "Basic Webshop";
        String table = createTable();
        String cartButton =
                "<form action=\"/cart\">\n" +
                        "<input type=\"submit\" value=\"Check Shopping Cart\" />\n" +
                        "</form>\n";

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        cartButton +
                        table +
                        "</body></html>"
        );
    }

    private String createTable() {
        StringBuilder sb = new StringBuilder();

        sb.append("<table>\n");
        for (Item item : availableItems) {
            sb.append("<tr>\n");

            // NAME
            sb.append("<td>");
            sb.append(item.getName());
            sb.append("</td>\n");

            // PRICE
            sb.append("<td>");
            sb.append(item.getPrice());
            sb.append("</td>\n");

            // ADD button
            sb.append("<td>\n");
            sb.append("<form action=\"/?add_id=");
            sb.append(item.getID());
            sb.append("\">\n");
            sb.append("<input type=\"submit\" value=\"ADD\" />\n");
            sb.append("</form>\n");
            sb.append("</td>\n");

            // REMOVE button
            sb.append("<td>\n");
            sb.append("<form action=\"/?remove_id=");
            sb.append(item.getID());
            sb.append("\">\n");
            sb.append("<input type=\"submit\" value=\"REMOVE\" />\n");
            sb.append("</form>\n");
            sb.append("</td>\n");

            sb.append("</tr\n");
        }
        sb.append("</table>\n");

        return sb.toString();
    }

    private void generateItems() {
        if (availableItems.isEmpty()) {
            availableItems.add(new Item("Asus Laptop", 1600.0));
            availableItems.add(new Item("Harry Potter Ebook", 50.0));
            availableItems.add(new Item("Lego", 80.0));
        }
    }
}
