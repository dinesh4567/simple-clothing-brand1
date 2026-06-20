package com.example.controller;

import com.example.model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a list of products (in a real app, this would come from a database)
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Classic T-Shirt", "A timeless classic made of 100% cotton.", 24.99, "https://via.placeholder.com/300"));
        products.add(new Product(2, "Denim Jacket", "Durable and stylish denim jacket.", 89.99, "https://via.placeholder.com/300"));
        products.add(new Product(3, "Running Shoes", "Lightweight and comfortable running shoes.", 119.99, "https://via.placeholder.com/300"));
        products.add(new Product(4, "Wool Sweater", "Warm and cozy wool sweater for chilly days.", 55.00, "https://via.placeholder.com/300"));

        // Add the product list to the request object
        request.setAttribute("products", products);

        // Forward the request to the JSP page for display
        request.getRequestDispatcher("/products.jsp").forward(request, response);
    }
}
