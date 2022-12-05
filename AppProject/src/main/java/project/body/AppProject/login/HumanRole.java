package project.body.AppProject.login;

import lombok.Getter;

@Getter
public enum HumanRole {
	ADMIN("ADMIN"),
	USER("USER");
	
	HumanRole(String value)
	{
		this.roleHuman = value;
	}
	private String roleHuman;
}
