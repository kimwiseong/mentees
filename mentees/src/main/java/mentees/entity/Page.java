package mentees.entity;

public class Page {
	private int start;
	private int end;
	
	private boolean prev;
	private boolean next;
	
	private int pageNum;
	private int amount = 10;
	private int total;
	
	public Page(int pageNum, int total) {
		this.pageNum = pageNum;
		this.total = total;
		
		this.end = (int)Math.ceil(this.pageNum * 0.1) * 10;
		this.start = this.end - 10 + 1;
		
		int realEnd = (int)Math.ceil(this.total / (double)this.amount);
		
		if(this.end > realEnd) 
			this.end = realEnd;
		
		this.prev = this.start > 1;
		this.next = this.end < realEnd;
		
	}
	
	public Page(int pageNum, int amount, int total) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.total = total;
		
		this.end = (int)Math.ceil(this.pageNum * 0.1) * 10;
		this.start = this.end - 10 + 1;
		
		int realEnd = (int)Math.ceil(this.total / (double)this.amount);
		
		if(this.end > realEnd) 
			this.end = realEnd;
		
		this.prev = this.start > 1;
		this.next = this.end < realEnd;
		
	}
	
	public int getStart() {
		return start;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public int getEnd() {
		return end;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	public boolean getPrev() {
		return prev;
	}
	
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	
	public boolean getNext() {
		return next;
	}
	
	public void setNext(boolean next) {
		this.next = next;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
