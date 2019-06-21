package project.spring.ps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.ps.dao.PhotoDao;
import project.spring.ps.model.AttentionlistVO;
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

}
