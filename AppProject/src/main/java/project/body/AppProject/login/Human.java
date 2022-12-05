package project.body.AppProject.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Human {
	@Id
	@Column(length = 25)
	private String id;
	
	@Column(length=200)
	private String password;
	
	@Column(length=320, unique = true)
	private String email;
	
}
