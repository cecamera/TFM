package uoc.edu.svrKpax.business;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Date;

import uoc.edu.svrKpax.vo.Proficiency;


public interface ProficiencyBO {
	
	public Boolean addProficiency(String nameProficiency, String campusSession);
     	public Boolean delProficiency(String nameProficiency, String campusSession);
	public Proficiency getProficiency(String nameProficiency, String campusSession);
     	public List<Proficiency> getAllProficiencies(String campusSession);

}
