package uoc.edu.svrKpax.vo;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "UserAbility")
public class UserAbility implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idUserAbility;
	private int idUser;
	private int idAbility;
	private int levelAbility;        
     	
	public UserAbility() {
	}

	public UserAbility(int idUser, int idAbility, int levelAbility) {
		this.idUser = idUser;
		this.idAbility = idAbility;
		this.levelAbility = levelAbility;
	}

	@Id
	@GeneratedValue
	public int getIdUserAbility() {
		return idUserAbility;
	}

	private void setIdUserAbility(int idUserAbility) {
		this.idUserAbility = idUserAbility;
	}

	@Column(name = "idUser")
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Column(name = "idAbility")
	public int getIdAbility() {
		return idAbility;
	}

	public void setIdAbility(int idAbility) {
		this.idAbility = idAbility;
	}
	
	@Column(name = "levelAbility", nullable = false)
	public int getLevelAbility() {
		return this.levelAbility;
	}

	public void setLevelAbility(int levelAbility) {
		this.levelAbility = levelAbility;
	}
	
}
