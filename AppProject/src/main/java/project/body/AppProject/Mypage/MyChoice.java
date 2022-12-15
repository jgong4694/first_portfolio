package project.body.AppProject.Mypage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import project.body.AppProject.choice.Routine;
import project.body.AppProject.login.Human;

@Getter
@Setter
@ToString
@Entity
public class MyChoice {
	@Id
	@Column(length = 25)
	private String id;
	
	@OneToOne
	@MapsId
	@JoinColumn
	Human human;
	
	@OneToOne
	Routine routine;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date StartDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date EndDate;
}
