package com.islington.decor.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

import com.islington.decor.model.Customer;
import com.islington.decor.model.Product;
import com.islington.decor.service.CustomerService;
import com.islington.decor.service.ProductService;
import com.islington.decor.serviceImpl.CustomerServiceImpl;
import com.islington.decor.serviceImpl.ProductServiceImpl;

/**
 * Servlet implementation class AddProductServlet
 */
@MultipartConfig
@WebServlet("/backend/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("getcallr");
        request.getRequestDispatcher("/backend/AddProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    System.out.println("post called");

	    // Instead of request.getParameter(), use getPart() and read strings for text fields
	    Part namePart = request.getPart("name");
	    Part pricePart = request.getPart("price");
	    Part filePart = request.getPart("image");

	    String name = getValueFromPart(namePart);
	    String priceStr = getValueFromPart(pricePart);

	    System.out.println("Name: " + name);
	    System.out.println("Price string: " + priceStr);

	    int price = 0;
	    try {
	        price = Integer.parseInt(priceStr);
	        System.out.println("Price: " + price);
	    } catch (NumberFormatException e) {
	        request.setAttribute("error", "Price must be a valid number.");
	        request.getRequestDispatcher("/backend/AddProduct.jsp").forward(request, response);
	        return;
	    }

	    String imageName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
	    String uploadPath = getServletContext().getRealPath("/static/images");
	    System.out.println("Upload path: " + uploadPath);

	    File uploadDir = new File(uploadPath);
	    if (!uploadDir.exists()) {
	        uploadDir.mkdirs();
	    }

	    filePart.write(uploadPath + File.separator + imageName);

	    Product product = new Product();
	    product.setName(name);
	    product.setPrice(price);
	    product.setImageName(imageName);

	    ProductService productService = new ProductServiceImpl();
	    productService.addProduct(product);

	    System.out.println("Product added: " + product);

	    request.setAttribute("success", "Product added successfully!");
	    request.getRequestDispatcher("/backend/AddProduct.jsp").forward(request, response);
	}

	// Add this helper method inside your servlet class
	private String getValueFromPart(Part part) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
	    StringBuilder value = new StringBuilder();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        value.append(line);
	    }
	    return value.toString();
	}



}
