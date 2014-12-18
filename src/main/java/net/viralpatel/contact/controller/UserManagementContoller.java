/**
 * 
 */
package net.viralpatel.contact.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.viralpatel.contact.form.User;
import net.viralpatel.contact.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Praveen Kumar
 *
 */
@Controller
public class UserManagementContoller {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String login(Map<String, Object> map) {		
		
		User user = new User();
		map.put("user", user);		
		
		return "login";
	}
	
	@RequestMapping("/login")
	public String listContacts(@ModelAttribute("user")
	User user, BindingResult bindingResult,HttpServletRequest request) {		
		String result = "redirect:/";
		boolean retVal = false;
		try{
			if(user != null){
			retVal = userService.authenticateUser(user);
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(retVal)
		{
			request.getSession().setAttribute("user", user);
			result = "redirect:/mcq";
		}
		
		return result;
	}
	
}
