package com.morning.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.morning.domain.Board;
import com.morning.per.BoardMapper;

@Service   //서비스임
public class BoardService implements BoardBiz {

	@Autowired  //의존성 주입으로 BoardMapper 타입의 객체를 주입받음(BoardMapper는 MyBatis를 통해 데이터베이스와 상호작용)
	private BoardMapper boardDAO;
	
	@Override
	public int getTotalCount() {
		return boardDAO.getTotalCount();
	}

	@Override
	public List<Board> getBoardList() {
		return boardDAO.getBoardList();
	}

	@Transactional     //이 메서드 안에 있는건 하나로 처리되게 함
	@Override
	public Board getBoard(int bno) {  
		boardDAO.vcntCount(bno);  //조회수 증가
		return boardDAO.getBoard(bno);   //게시물 조회
	}
	
	@Override
	public Board selBoard(int bno) {
		return boardDAO.getBoard(bno);
	}

	@Override
	public void insBoard(Board board) {
		boardDAO.insBoard(board);		
	}

	@Override
	public void upBoard(Board board) {
		boardDAO.upBoard(board);
	}

	@Override
	public void countUpCnt(int bno) {
		boardDAO.vcntCount(bno);		
	}

	@Override
	public void delBoard(int bno) {
		boardDAO.delBoard(bno);
	}
	
}
