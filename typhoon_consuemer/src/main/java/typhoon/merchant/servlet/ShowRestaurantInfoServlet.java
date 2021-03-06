package typhoon.merchant.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import typhoon.merchant.pojo.RegisterInfo;
import typhoon.merchant.pojo.Resturant;
import typhoon.merchant.pojo.User;
import typhoon.merchant.service.RegisterInfoService;
import typhoon.merchant.service.impl.RegisterInfoServiceImpl;
import typhoon.merchant.util.JsonParse;
import typhoon.merchant.util.JsonParseByJackson;

/**
 * Servlet implementation class ShowRestaurantInfoServlet
 */
public class ShowRestaurantInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegisterInfoService registerInfoService = RegisterInfoServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("------------------------ShowRestaurantInfoServlet------------------------------");
		User user = (User) request.getSession().getAttribute("user");

		RegisterInfo registerInfo = registerInfoService.findRegisterInfoByShopId(user.getShopId());
		request.setAttribute("registerInfo", registerInfo);
		
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -10);
		PrintWriter out=response.getWriter();
		JsonParse<Resturant> jsonUtil=new JsonParseByJackson<>();
		String jsonData = jsonUtil.parseObjectToJson(registerInfo);
	//	System.out.println(jsonData);
		out.print(jsonData);
		out.flush();
		//request.getRequestDispatcher("showRegisterInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
