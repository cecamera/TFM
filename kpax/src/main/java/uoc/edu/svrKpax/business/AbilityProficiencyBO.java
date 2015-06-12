package uoc.edu.svrKpax.business;

import java.util.List;

import uoc.edu.svrKpax.vo.AbilityProficiency;


public interface AbilityProficiencyBO {
	
     	public Boolean addAbilityProficiency(String abilityName, String proficiencyName, String campusSession);
     	public Boolean delAbilityProficiency(String abilityName, String proficiencyName, String campusSession);
     	public AbilityProficiency getAbilityProficiency(String abilityName, String proficiencyName, String campusSession);
	public List<AbilityProficiency> getAllAbilityProficiencies(String campusSession);

}
