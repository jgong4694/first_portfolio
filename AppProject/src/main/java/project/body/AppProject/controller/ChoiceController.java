package project.body.AppProject.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;
import project.body.AppProject.choice.RoutineService;
import project.body.AppProject.choice.WorkoutService;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/choice")
public class ChoiceController {
	
	private final WorkoutService workOutService;
	private final RoutineService routineService;
	
	@GetMapping("/choice")
	public String choice() {
		return "choice/Startchoice";
	}
	@GetMapping("/choiceDate") 
	public String ChoiceDate(Model model, String value) throws Exception  {
		log.info(value);
		model.addAttribute("value",value);
		return "choice/choiceDate";
	}
}
