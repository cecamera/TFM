package uoc.edu.svrKpax.vo;

import java.io.Serializable;

import java.util.Date;

public class ResQueryBadges implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nameBadge;	
	private String descripBadge;
	private String imageBadge;
	private Date dateAchiev;
        
	public ResQueryBadges() {
	}

	public ResQueryBadges(String nameBadge, String descripBadge, String imageBadge, Date dateAchiev) {
		this.nameBadge = nameBadge;
		this.descripBadge = descripBadge;
		this.imageBadge = imageBadge;
		this.dateAchiev = dateAchiev;
	}
		
	public String getNameBadge() {
		return nameBadge;
	}

	public void setNameBadge(String nameBadge) {
		this.nameBadge = nameBadge;
	}
		
	public String getDescripBadge() {
		return descripBadge;
	}

	public void setDescripBadge(String descripBadge) {
		this.descripBadge = descripBadge;
	}
	
	public String getImageBadge() {
		return imageBadge;
	}

	public void setImageBadge(String imageBadge) {
		this.imageBadge = imageBadge;
	}
	
	public Date getDateAchiev() {
		return dateAchiev;
	}

	public void setDateAchiev(Date dateAchiev) {
		this.dateAchiev = dateAchiev;
	}
}
