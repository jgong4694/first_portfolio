package project.body.AppProject.controller;

import java.security.Principal;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.body.AppProject.Mypage.MyChoiceService;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/choice")
public class ChoiceController {
	
	@Autowired
	private final MyChoiceService myChoiceService;
	
	@GetMapping("/choice")
	public String choice() {
		return "choice/Startchoice";
	}
	@GetMapping("/choiceDate") 
	public String ChoiceDate(Model model, String value) throws Exception  {
		model.addAttribute("value",value);
		return "choice/choiceDate";
	}
	@PostMapping("/endChoice")
	public String endChoice(Model model, Principal principal, String value, Date date)
	{
		model.addAttribute("id",principal.getName());
		model.addAttribute("workNum",value);
		model.addAttribute("workDate",date);
		return "choice/endChoice";
	}	
	
//	@PostMapping("/endChoice/complete")
//	public String complete(Principal principal, Date StartDate, String routineNum) throws Exception
//	{
//		myChoiceService.create(principal, StartDate, routineNum);
//		return "redirect:/";
//	}
}
