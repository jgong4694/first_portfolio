package project.body.AppProject.login; 

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HumanService {
	
	private final HumanRepository humanRepository;
	private final PasswordEncoder encoder;
	
	public Human create(String id, String password, String email)
	{
		Human human = new Human();
		human.setId(id);
		human.setPassword(encoder.encode(password));
		human.setEmail(email);
		humanRepository.save(human);
		return human;
	}
	public Human getHuman(String id)
	{
		Optional<Human> OHuman = this.humanRepository.findByid(id);
		if(OHuman.isPresent())
		{
			Human human = OHuman.get();
			return human;
		}
		return null;
	}
	
	public void regHuman(Human human)
	{
		humanRepository.save(human);
	}
	
}
