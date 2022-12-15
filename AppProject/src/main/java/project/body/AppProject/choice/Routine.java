package project.body.AppProject.choice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Routine {
	@Id
	@SequenceGenerator(name="rountine_SEQ",sequenceName = "routine_SEQ" ,allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "routine_SEQ")
	@Column(length = 30)
	private Integer routineNum;
	
	@Column(length = 20)
	private String routineName; 
}
