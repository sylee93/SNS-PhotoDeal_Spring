package project.spring.ps.dao;

import java.util.List;

import project.spring.ps.model.PhotoVO;

public interface PhotoDao {

	List<PhotoVO> latestBoard();

	List<PhotoVO> likeBoard();

	List<PhotoVO> downloadBoard();

}
