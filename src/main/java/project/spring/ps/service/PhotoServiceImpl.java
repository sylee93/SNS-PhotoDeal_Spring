package project.spring.ps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.ps.dao.PhotoDao;
import project.spring.ps.model.AttentionlistVO;
import project.spring.ps.model.MemberVO;
import project.spring.ps.model.PhotoAttentionListVO;
import project.spring.ps.model.PhotoMemberVO;
import project.spring.ps.model.PhotoVO;

@Service
public class PhotoServiceImpl implements PhotoService {
	@Autowired
	private PhotoDao pd;
	@Override
	public List<PhotoMemberVO> latestBoard() {
		System.out.println("[PhotoServiceImpl.java] latestBoard");
		return pd.latestBoard();
	}
	@Override
	public List<PhotoMemberVO> likeBoard() {
		System.out.println("[PhotoServiceImpl.java] likeBoard");
		return pd.likeBoard();
	}
	
	@Override
	public List<PhotoMemberVO> downloadBoard() {
		System.out.println("[PhotoServiceImpl.java] downloadBoard");
		return pd.downloadBoard();
	}

	@Override
	public PhotoVO selectPhoto(int photoId) {
		System.out.println("[PhotoServiceImpl.java] selectPhoto");
		return pd.selectPhoto(photoId);
	}
	@Override
	public int insertZzim(AttentionlistVO attention) {
		System.out.println("[PhotoServiceImpl.java] insertZzim");
		return pd.insertZzim(attention);
	}
	@Override
	public AttentionlistVO selectZzim(AttentionlistVO attentionlist) {
		System.out.println("[PhotoServiceImpl.java] selectZzim");
		return pd.selectZzim(attentionlist);
	}
	@Override
	public int deleteZzim(AttentionlistVO attention) {
		System.out.println("[PhotoServiceImpl.java] deleteZzim");
		return pd.deleteZzim(attention);
	}
	@Override
	public int updateZzimUp(int photoId) {
		System.out.println("[PhotoServiceImpl.java] updateZzim");
		return pd.updateZzimUp(photoId);
	}
	@Override
	public int updateZzimDown(int photoId) {
		System.out.println("[PhotoServiceImpl.java] updateZzimDown");
		return pd.updateZzimDown(photoId);
	}
	@Override
	public int updateView() {
		System.out.println("[PhotoServiceImpl.java] updateView");
		return pd.updateView();
	}
	@Override
	public int insertPhoto(PhotoVO photo) {
		System.out.println("[PhotoServiceImpl.java] updateView");
		return pd.insertPhoto(photo);
	}
	@Override
	public MemberVO selectCreator(String creatorId) {
		System.out.println("[PhotoServiceImpl.java] selectCreator");
		return pd.selectCreator(creatorId);
	}
	@Override
	public int updatePhoto(PhotoVO photo) {
		System.out.println("[PhotoServiceImpl.java] updatePhoto");
		return pd.updatePhoto(photo);
	}
	@Override
	public int deletePhoto(int photoId) {
		System.out.println("[PhotoServiceImpl.java] deletePhoto");
		return pd.deletePhoto(photoId);
	}
	@Override
	public List<PhotoMemberVO> selectMyPhoto(String id) {
		System.out.println("[PhotoServiceImpl.java] selectMyPhoto");
		return pd.selectMyPhoto(id);
	}
	@Override
	public List<PhotoAttentionListVO> selectAttentionList(String id) {
		System.out.println("[PhotoServiceImpl.java] selectAttentionList");
		return pd.selectAttentionList(id);
	}

}
