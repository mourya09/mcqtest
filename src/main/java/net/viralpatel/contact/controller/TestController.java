/**
 * 
 */
package net.viralpatel.contact.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.viralpatel.contact.dto.TestDTO;
import net.viralpatel.contact.form.TestHistory;
import net.viralpatel.contact.form.User;
import net.viralpatel.contact.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nex6uyu
 *
 */
@Controller
@Scope("session")
public class TestController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4033746252959626911L;
	//private Logger logger = Logger.getLogger(TestController.class);
	@Autowired
	private TestService testService;
	
	
	@RequestMapping("/takeTest")
	public String listContacts(@ModelAttribute("testDTO")
	TestDTO testDTO, BindingResult bindingResult, HttpServletRequest request) {
		//logger.info("listContacts Start ");
		String result = "redirect:/mcq";
		User user =(User) request.getSession().getAttribute("user");
		List<TestHistory> list = null;
		try{
			if(user != null){
				list = testService.createTest(user, testDTO.getTopic(), testDTO.getTestLimit());
				request.getSession().setAttribute("testList", list);
			
				request.getSession().setAttribute("topic", testDTO.getTopic());
				if(testDTO.getTestLimit() == null)
				{
					testDTO.setTestLimit(((Integer)list.size()).longValue());
				}
				request.getSession().setAttribute("testLimit", testDTO.getTestLimit());
				result = "takeTest";
			}
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}		
		
		return result;
	}
	
	@RequestMapping("/saveTest")
	public boolean saveTest(@ModelAttribute
	TestDTO testDTO, BindingResult bindingResult, HttpServletRequest request)
	{
		String result = "redirect:/mcq";
		boolean retVal = testService.saveActualTest(testDTO.getTestDTO());
		/*if(retVal)
		{
			result = "redirect:/userTestPerformance";
		}*/
		return retVal;
	}
	
}
