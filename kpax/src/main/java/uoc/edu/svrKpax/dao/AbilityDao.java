package uoc.edu.svrKpax.dao;

import java.util.List;

import uoc.edu.svrKpax.vo.Ability;

public interface AbilityDao {
	
	public Ability getAbility(String nameAbility);
	public Ability getAbilityById(int idAbility);
	public void addAbility(Ability objAbility);
	public void delAbility(Ability objAbility);
	public List<Ability> getAllAbilities();

}
