package project.body.AppProject.Mypage;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.body.AppProject.login.Human;

@Repository
public interface MyChoiceRepository extends JpaRepository<MyChoice, String> {
	Optional<MyChoice> findById(String human_id);
}
