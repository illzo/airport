package erp.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erp.board.DAO.BoardNoticeDAO;
import erp.board.DTO.BoardNoticeDTO;
@Service
public class BoardNoticeServiceImpl implements BoardNoticeService {
	
	@Autowired
	BoardNoticeDAO dao;
	
	@Override
	public int insert(BoardNoticeDTO post) {
		return dao.insert(post);
	}

	@Override
	public List<BoardNoticeDTO> boardlist() {
		return dao.boardlist();
	}

	@Override
	public int delete(String boardno) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
}