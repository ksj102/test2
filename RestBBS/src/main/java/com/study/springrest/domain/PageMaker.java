package com.study.springrest.domain;

public class PageMaker {
	int totalArticles; // 총 게시글 수
	int	startPage; // 페이지가 시작되는 숫자
	int endPage; // 페이지가 끝나는 숫자
	int pagePerBlock = 10; // 한페이지 게시글 수
	boolean next; // 다음
	boolean prev; // 이전
	
	Criteria criteria; // 현재
	
	public PageMaker( Criteria cri, int total ) {
		criteria = cri;
		totalArticles = total;
		process();
	}
	
	private void process() {
		int totalPages = ( int )Math.ceil( totalArticles / (double)pagePerBlock ); // 18
		int currentPage = criteria.getPage(); // 요청한 페이지 11
		endPage = ( int )Math.ceil( currentPage / (double)pagePerBlock ) * pagePerBlock; // 10, 20
		startPage = endPage - pagePerBlock + 1; // 1, 11, 21, 31
		
		if( endPage >= totalPages ) {
			endPage = totalPages;
		}
		
		// 이전페이지 버튼 유무
		if( startPage > 1 ) {
			prev = true;
		}
		// 다음페이지 버튼 유무
		if( endPage < totalPages ) {
			next = true;
		}	
	}

	public int getTotalArticles() {
		return totalArticles;
	}

	public void setTotalArticles(int totalArticles) {
		this.totalArticles = totalArticles;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
}
