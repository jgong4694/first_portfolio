package project.body.AppProject.board;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.body.AppProject.DataNotFoundException;
import project.body.AppProject.login.Human;


@Slf4j
@RequiredArgsConstructor
@Service
public class AnswerService {
	
	@Autowired
	private final AnswerRepository answerRepository;
	
	public void create(Question question, String content, Principal principal)
	{
		Answer answer = new Answer();
		Human human = new Human();
		human.setId(principal.getName());
		answer.setContent(content);
		answer.setAnswerTime(LocalDateTime.now());
		answer.setQuestion(question);
		answer.setHuman(human);
		this.answerRepository.save(answer);
		log.info("앤서 저장");
	}
	public List<Answer> getList(){
		return this.answerRepository.findAll();
	}
}