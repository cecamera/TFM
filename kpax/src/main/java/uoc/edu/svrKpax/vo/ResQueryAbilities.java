package uoc.edu.svrKpax.vo;

import java.io.Serializable;

public class ResQueryAbilities implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int abilityId;	
	private String abilityName;
	private int abilityLevel;
	        
	public ResQueryAbilities() {
	}

	public ResQueryAbilities(int abilityId, String abilityName, int abilityLevel) {
		this.abilityId = abilityId;
		this.abilityName = abilityName;
		this.abilityLevel = abilityLevel;
	}
		
	public int getAbilityId() {
		return abilityId;
	}

	public void setAbilityId(int abilityId) {
		this.abilityId = abilityId;
	}
		
	public String getAbilityName() {
		return abilityName;
	}

	public void setAbilityName(String abilityName) {
		this.abilityName = abilityName;
	}
	
	public int getAbilityLevel() {
		return abilityLevel;
	}

	public void setAbilityLevel(int abilityLevel) {
		this.abilityLevel = abilityLevel;
	}
	
}
