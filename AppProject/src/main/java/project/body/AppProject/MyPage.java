package project.body.AppProject;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import project.body.AppProject.login.Human;

@Data
@Entity
public class MyPage {
	@Id
	@SequenceGenerator(name="routine_seq", sequenceName="MyPage_SEQ",initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "MyPage_SEQ")
	private String routineNum;
	
	@Column(length = 30)
	private String routine;
	
	private Date startDate;
	
	private Date endDate;
	
	@JoinColumn
	@ManyToOne
	private Human human;
}

