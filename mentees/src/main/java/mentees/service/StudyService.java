package mentees.service;

import java.util.List;

import mentees.entity.Study;
import mentees.repository.StudyRepository;

public class StudyService {
	
	private static final StudyRepository studyRepository = new StudyRepository();
	
	public boolean insert(Study study) {
		return studyRepository.insert(study);
	}
	
	public List<Study> readStudyList() {
		return studyRepository.readStudyList();
	}
	
	public List<Study> readStudyPaging(int amount, int pageNum) {
		return studyRepository.readStudyPaging(amount, pageNum);
	}
	
	public List<Study> search(String query) {
		return studyRepository.search(query);
	}
	
	public List<Study> searchPaging(String query, int amount, int pageNum) {
		return studyRepository.searchPaging(query, amount, pageNum);
	}
	
	public Study findById(int id) {
		return studyRepository.findById(id);
	}
	
	public String findNameById(int id) {
		return studyRepository.findNameById(id);
	}
	
	public boolean deleteById(int id) {
		return studyRepository.deleteById(id);
	}
	
	public boolean update(int id, String title, String content) {
		return studyRepository.update(id, title, content);
	}
	
	public int total() {
		return studyRepository.total();
	}
}
