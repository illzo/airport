package erp.board.DAO;

import java.util.List;

import erp.board.DTO.BoardNoticeDTO;

public interface BoardNoticeDAO {

	int insert(BoardNoticeDTO post);
	List<BoardNoticeDTO> boardlist();
	int delete(String boardno);
	
}