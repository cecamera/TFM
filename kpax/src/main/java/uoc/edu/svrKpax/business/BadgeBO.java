package uoc.edu.svrKpax.business;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Date;

import uoc.edu.svrKpax.vo.Badge;


public interface BadgeBO {
	
	public Boolean addBadge(String nameBadge, String descripBadge, String imageBadge, String campusSession);
     	public Boolean delBadge(String nameBadge, String campusSession);
	public Badge getBadge(String nameBadge, String campusSession);
     	public List<Badge> getAllBadges(String campusSession);

}
