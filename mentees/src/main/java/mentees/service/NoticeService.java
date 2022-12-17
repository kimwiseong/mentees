package mentees.service;

import java.util.List;

import mentees.entity.Notice;
import mentees.repository.NoticeRepository;

public class NoticeService {
	
	private static final NoticeRepository noticeRepository = new NoticeRepository();
	
	public boolean insert(Notice notice) {
		return noticeRepository.insert(notice);
	}
	
	public List<Notice> readNoticeList() {
		return noticeRepository.readNoticeList();
	}
	
	public List<Notice> readNoticePaging(int amount, int pageNum) {
		return noticeRepository.readNoticePaging(amount, pageNum);
	}
	
	public List<Notice> search(String query) {
		return noticeRepository.search(query);
	}
	
	public List<Notice> searchPaging(String query, int amount, int pageNum) {
		return noticeRepository.searchPaging(query, amount, pageNum);
	}
	
	public Notice findById(int id) {
		return noticeRepository.findById(id);
	}
	
	public boolean deleteById(int id) {
		return noticeRepository.deleteById(id);
	}
	
	public boolean update(int id, String title, String content) {
		return noticeRepository.update(id, title, content);
	}
	
	public int total() {
		return noticeRepository.total();
	}
	
}
