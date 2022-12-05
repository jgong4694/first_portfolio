package project.body.AppProject.choice;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Routine {
	@Id
	@Column(length = 30)
	private String routine;
	
	private Date routineProgress;
	@Column(length = 5)
	private Integer cycle; 
	
	@ManyToOne
	@JoinColumn
	WorkOut workOut;
}
