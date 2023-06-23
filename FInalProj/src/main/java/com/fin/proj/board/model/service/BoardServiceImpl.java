package com.fin.proj.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fin.proj.board.model.dao.BoardDAO;
import com.fin.proj.board.model.vo.Board;
import com.fin.proj.board.model.vo.Reply;
import com.fin.proj.common.model.vo.PageInfo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO bDAO;
	
	@Override
	public int getListCount(String i) {
		return bDAO.getListCount(i);
	}

	@Override
	public ArrayList<Board> selectBoardList(PageInfo pi, String i) {
		int offset = (pi.getCurrentPage() -1 ) * pi.getBoardLimit();
		RowBounds rowbounds = new RowBounds(offset, pi.getBoardLimit());
		
		return bDAO.selectBoardList(i, rowbounds);
	}

	@Override
	@Transactional
	public Board selectBoard(int bNo, boolean countYN) {
		int result = 0;
		if(countYN) {
			result = bDAO.countUp(bNo);
//			System.out.println(result);
		}
		Board board = bDAO.selectBoard(bNo);
//		System.out.println(board);
		return board;
	}

	@Override
	public ArrayList<Reply> selectReply(int bNo) {
		return bDAO.selectReply(bNo);
	}

	@Override
	public int insertBoard(Board b) {
		return bDAO.insertBoard(b);
	}

	@Override
	public void insertReply(Reply r) {
		bDAO.insertReply(r);
	}

	@Override
	public int updateBoard(Board b) {
		System.out.println(b);
		return bDAO.updateBoard(b);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return bDAO.deleteBoard(boardNo);
	}

	@Override
	public int insertFruit(Board b) {
		return bDAO.insertFruit(b);
	}

	@Override
	public int deleteReply(int replyNo) {
		return bDAO.deleteReply(replyNo);
	}

	@Override
	public int deleteReplyAll(int boardNo) {
		return bDAO.deleteReplyAll(boardNo);
	}

	@Override
	public int replyCount(int boardNo) {
		return bDAO.replyCount(boardNo);
	}

	@Override
	public ArrayList<Board> searchByTitle(PageInfo pi, HashMap<String, Object> map) {
		int offset = (pi.getCurrentPage() -1 ) * pi.getBoardLimit();
		RowBounds rowbounds = new RowBounds(offset, pi.getBoardLimit());
		return bDAO.searchByTitle(map, rowbounds);
	}

	@Override
	public ArrayList<Board> searchByTitleAndCategory(PageInfo pi, HashMap<String, Object> params) {
		int offset = (pi.getCurrentPage() -1 ) * pi.getBoardLimit();
		RowBounds rowbounds = new RowBounds(offset, pi.getBoardLimit());
		
		return bDAO.searchByTitleAndCategory(params, rowbounds);
	}

	@Override
	public int searchListCount(HashMap<String, Object> params) {
//		System.out.println(params);
		return bDAO.searchListCount(params);
	}

}
