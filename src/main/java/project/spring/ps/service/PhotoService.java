package project.spring.ps.service;

import java.util.List;

import project.spring.ps.model.PhotoVO;

public interface PhotoService {

	List<PhotoVO> latestBoard();

	List<PhotoVO> likeBoard();

	List<PhotoVO> downloadBoard();

}
