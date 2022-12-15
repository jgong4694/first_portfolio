package project.body.AppProject.controller;

import java.security.Principal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.body.AppProject.Mypage.MyChoice;
import project.body.AppProject.Mypage.MyChoiceService;
import project.body.AppProject.choice.RoutineService;

@Slf4j
@RequestMapping("/myChoice")
@RequiredArgsConstructor
@Controller
public class MyChoiceController {
	private final MyChoiceService myChoiceService;
	
	private final RoutineService routineService;
	
	@GetMapping
	public String myChoice(Model model, Principal principal) {
		MyChoice myChoice = myChoiceService.getMyChoice(principal.getName());
		String RoutineName = routineService.getRoutineName(myChoice.getRoutine());
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("start",format.format(myChoice.getStartDate()));
		model.addAttribute("end",format.format(myChoice.getEndDate()));
		model.addAttribute("routine",RoutineName);
		model.addAttribute("MyChoice",myChoice);
		return "/myChoice";
	}
}
