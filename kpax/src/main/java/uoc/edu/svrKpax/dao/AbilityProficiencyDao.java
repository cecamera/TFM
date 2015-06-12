package uoc.edu.svrKpax.dao;

import java.util.List;

import uoc.edu.svrKpax.vo.AbilityProficiency;
import uoc.edu.svrKpax.vo.Ability;
import uoc.edu.svrKpax.vo.Proficiency;

public interface AbilityProficiencyDao {
	
	public AbilityProficiency getAbilityProficiency(String abilityName, String proficiencyName);
	public void addAbilityProficiency(AbilityProficiency objAbilityProficiency);
	public void delAbilityProficiency(AbilityProficiency objAbilityProficiency);
	public List<AbilityProficiency> getAllAbilityProficiencies();
}
