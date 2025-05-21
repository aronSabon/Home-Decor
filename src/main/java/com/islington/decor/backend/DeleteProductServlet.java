package com.islington.decor.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.islington.decor.service.ProductService;
import com.islington.decor.serviceImpl.ProductServiceImpl;

@WebServlet("/backend/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteProductServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);

                // Assuming you have a ProductService with a deleteProductById method
                ProductService productService = new ProductServiceImpl();
                productService.deleteProductById(id);

                // Optionally, add success message or logging here
                System.out.println("Deleted product with ID: " + id);

            } catch (NumberFormatException e) {
                // Handle invalid id parameter
                e.printStackTrace();
            }
        }

        // After deletion, redirect or forward to the product list page
        response.sendRedirect(request.getContextPath() + "/backend/ProductListServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Usually delete is handled with GET or POST, here redirect POST to GET
        doGet(request, response);
    }
}
