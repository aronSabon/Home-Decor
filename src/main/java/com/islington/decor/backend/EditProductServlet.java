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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.islington.decor.model.Product;
import com.islington.decor.service.ProductService;
import com.islington.decor.serviceImpl.ProductServiceImpl;

/**
 * Servlet implementation class EditProductServlet
 */
@MultipartConfig

@WebServlet("/backend/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		String jdbcURL = "jdbc:mysql://localhost:3306/islington-home-decor"; // change this
		String jdbcUsername = "root";
		String jdbcPassword = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT product_id, name, price, image_name FROM product WHERE product_id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setImageName(rs.getString("image_name"));
				System.out.println("product" + product);
				request.setAttribute("product", product);
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/backend/EditProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = getValueFromPart(request.getPart("name"));
		String priceStr = getValueFromPart(request.getPart("price"));
		String oldImageName = request.getParameter("oldImageName"); // get from hidden field
		Part filePart = request.getPart("image");

		int price = 0;
		try {
			price = Integer.parseInt(priceStr);
		} catch (NumberFormatException e) {
			request.setAttribute("error", "Price must be a valid number.");
			request.getRequestDispatcher("/backend/EditProduct.jsp").forward(request, response);
			return;
		}
System.out.println(name+"name");
		String imageName = oldImageName; // default
		String newImageFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

		if (newImageFileName != null && !newImageFileName.isBlank()) {
			// New image uploaded
			imageName = newImageFileName;

			String fullClassPath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
			File currentPath = new File(fullClassPath);
			File projectRoot = currentPath.getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getParentFile(); // Adjust depth as needed
			String projectName = projectRoot.getName();
			String lemonPath = projectRoot.getAbsolutePath() + File.separator + projectName + File.separator + "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "static" + File.separator + "images";

			File uploadDir = new File(lemonPath);
			if (!uploadDir.exists()) uploadDir.mkdirs();

			filePart.write(lemonPath + File.separator + imageName);
			System.out.println("New image saved at: " + lemonPath + File.separator + imageName);
		} else {
			System.out.println("No new image uploaded. Keeping old image: " + imageName);
		}

		// Save updated product
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setImageName(imageName);

		// Add product.setId(...) if you're updating an existing product (get from form)
		String idStr = request.getParameter("productId");
		System.out.println(idStr +"id");
		if (idStr != null && !idStr.isBlank()) {
			product.setProductId(Integer.parseInt(idStr));
		}

		ProductService productService = new ProductServiceImpl();
		productService.updateProduct(product); // Use update method instead of add

		request.setAttribute("success", "Product updated successfully!");
		request.getRequestDispatcher("/backend/ProductListServlet").forward(request, response);
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
