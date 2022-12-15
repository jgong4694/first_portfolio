package project.body.AppProject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.body.AppProject.login.Human;
import project.body.AppProject.login.HumanService;


@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {
	private HumanService humanService;
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		Human human = (Human)session.getAttribute("human");
		session.invalidate();
		
		log.info("로그아웃 진행!");
		return "main";
	}
	@GetMapping("/choice")
	public String choice() {
		return "choice/Startchoice";
	}
}
