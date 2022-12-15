package project.body.AppProject.choice;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RoutineService {
	private final RoutineRepository routineRepositroy;
	
	public String getRoutineName(Routine routine)
	{
		Optional<Routine> Oroutine = this.routineRepositroy.findById(routine.getRoutineNum());
		if(Oroutine.isPresent())
		{
			return Oroutine.get().getRoutineName();
		}
		return null;
	}
}
