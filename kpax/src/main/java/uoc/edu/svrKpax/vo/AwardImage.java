package uoc.edu.svrKpax.vo;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "AwardImage")
public class AwardImage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idAwardImage;	
	private int idAward;
	private int levelAward;
	private String imageAward;
        
	public AwardImage() {
	}

	public AwardImage(int idAward, int levelAward, String imageAward) {
		this.idAward = idAward;
		this.levelAward = levelAward;
		this.imageAward = imageAward;
	}
		
	@Id
	@GeneratedValue
	public int getIdAwardImage() {
		return idAwardImage;
	}

	public void setIdAwardImage(int idAwardImage) {
		this.idAwardImage = idAwardImage;
	}
	
	@Column(name = "idAward", nullable = false)
	public int getIdAward() {
		return idAward;
	}

	public void setIdAward(int idAward) {
		this.idAward = idAward;
	}
	
	@Column(name = "levelAward", nullable = false)
	public int getLevelAward() {
		return levelAward;
	}

	public void setLevelAward(int levelAward) {
		this.levelAward = levelAward;
	}
	
	@Column(name = "imageAward", nullable = false)
	public String getImageAward() {
		return imageAward;
	}

	public void setImageAward(String imageAward) {
		this.imageAward = imageAward;
	}
	
}
