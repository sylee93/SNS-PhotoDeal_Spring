package project.spring.ps.dao;

import java.util.List;

import project.spring.ps.model.PhotoMemberVO;

public interface PhotoDao {

	List<PhotoMemberVO> latestBoard();

	List<PhotoMemberVO> likeBoard();

	List<PhotoMemberVO> downloadBoard();

}
