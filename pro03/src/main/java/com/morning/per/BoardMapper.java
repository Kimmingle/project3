package com.morning.per;

import java.util.List;

import com.morning.domain.Board;

public interface BoardMapper {  //마이바티스 사용해서 sql실행
	
	public int getTotalCount();
	public List<Board> getBoardList();
	public Board getBoard(int bno);
	//public Board selBoard(int bno);  //get이랑 겹쳐서?
	public void insBoard(Board board);
	public void upBoard(Board board);
	public void vcntCount(int bno);
	public void delBoard(int bno);
}



