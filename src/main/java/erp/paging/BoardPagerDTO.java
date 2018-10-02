package erp.paging;

public class BoardPagerDTO {
	//페이지당 게시물 수 
	public static final int PAGE_SCALE=10;
	//화면당 페이지 수
	public static final int BLOCK_SCALE=10;
	
	private int curPage; //현재페이지수
	private int prevPage; //이전페이지
	private int nextPage; //다음 페이지
	private int totPage; //전체 페이지 갯수
	private int totBlock; //전체 페이지 블록 갯수
	private int curBlock; //현재 페이지 블록
	private int preBlock; //이전 페이지 블록
	private int nextBolck; //다음 페이지 블록
	// where rn between #{start} and #{end}
	private int pageBegin; //#{start}
	private int pageEnd; //#{end}

	private int blockBegin; //현재 페이지 블록의 시작번호
	private int blockEnd; //현재 페이지 블록의 끝번호
	
	
	public BoardPagerDTO() {
		super();

	}
	public BoardPagerDTO(int curPage, int prevPage, int nextPage, int totPage, int totBlock, int curBlock, int preBlock,
			int nextBolck, int pageBegin, int pageEnd, int blockBegin, int blockEnd) {
		super();
		this.curPage = curPage;
		this.prevPage = prevPage;
		this.nextPage = nextPage;
		this.totPage = totPage;
		this.totBlock = totBlock;
		this.curBlock = curBlock;
		this.preBlock = preBlock;
		this.nextBolck = nextBolck;
		this.pageBegin = pageBegin;
		this.pageEnd = pageEnd;
		this.blockBegin = blockBegin;
		this.blockEnd = blockEnd;
	}
	
	//(레코드갯수, 현재페이지번호)
	public BoardPagerDTO(int count, int curPage) {
		curBlock = 1; //현재 페이지 블록 번호
		this.curPage=curPage; //현재 페이지 설정
		setTotPage(count); //전체 페이지 갯수 계산
		setPageRange();//
		setTotBlock(); //전체페이지 블록갯수를 계산
		setBlockRange(); //페이지 블록으 ㅣ시작, 끝번호 계싼
	}
	
	public void setBlockRange() {
		//현재페이지가 몇번째 페이지 블록에 속하는 지 계산
		curBlock = (int)Math.ceil(curPage-1)/BLOCK_SCALE+1;
		//현재페이지 블록의 시작, 끝번호 계산
		blockBegin = (curBlock-1)*BLOCK_SCALE+1;
		//페이지 블록의 끝번호
		blockEnd = blockBegin+BLOCK_SCALE;
		//마지막 블록이 범위를 초과하지 않도록 계산
		if(blockEnd>totPage) blockEnd=totPage;
		//이전 눌렀을 때 이동할 페이지
		prevPage=(curPage==1)?1:(curBlock-1)*BLOCK_SCALE;
		//다음 눌렀을 때 이동할 페이지
		nextPage=curBlock>totBlock?(curBlock*BLOCK_SCALE):(curBlock*BLOCK_SCALE)+1;
		//마지막 페이지가 범위를 초과하지않도록 처리
		if(nextPage>=totPage)nextPage=totPage;
	}

	public void setPageRange() {
		//where rn between #{start} and #{end}
		//시작번호 = (현재페이지 -1)*페이지당 게시물수 +1
		pageBegin = (curPage-1)*PAGE_SCALE+1;
		//끝번호 = 시작번호 + 페이지당 게시물수 -1
		pageEnd = pageBegin+PAGE_SCALE-1;
	}
	
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int count) {
		//Math.ceil(실수)올림처리
		totPage = (int)Math.ceil(count*1.0/PAGE_SCALE);
	}
	public int getTotBlock() {
		return totBlock;
	}
	public void setTotBlock() {
		//전체 페이지 갯수 /10
		//91/10=>9.1=>10개
		totBlock=(int)Math.ceil(totPage/BLOCK_SCALE);
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getPreBlock() {
		return preBlock;
	}
	public void setPreBlock(int preBlock) {
		this.preBlock = preBlock;
	}
	public int getNextBolck() {
		return nextBolck;
	}
	public void setNextBolck(int nextBolck) {
		this.nextBolck = nextBolck;
	}
	public int getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	public int getBlockBegin() {
		return blockBegin;
	}
	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}
	public int getBlockEnd() {
		return blockEnd;
	}
	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}
	public static int getPageScale() {
		return PAGE_SCALE;
	}
	public static int getBlockScale() {
		return BLOCK_SCALE;
	}
	
	
	
}
