package uoc.edu.svrKpax.business;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Date;

import uoc.edu.svrKpax.vo.Ability;


public interface AbilityBO {
	
	public Boolean addAbility(String nameAbility, String campusSession);
     	public Boolean delAbility(String nameAbility, String campusSession);
	public Ability getAbility(String nameAbility, String campusSession);
     	public List<Ability> getAllAbilities(String campusSession);

}
