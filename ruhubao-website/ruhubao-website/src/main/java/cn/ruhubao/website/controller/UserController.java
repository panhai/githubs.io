package cn.ruhubao.website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/login")
	public String login(String username, String password,HttpServletRequest request,HttpServletResponse response) {
		
		if ("123".equals(username) && "123".equals(password)) {
			request.getSession().setAttribute("user", username);
			
			System.out.println("执行登录操作");
			
		} else {
			return "login";
		}
		// .不加斜杠，相对路径（http://127.0.0.1:8080/springmvc/user/+目标url）
		
		// .加上斜杠，绝对路径（http://127.0.0.1:8080/springmvc/+目标url）

		//返回到 /views/indew.jsp
		//return"redirect:/index";
		return"/index";

	}

}
