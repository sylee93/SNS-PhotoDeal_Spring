package project.spring.ps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.spring.ps.dao.PhotoDao;
import project.spring.ps.model.PhotoVO;

@Service
public class PhotoServiceImpl implements PhotoService {
	@Autowired
	private PhotoDao pd;
	@Override
	public List<PhotoVO> latestBoard() {
		System.out.println("[PhotoServiceImpl.java] latestBoard");
		return pd.latestBoard();
	}
	@Override
	public List<PhotoVO> likeBoard() {
		System.out.println("[PhotoServiceImpl.java] likeBoard");
		return pd.likeBoard();
	}
	@Override
	public List<PhotoVO> downloadBoard() {
		System.out.println("[PhotoServiceImpl.java] downloadBoard");
		return pd.downloadBoard();
	}

}
