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
@Table(name = "Badge")
public class Badge implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idBadge;
	private String nameBadge;
	private String descripBadge;
	private String imageBadge;
        
	public Badge() {
	}

	public Badge(String nameBadge, String descripBadge, String imageBadge) {
		this.nameBadge = nameBadge;
		this.descripBadge = descripBadge;
		this.imageBadge = imageBadge;
	}
		
	@Id
	@GeneratedValue
	public int getIdBadge() {
		return idBadge;
	}

	public void setIdBadge(int idBadge) {
		this.idBadge = idBadge;
	}
	
	@Column(name = "nameBadge", nullable = false)
	public String getNameBadge() {
		return nameBadge;
	}

	public void setNameBadge(String nameBadge) {
		this.nameBadge = nameBadge;
	}
	
	@Column(name = "descripBadge", nullable = false)
	public String getDescripBadge() {
		return descripBadge;
	}

	public void setDescripBadge(String descripBadge) {
		this.descripBadge = descripBadge;
	}

	@Column(name = "imageBadge", nullable = false)
	public String getImageBadge() {
		return imageBadge;
	}

	public void setImageBadge(String imageBadge) {
		this.imageBadge = imageBadge;
	}

}
