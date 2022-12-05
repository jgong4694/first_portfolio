package project.body.AppProject.board;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import project.body.AppProject.login.Human;

@Getter
@Setter
@ToString
@Entity
public class Answer {
	@SequenceGenerator(name="answer_SEQ", sequenceName = "answer_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="MEMBER_SEQ_GENERATOR")
	@Id
	@Column(length = 100)
	private Integer AnswerNum;

	@JoinColumn
	@ManyToOne(targetEntity = Question.class)
	private Question question;
	
	@JoinColumn
	@ManyToOne(targetEntity = Human.class, cascade = CascadeType.REMOVE)
	private Human human;
	
	@Column(length = 100)
	private String content;
	
	@CreatedDate
	private LocalDateTime AnswerTime;
	
}
