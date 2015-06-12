package uoc.edu.svrKpax.business;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Date;

import uoc.edu.svrKpax.vo.AwardImage;


public interface AwardImageBO {
	
	public Boolean addAwardImage(int idAward, int levelAward, String imageAward, String campusSession);
     	public Boolean delAwardImage(int idAwardImage, String campusSession);
	public AwardImage getAwardImage(int idAwardImage, String campusSession);
     	public List<AwardImage> getAllAwardImages(String campusSession);

}
