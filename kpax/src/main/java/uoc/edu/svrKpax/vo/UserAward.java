package uoc.edu.svrKpax.vo;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

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
@Table(name = "UserAward")
public class UserAward implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idUserAward;
	private int idUser;
	private int idAward;
	private int levelAward;        
     	
	public UserAward() {
	}

	public UserAward(int idUser, int idAward, int levelAward) {
		this.idUser = idUser;
		this.idAward = idAward;
		this.levelAward = levelAward;
	}

	@Id
	@GeneratedValue
	public int getIdUserAward() {
		return idUserAward;
	}

	private void setIdUserAward(int idUserAward) {
		this.idUserAward = idUserAward;
	}

	@Column(name = "idUser")
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Column(name = "idAward")
	public int getIdAward() {
		return idAward;
	}

	public void setIdAward(int idAward) {
		this.idAward = idAward;
	}
	
	@Column(name = "levelAward")
	public int getLevelAward() {
		return this.levelAward;
	}

	public void setLevelAward(int levelAward) {
		this.levelAward = levelAward;
	}
	
}
