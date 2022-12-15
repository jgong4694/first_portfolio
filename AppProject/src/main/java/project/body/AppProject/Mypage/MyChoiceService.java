package project.body.AppProject.Mypage;

import java.security.Principal;
import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import project.body.AppProject.choice.Routine;
import project.body.AppProject.login.Human;
import project.body.AppProject.login.HumanService;


@Slf4j
@RequiredArgsConstructor
@Service
public class MyChoiceService {
	private final MyChoiceRepository myChoiceRepository;
	
	private final HumanService humanService;
	
	public void create(Principal principal, Date StartDate, String routineNum) throws Exception
	{
		MyChoice myChoice = new MyChoice();
		Routine routine = new Routine();
		Human human = humanService.getHuman(principal.getName());
		Calendar cal = Calendar.getInstance();
		routine.setRoutineNum(Integer.parseInt(routineNum)); 
		
		cal.setTime(StartDate);
		if(routineNum == "1")
		{
			cal.add(Calendar.MONTH, +3);
		}
		else
		{
			cal.add(Calendar.MONTH, +6);
		}
		log.info(cal.getTime().toString());
		myChoice.setId(human.getId());
		myChoice.setHuman(human);
		myChoice.setStartDate(StartDate);
		myChoice.setRoutine(routine);
		myChoice.setEndDate(cal.getTime());
		myChoiceRepository.save(myChoice);
	}
	
	public MyChoice getMyChoice(String id)
	{
		
		Optional<MyChoice> OChoice = this.myChoiceRepository.findById(id);
		if(OChoice.isPresent())
		{
			return OChoice.get();
		}
		return null;
	}
	
}
