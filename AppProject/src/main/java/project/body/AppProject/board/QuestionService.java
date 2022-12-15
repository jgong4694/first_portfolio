package project.body.AppProject.board;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.body.AppProject.DataNotFoundException;
import project.body.AppProject.login.Human;

@Slf4j
@RequiredArgsConstructor
@Service
public class QuestionService {
	@Autowired
	private final QuestionRepository questionRepository;
	
	public List<Question> getList(){
		return this.questionRepository.findAll();
	}

	public void create(Human human, String title, String content) {
		Question q = new Question();
		q.setHuman(human);
		q.setTitle(title);
		q.setContent(content);
		q.setQuestionTime(LocalDateTime.now());
		questionRepository.save(q);
	}
	public Question GetQuestion(Integer questionNum) {
		Optional<Question> question = this.questionRepository.findByQuestionNum(questionNum);
		if(question.isPresent())
		{
			return question.get();
		}
		else {
			throw new DataNotFoundException("찾을 수 없음");
		}
	}
	
	public Page<Question> getList(int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("questionTime"));
		Pageable pageble = PageRequest.of(page,10,Sort.by(sorts));
		return this.questionRepository.findAll(pageble);
	}
}
