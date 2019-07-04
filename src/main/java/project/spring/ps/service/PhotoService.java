package project.spring.ps.service;

import java.util.List;

import project.spring.ps.model.AttentionlistVO;
import project.spring.ps.model.MemberVO;
import project.spring.ps.model.PhotoAttentionListVO;
import project.spring.ps.model.PhotoMemberVO;
import project.spring.ps.model.PhotoVO;

public interface PhotoService {

	List<PhotoMemberVO> latestBoard();

	List<PhotoMemberVO> likeBoard();

	List<PhotoMemberVO> downloadBoard();

	PhotoVO selectPhoto(int photoId);

	int insertZzim(AttentionlistVO attention);

	AttentionlistVO selectZzim(AttentionlistVO attentionlist);

	int deleteZzim(AttentionlistVO attention);

	int updateZzimUp(int photoId);

	int updateZzimDown(int photoId);

	int updateView();

	int insertPhoto(PhotoVO photo);

	MemberVO selectCreator(String creatorId);

	int updatePhoto(PhotoVO photo);

	int deletePhoto(int photoId);

	List<PhotoMemberVO> selectMyPhoto(String id);

	List<PhotoAttentionListVO> selectAttentionList(String id);

	List<PhotoMemberVO> hashSearch(String search);

	List<PhotoMemberVO> userSearch(String search);

	List<PhotoMemberVO> userSearchLike(String search);

	List<PhotoMemberVO> hashSearchLike(String search);

	List<PhotoMemberVO> hashSearchDown(String search);

	List<PhotoMemberVO> userSearchDown(String search);

	int selectPrice(String id);

	int updatePoint(MemberVO updateMember);

	int updateDownCount(int photoId);

}
