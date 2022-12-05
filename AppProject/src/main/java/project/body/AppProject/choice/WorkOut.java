package project.body.AppProject.choice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class WorkOut {
	@SequenceGenerator(name = "workNum_SEQ", sequenceName = "workOut_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workNum_SEQ")
	@Id
	@Column(length = 3)
	public Integer workOutNum;
	@Column(length = 30)
	public String workOutName;
	@Column(length = 20)
	public String muscle;
	@Column(length = 200)
	public String workOutContent;
}
