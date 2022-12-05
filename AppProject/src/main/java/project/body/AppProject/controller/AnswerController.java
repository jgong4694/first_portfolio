package project.body.AppProject.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.body.AppProject.board.Answer;
import project.body.AppProject.board.AnswerService;
import project.body.AppProject.board.Question;
import project.body.AppProject.board.QuestionService;

@Slf4j
@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {
	
	@Autowired
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	
	@PostMapping("/create/{questionNum}")
	public String createAnswer(Model model, @PathVariable("questionNum") Integer questionNum, @RequestParam String content, Principal principal) {		
		Question question = this.questionService.GetQuestion(questionNum);
		answerService.create(question, content, principal);
		return String.format("redirect:/board/boardInside/%s", questionNum);
	}
}
