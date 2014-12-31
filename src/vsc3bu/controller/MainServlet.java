package vsc3bu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// サーブレット・コンテキストの取得
		ServletContext cont = getServletContext();
		// JSP のディスパッチャを取得
		RequestDispatcher reqJSP = cont.getRequestDispatcher("/WEB-INF/jsp/Hello.jsp");
		// ディスパッチャの forward メソッドを利用
		reqJSP.forward(request, response);
		
		
	
	}

}
