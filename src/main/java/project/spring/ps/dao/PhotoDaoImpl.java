package project.spring.ps.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.spring.ps.model.AttentionlistVO;
import project.spring.ps.model.MemberVO;
import project.spring.ps.model.PhotoAttentionListVO;
import project.spring.ps.model.PhotoMemberVO;
import project.spring.ps.model.PhotoVO;

@Repository
public class PhotoDaoImpl implements PhotoDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<PhotoMemberVO> latestBoard() {
		return session.selectList("latestBoard");
	}

	@Override
	public List<PhotoMemberVO> likeBoard() {
		return session.selectList("likeBoard");
	}

	@Override
	public List<PhotoMemberVO> downloadBoard() {
		return session.selectList("downloadBoard");
	}

	@Override
	public PhotoVO selectPhoto(int photoId) {
		return session.selectOne("selectPhoto", photoId);
	}

	@Override
	public int insertZzim(AttentionlistVO attention) {
		System.out.println("[PhotoDaoImpl.java] insertZzim : id " + attention.getAttentionId());
		System.out.println("[PhotoDaoImpl.java] insertZzim : photoid " + attention.getLikePhotoId()); 
		return session.insert("insertZzim", attention);
	}

	@Override
	public AttentionlistVO selectZzim(AttentionlistVO attentionlist) {
		return session.selectOne("selectZzim", attentionlist);
	}

	@Override
	public int deleteZzim(AttentionlistVO attention) {
		return session.delete("deleteZzim", attention);
	}

	@Override
	public int updateZzimUp(int photoId) {
		return session.update("updateZzimUp", photoId);
	}

	@Override
	public int updateZzimDown(int photoId) {
		return session.update("updateZzimDown", photoId);
	}

	@Override
	public int updateView() {
		return session.update("updateView");
	}

	@Override
	public int insertPhoto(PhotoVO photo) {
		return session.insert("insertPhoto", photo);
	}

	@Override
	public MemberVO selectCreator(String creatorId) {
		return session.selectOne("selectCreator", creatorId);
	}

	@Override
	public int updatePhoto(PhotoVO photo) {
		return session.update("updatePhoto", photo);
	}

	@Override
	public int deletePhoto(int photoId) {
		return session.delete("deletePhoto", photoId);
	}

	@Override
	public List<PhotoMemberVO> selectMyPhoto(String id) {
		return session.selectList("selectMyPhoto", id);
	}

	@Override
	public List<PhotoAttentionListVO> selectAttentionList(String id) {
		return session.selectList("selectAttentionList", id);
	}

	@Override
	public List<PhotoMemberVO> hashSearch(String search) {
		return session.selectList("hashSearch", search);
	}

	@Override
	public List<PhotoMemberVO> userSearch(String search) {
		return session.selectList("userSearch", search);
	}

	@Override
	public List<PhotoMemberVO> hashSearchLike(String search) {
		return session.selectList("hashSearchLike", search);
	}

	@Override
	public List<PhotoMemberVO> userSearchLike(String search) {
		return session.selectList("userSearchLike", search);
	}

	@Override
	public List<PhotoMemberVO> hashSearchDown(String search) {
		return session.selectList("hashSearchDown", search);
	}

	@Override
	public List<PhotoMemberVO> userSearchDown(String search) {
		return session.selectList("userSearchDown", search);
	}
}
