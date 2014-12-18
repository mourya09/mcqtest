/**
 * 
 */
package net.viralpatel.contact.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.viralpatel.contact.dto.TestDTO;
import net.viralpatel.contact.form.MCQ;
import net.viralpatel.contact.service.MCQService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

/**
 * @author Praveen Kumar
 *
 */

@Controller
@Scope("session")
public class MCQController {

	@Autowired
	private MCQService mcqService;
	
	@RequestMapping("/mcq")
	public String listContacts(Map<String, Object> map,HttpServletRequest request) {		
		map.put("mcq", new MCQ());
		List<MCQ> list = mcqService.listMCQs();
		map.put("mcqList", list);
		Gson gson = new Gson();
		String str = gson.toJson(list, List.class);
				map.put("jsonList", str);
		TestDTO testDTO = new TestDTO();
		map.put("testDTO", testDTO);
		
		return "AddMCQ";
	}
	
	@RequestMapping(value = "/addMCQ", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("mcq")
	MCQ mcq, BindingResult result) {
		mcqService.addMCQ(mcq);		

		return "redirect:/mcq";
	}
	
	@RequestMapping("/deletemcq/{mcq}")
	public String deleteContact(@PathVariable("mcq")
	Integer mcqId) {
		mcqService.removeMCQ(mcqId);		

		return "redirect:/mcq";
	}

}
