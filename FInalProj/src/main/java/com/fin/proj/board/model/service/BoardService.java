package com.fin.proj.board.model.service;

import java.util.ArrayList;

import com.fin.proj.board.model.vo.Board;
import com.fin.proj.board.model.vo.Reply;
import com.fin.proj.common.model.vo.PageInfo;

public interface BoardService {
	
	int getListCount(String string);

	ArrayList<Board> selectBoardList(PageInfo pi, String i);

	Board selectBoard(int bNo, boolean countYN);

	ArrayList<Reply> selectReply(int bNo);

	int insertBoard(Board b);

	void insertReply(Reply r);

	int updateBoard(Board b);

	int deleteBoard(int bId);

	int insertFruit(Board b);

	int deleteReply(int replyNo);

	int deleteReplyAll(int boardNo);
}
