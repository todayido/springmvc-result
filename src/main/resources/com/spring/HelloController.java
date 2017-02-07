package com.spring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.getWriter().print("This is my first spring mvc app...");
	}
	
	@RequestMapping("/helloRedirect")
	public void helloRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// .../webapp/index.jsp
		response.sendRedirect("index.jsp"); 
	}
	
	@RequestMapping("helloForward")
	public void helloForward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("hello", "Hello Forward...");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	@RequestMapping("spring")
	public String spring(){
		/**
		 *  forward
		 */
		// return "index.jsp";
		// return "forward:index.jsp";
		
		/**
		 * redirect
		 */
		return "redirect:index.jsp";
		
	}
	
	@RequestMapping("/spring2")
	public String sping2(){
		// 重定向
		//return "hello";
		
		// 如果使用 redirect 则不会使用视图解析器中的前缀、后缀以及路径，但是会被拦截
		//return "redirect:view/hello.jsp";
		return "redirect:hello.do";
	}
}
