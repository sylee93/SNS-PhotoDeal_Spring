package project.spring.ps.service;

import java.util.List;

import project.spring.ps.model.PhotoMemberVO;

public interface PhotoService {

	List<PhotoMemberVO> latestBoard();

	List<PhotoMemberVO> likeBoard();

	List<PhotoMemberVO> downloadBoard();

}
