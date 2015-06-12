package uoc.edu.svrKpax.dao;

import java.util.List;

import uoc.edu.svrKpax.vo.Proficiency;

public interface ProficiencyDao {
	
	public Proficiency getProficiency(String nameProficiency);
	public Proficiency getProficiencyById(int idProficiency);
	public void addProficiency(Proficiency objProficiency);
	public void delProficiency(Proficiency objProficiency);
	public List<Proficiency> getAllProficiencies();

}
