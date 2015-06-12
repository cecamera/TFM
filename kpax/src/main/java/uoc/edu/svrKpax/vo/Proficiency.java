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
import javax.persistence.ManyToOne;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "Proficiency")
public class Proficiency implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idProficiency;
	private String nameProficiency;
	        
	public Proficiency() {
	}

	public Proficiency(String nameProficiency) {
		this.nameProficiency = nameProficiency;
	}
		
	@Id
	@GeneratedValue
	public int getIdProficiency() {
		return idProficiency;
	}

	public void setIdProficiency(int idProficiency) {
		this.idProficiency = idProficiency;
	}
	
	@Column(name = "nameProficiency", nullable = false)
	public String getNameProficiency() {
		return nameProficiency;
	}

	public void setNameProficiency(String nameProficiency) {
		this.nameProficiency = nameProficiency;
	}
	
}
