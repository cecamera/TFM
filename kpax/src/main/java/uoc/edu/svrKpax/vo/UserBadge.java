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
@Table(name = "UserBadge")
public class UserBadge implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idUserBadge;
	private int idUser;
	private int idBadge;
	private int idDate;        
     	private Date dateAchiev;

	public UserBadge() {
	}

	public UserBadge(int idUser, int idBadge, Date dateAchiev) {
		this.idUser = idUser;
		this.idBadge = idBadge;
		this.dateAchiev = dateAchiev;
	}

	@Id
	@GeneratedValue
	public int getIdUserBadge() {
		return idUserBadge;
	}

	private void setIdUserBadge(int idUserBadge) {
		this.idUserBadge = idUserBadge;
	}

	@Column(name = "idUser")
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Column(name = "idBadge")
	public int getIdBadge() {
		return idBadge;
	}

	public void setIdBadge(int idBadge) {
		this.idBadge = idBadge;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dateAchiev", nullable =false,length = 10)
	public Date getDateAchiev() {
		return this.dateAchiev;
	}

	public void setDateAchiev(Date dateAchiev) {
		this.dateAchiev = dateAchiev;
	}
	
}
