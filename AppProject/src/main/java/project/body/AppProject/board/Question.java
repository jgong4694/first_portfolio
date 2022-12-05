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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import org.springframework.data.annotation.CreatedDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import project.body.AppProject.login.Human;

@Getter
@Setter
@ToString
@Entity
public class Question {
	@SequenceGenerator(name="question_SEQ",sequenceName = "question_SEQ" ,allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_SEQ")
	@Id
	@Column(length = 100)
	private Integer questionNum;

	@JoinColumn
	@ManyToOne(cascade = CascadeType.REMOVE)
 	private Human human;
	
	@Column(length = 30)
	private String title;
	
	@Column(length = 500)
	private String content;

	@CreatedDate
	private LocalDateTime questionTime;
	
}
