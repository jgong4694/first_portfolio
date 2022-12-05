package project.body.AppProject.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.body.AppProject.board.Answer;
import project.body.AppProject.board.AnswerService;
import project.body.AppProject.board.BoardInput;
import project.body.AppProject.board.Question;
import project.body.AppProject.board.QuestionService;
import project.body.AppProject.login.Human;



@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	@GetMapping
	public String board(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
		Page<Question> paging = this.questionService.getList(page);
		model.addAttribute("paging", paging);
		return "board/board";
	}
	
	@GetMapping("/boardAdd")
	public String BoardAdd(Model model, Principal principal) {
		model.addAttribute("id",principal.getName());
		return "board/board_add";	
	}

	@PostMapping("/boardAdd")
	public String BoardAdd(@Valid BoardInput input, Principal principal, Question question)
	{
		log.info("boardAdd 포스트로 진입");
		Human human = new Human();
		human.setId(principal.getName());
		questionService.create(human,question.getTitle(), question.getContent());
		return "redirect:/board";
	}
	@GetMapping("/boardInside/{questionNum}")
	public String BoardInside(@PathVariable("questionNum")Integer questionNum, Model model)
	{
		Question question = this.questionService.GetQuestion(questionNum);
		model.addAttribute("question",question);
		
		List<Answer> answer = this.answerService.getList();
		int i = 0;
		List<Answer> answer2 = new ArrayList<>();
		for (Answer answerText : answer) 
		{
			Integer a = answerText.getQuestion().getQuestionNum();
			if(a == questionNum)
			{
				answer2.add(answerText);
			}
			i++;
		}
		model.addAttribute("Answer",answer2);
		return "board/boardInside";
	}
	
}
