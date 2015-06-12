package uoc.edu.svrKpax.dao;

import java.util.List;

import uoc.edu.svrKpax.vo.Badge;

public interface BadgeDao {
	
	public Badge getBadge(String nameBadge);
	public Badge getBadgeById(int idBadge);
	public void addBadge(Badge objBadge);
	public void delBadge(Badge objBadge);
	public List<Badge> getAllBadges();

}
