 package project.body.AppProject.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.body.AppProject.login.Human;
import project.body.AppProject.login.HumanCreateForm;
import project.body.AppProject.login.HumanDto;
import project.body.AppProject.login.HumanService;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/login")
public class LoginController {
	private final HumanService humanService;
	
	@GetMapping
	public String login(HumanDto Dto) {
		log.info("로그인폼으로 갑니다!");
		return "login/loginForm";
		
	}
	@PostMapping
	public String login(HumanDto Dto, HttpSession session)
	{
		log.info("들어오긴 했습니다");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Human human = humanService.getHuman(Dto.getId());
		if(human == null)
		{
			log.info("로그인 실패, 아이디를 찾을 수 없음");
			return "login/Error";
		}
		else if(encoder.matches(Dto.getId(), Dto.getPassword()) == true)
		{
			session.setAttribute("human", human);
			log.info("로그인 성공, 아이디와 비밀번호가 일치");
			return "main";
		}
		log.info("로그인 실패, 패스워드가 틀렸음");
		return "login/Error";
	}
	//login/nseruser로 오면 템플릿 newuser를 찾아간다.
	@GetMapping("/newuser")
	public String newuser(HumanCreateForm humanCreateForm) {
		return "login/newuser";
	}
	//login/newuser로 값을 들고 오면 valid와 들어온 데이터로 검증하고, 맞다면 humanCreateform에 넣어서 저장하고 메인으로 돌아간다
	@PostMapping("/newuser")
	public String newuser(@Valid HumanCreateForm humanCreateForm,
			BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			log.info("에러에 걸려서 리다이렉트 시켰습니다");
			return "login/newuser";
		}
		else if(!humanCreateForm.getPassword().equals(humanCreateForm.getPasswordCheck()))
		{
			bindingResult.rejectValue("PasswordCheck", "passwordCheckError","두개의 패스워드가 일치하지 않습니다");
			log.info("비밀번호가 일치하지 않습니다");
			return "login/newuser";
		}
		else{
			try {
			humanService.create(
				humanCreateForm.getId(),
				humanCreateForm.getPassword(), 
				humanCreateForm.getEmail());
			} catch(DataIntegrityViolationException e)
			{
				e.printStackTrace();
				bindingResult.reject("회원가입 실패", "이미 등록된 사용자입니다");
				return "login/newuser";
			}
			catch(Exception e)
			{
				e.printStackTrace();
				bindingResult.reject("회원가입 실패",e.getMessage());
				return "login/newuser";
			}
		return "login/complete";
		}
	}
}
