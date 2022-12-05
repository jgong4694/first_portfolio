package project.body.AppProject.login;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HumanCreateForm {
	@Id
	@Size(min = 3, max = 15)
	@NotEmpty(message = "아이디는 3자 이상 15자 이하여야 합니다.")
	private String id;
		
	@NotEmpty(message = "비밀번호는 필수항목입니다.")
	private String password;
	
	@NotEmpty(message = "비밀번호 체크는 위와 같아야 합니다.")
	private String passwordCheck;
	
	@NotEmpty(message = "필수항목입니다")
	@Email(message = "이메일 형식이 아닙니다")
	private String email;
}
