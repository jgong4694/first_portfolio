package project.body.AppProject.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	Page<Question> findAll(Pageable pageable);
	Optional<Question> findByQuestionNum(Integer questuonNum);
}
