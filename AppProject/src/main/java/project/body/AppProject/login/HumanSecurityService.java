package project.body.AppProject.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HumanSecurityService implements UserDetailsService{
	private final HumanRepository humanRepositroy;
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		Optional<Human> humans = this.humanRepositroy.findByid(id);
		if(humans.isEmpty())
		{
			throw new UsernameNotFoundException("사용자를 찾을 수 없음");
		}
		Human loginHuamn = humans.get();
		List<GrantedAuthority> authorities = new ArrayList<>();
		if("ronnie".equals(id))
		{
			authorities.add(new SimpleGrantedAuthority(HumanRole.ADMIN.getRoleHuman()));
		}
		else
		{
			authorities.add(new SimpleGrantedAuthority(HumanRole.USER.getRoleHuman()));
		}
		return new User(loginHuamn.getId(),loginHuamn.getPassword(),
				authorities);
	}
}
