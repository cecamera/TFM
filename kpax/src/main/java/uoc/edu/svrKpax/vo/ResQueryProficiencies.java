package uoc.edu.svrKpax.vo;

import java.io.Serializable;

public class ResQueryProficiencies implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nameProficiency;	
	private int levelAward;
	private String imageAward;
        
	public ResQueryProficiencies() {
	}

	public ResQueryProficiencies(String nameProficiency, int levelAward, String imageAward) {
		this.nameProficiency = nameProficiency;
		this.levelAward = levelAward;
		this.imageAward = imageAward;
	}
		
	public String getNameProficiency() {
		return nameProficiency;
	}

	public void setNameProficiency(String nameProficiency) {
		this.nameProficiency = nameProficiency;
	}
		
	public int getLevelAward() {
		return levelAward;
	}

	public void setLevelAward(int levelAward) {
		this.levelAward = levelAward;
	}
	
	public String getImageAward() {
		return imageAward;
	}

	public void setImageAward(String imageAward) {
		this.imageAward = imageAward;
	}
	
}
