package project.body.AppProject.Mypage;

import java.security.Principal;
import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;

import javax.transaction.Transactional;

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
		Calendar cal = Calendar.getInstance();
		Human human = humanService.getHuman(principal.getName());
		
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
		if(getMyChoice(human.getId()) == null) {
			myChoice.setId(human.getId());
			myChoice.setHuman(human);
			myChoice.setStartDate(StartDate);
			myChoice.setRoutine(routine);
			myChoice.setEndDate(cal.getTime());
			myChoiceRepository.save(myChoice);
		}
		else
		{
			MyChoice changeChoice = myChoiceRepository.getById(human.getId());
			changeChoice.setRoutine(routine);
			changeChoice.setStartDate(StartDate);
			changeChoice.setEndDate(cal.getTime());
			myChoiceRepository.save(changeChoice);
		}
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
	public MyChoice DeleteChoice(String id, Routine routine, Date start, Date end,Integer num)
	{
		Optional<MyChoice> OChoice = this.myChoiceRepository.findById(id);
		MyChoice myChoice = OChoice.get();
		myChoice.routine.setRoutineNum(num);
		myChoice.setStartDate(start);
		myChoice.setEndDate(end);
		return myChoice;
	}
	
}
