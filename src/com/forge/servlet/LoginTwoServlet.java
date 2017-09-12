package com.forge.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forge.dao.UserDao;
import com.forge.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginTwoServlet")
public class LoginTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginTwoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获得表单提交的数据
				request.setCharacterEncoding("utf-8");
				String name = request.getParameter("username");
				String password = request.getParameter("password");
				//2、封装对象
				User user=new User();
				user.setUname(name);
				user.setUpassword(password);
				//3、调用Dao执行数据库操作
				UserDao userDao = new UserDao();
				boolean ret = userDao.checkUser(user);
				//4、根据数据库操作返回的结果，封装数据&页面跳转
				PrintWriter out = response.getWriter();
				if (ret == true) {
					request.getSession().setAttribute("customer", name);
					out.print(ret);
					out.print(name);
				} else {
					out.print(ret);
				}
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
