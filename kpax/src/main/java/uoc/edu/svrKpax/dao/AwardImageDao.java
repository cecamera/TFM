package uoc.edu.svrKpax.dao;

import java.util.List;

import uoc.edu.svrKpax.vo.AwardImage;

public interface AwardImageDao {
	
	public AwardImage getAwardImage(int idAward, int levelAward);
	public AwardImage getAwardImageById(int idAwardImage);
	public void addAwardImage(AwardImage objAwardImage);
	public void delAwardImage(AwardImage objAwardImage);
	public List<AwardImage> getAllAwardImages();

}
