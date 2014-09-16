package com.kkt.www.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kkt.www.dao.SampleDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SampleDAO sampleDAO;	
	
	@Value("#{config['env']}")
	String env = "";
	
	
//	@Autowired
//	protected SessionRegistry sessionRegistry;
	 	
	
	
	// test
	// test2
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("env", env + "-aabbccgjfjffjh" );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getList(
			final HttpServletRequest request
			) throws Exception {
		final Map<String, Object> result = new HashMap<String, Object>();
		
		final Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("cnt", 2);
		parameter.put("user_id", "%a%");
		
		List list = sampleDAO.selectSampleList(parameter);
		
		
		result.put("row", list);
		return result; 
	}	
	
	@RequestMapping(value = "/ttt", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> ttt(
			final HttpServletRequest request
			) throws Exception {
		System.out.println("ttt");
		final Map<String, Object> result = new HashMap<String, Object>();
//		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		ConfigurableApplicationContext ctx = (ConfigurableApplicationContext)WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		ctx.refresh();
//		ConfigurableApplicationContext cac = (ConfigurableApplicationContext )ctx;
//		cac.refresh();
		//SqlSessionTemplate t = (SqlSessionTemplate)ctx.getBean("sqlSession");
		
		
		return result; 
	}	

	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(HttpSession session) {
		logger.info("Welcome login! {}", session.getId());
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public void logout(HttpSession session) {
		UserVO userDetails = (UserVO)session.getAttribute("userLoginInfo");
		if(userDetails != null){
			logger.info("Welcome logout! {}, {}", session.getId(), userDetails.getUsername());
		}
		
		
		session.invalidate();
	}
	
	@RequestMapping(value = "login_success", method = RequestMethod.GET)
	public void login_success(HttpSession session) {
		UserVO userDetails = (UserVO)SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		logger.info("Welcome login_success! {}, {}", session.getId(), userDetails.getUsername() + "/" + userDetails.getPassword());
		session.setAttribute("userLoginInfo", userDetails);
	}
	
	@RequestMapping(value = "page1", method = RequestMethod.GET)
	public void page1() {		
	}

	@RequestMapping(value = "loginProcess", method = RequestMethod.POST)
	public void loginProcess(HttpSession session, final HttpServletRequest request) {
//		UserVO userDetails = (UserVO)SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		String id = (String)request.getParameter("id");
		String pw = (String)request.getParameter("pw");
		UserVO userDetails = new UserVO(id, pw);
		logger.info("Welcome login_success! {}, {}", session.getId(), userDetails.getUsername() + "/" + userDetails.getPassword());
		session.setAttribute("userLoginInfo", userDetails);
		
		
//        List<Object> infos=sessionRegistry.getAllPrincipals();
//        System.out.println(infos.toString());
//        System.out.println("hi");
//        
//        
//        List<SessionInformation> aa = sessionRegistry.getAllSessions("userLoginInfo", false);
//		System.out.println(aa.size());
		
//		List<SessionInformation> sessions = sessionRegistry.getAllSessions("", false);
//		for (SessionInformation s : sessions) {
//			System.out.println(s.getSessionId());
//		}
		
		
		
	}
	
	@RequestMapping(value = "login_duplicate", method = RequestMethod.GET)
	public void login_duplicate() {		
		logger.info("Welcome login_duplicate!");
	}
		
	
	
	
	
	
	
	
	
}
