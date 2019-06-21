package project.spring.ps.dao;

import java.util.List;

import project.spring.ps.model.AttentionlistVO;
import project.spring.ps.model.PhotoMemberVO;
import project.spring.ps.model.PhotoVO;

public interface PhotoDao {

	List<PhotoMemberVO> latestBoard();

	List<PhotoMemberVO> likeBoard();

	List<PhotoMemberVO> downloadBoard();

	PhotoVO selectPhoto(int photoId);

	int insertZzim(AttentionlistVO attention);

	AttentionlistVO selectZzim(AttentionlistVO attentionlist);

	int deleteZzim(AttentionlistVO attention);

}
