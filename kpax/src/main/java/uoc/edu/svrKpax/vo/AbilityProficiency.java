package uoc.edu.svrKpax.vo;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "AbilityProficiency")
public class AbilityProficiency implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idAbilityProficiency;
	private int idAbility;
	private int idProficiency;        
     	
	public AbilityProficiency() {
	}

	public AbilityProficiency(int idAbility, int idProficiency) {
		this.idAbility = idAbility;
		this.idProficiency = idProficiency;
	}

	@Id
	@GeneratedValue
	public int getIdAbilityProficiency() {
		return idAbilityProficiency;
	}

	private void setIdAbilityProficiency(int idAbilityProficiency) {
		this.idAbilityProficiency = idAbilityProficiency;
	}
	
	@Column(name = "idAbility")
	public int getIdAbility() {
		return idAbility;
	}

	public void setIdAbility(int idAbility) {
		this.idAbility = idAbility;
	}
	
	@Column(name = "idProficiency", nullable = false)
	public int getIdProficiency() {
		return idProficiency;
	}

	public void setIdProficiency(int idProficiency) {
		this.idProficiency = idProficiency;
	}
	
}
