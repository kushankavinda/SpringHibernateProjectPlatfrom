package controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Attendance_table;

@Controller
public class BaseController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", --counter);
		logger.debug("[welcome] counter : {}", counter);
		
		Attendance_table at =new Attendance_table();
		at.setEmployee_name("a");
		System.out.print(at.getEmployee_name());
		Create_table.create_table();
		String a=Retrive.retrive();
		
		model.addAttribute("employee_name", a);
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

}