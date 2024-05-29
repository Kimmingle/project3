package com.morning.biz;

import java.util.List;

import com.morning.domain.Board;

public interface BoardBiz {
	public int getTotalCount();
	public List<Board> getBoardList();
	public Board getBoard(int bno);   
	public Board selBoard(int bno);   //게시물만 조회하는 용도
	public void insBoard(Board board);
	public void upBoard(Board board);
	public void countUpCnt(int bno);
	public void delBoard(int bno);
}


