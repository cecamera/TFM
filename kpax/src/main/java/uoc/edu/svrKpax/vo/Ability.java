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
@Table(name = "Ability")
public class Ability implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idAbility;
	private String nameAbility;
	        
	public Ability() {
	}

	public Ability(String nameAbility) {
		this.nameAbility = nameAbility;
	}
		
	@Id
	@GeneratedValue
	public int getIdAbility() {
		return idAbility;
	}

	public void setIdAbility(int idAbility) {
		this.idAbility = idAbility;
	}
	
	@Column(name = "nameAbility", nullable = false)
	public String getNameAbility() {
		return nameAbility;
	}

	public void setNameAbility(String nameAbility) {
		this.nameAbility = nameAbility;
	}

}
