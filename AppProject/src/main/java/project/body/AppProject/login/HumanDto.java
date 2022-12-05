package project.body.AppProject.login;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HumanDto {
	private String id;
	private String password;
	
	@Builder
	public HumanDto(String id, String password)
	{
		this.id = id;
		this.password = password;
	}
}
