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
@Table(name = "Award")
public class Award implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idAward;
	private int idProficiency;
	private int maxLevel;
	private int idGame;
	private String descripAward;
        
	public Award() {
	}

	public Award(int idProficiency, int maxLevel, int idGame, String descripAward) {
		this.idProficiency = idProficiency;
		this.maxLevel = maxLevel;
		this.idGame = idGame;
		this.descripAward = descripAward;
	}
		
	@Id
	@GeneratedValue
	public int getIdAward() {
		return idAward;
	}

	public void setIdAward(int idAward) {
		this.idAward = idAward;
	}
	
	@Column(name = "idProficiency", nullable = false)
	public int getIdProficiency() {
		return idProficiency;
	}

	public void setIdProficiency(int idProficiency) {
		this.idProficiency = idProficiency;
	}
	
	@Column(name = "maxLevel", nullable = false)
	public int getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}
	
	@Column(name = "idGame", nullable = false)
	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}
	
	@Column(name = "descripAward", nullable = false)
	public String getDescripAward() {
		return descripAward;
	}

	public void setDescripAward(String descripAward) {
		this.descripAward = descripAward;
	}
	
}
