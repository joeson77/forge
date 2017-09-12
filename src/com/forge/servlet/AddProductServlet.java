package com.forge.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forge.dao.ProductDao;
import com.forge.entity.Product;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
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
		request.setCharacterEncoding("utf-8");
		double pprice = 0;
		int pcount = 0;
		String pname = request.getParameter("productname");
		String sprice = request.getParameter("productprice");
		if (sprice != null) {
			pprice = Double.parseDouble(sprice);
		}
		String scount = request.getParameter("productcount");
		if (scount != null) {
			pcount = Integer.parseInt(scount);
		}
		String imgpath = request.getParameter("productimgpath");
		ProductDao productDao = new ProductDao();
		Product products = new Product(pname,pprice,pcount,imgpath);
		boolean flag = productDao.addProduct(products);
		PrintWriter out = response.getWriter();
		out.print(flag);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
