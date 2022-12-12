package mentees.service;

import java.util.List;

import mentees.entity.StudyComments;
import mentees.repository.StudyCommentsRepository;

public class StudyCommentsService {
	
	private static final StudyCommentsRepository studyCommentsRepository = new StudyCommentsRepository();
	
	public boolean insert(StudyComments studyComments) {
		return studyCommentsRepository.insert(studyComments);
	}
	
	public List<StudyComments> read(int studyId) {
		return studyCommentsRepository.read(studyId);
	}
	
	public List<StudyComments> readPaging(int studyId, int amount, int pageNum) {
		return studyCommentsRepository.readPaging(studyId, amount, pageNum);
	}
	
	public boolean delete(int id, int studyId) {
		return studyCommentsRepository.delete(id, studyId);
	}
	
	public boolean update(int id, int studyId, String content) {
		return studyCommentsRepository.update(id, studyId, content);
	}
	
	public int total(int studyId) {
		return studyCommentsRepository.total(studyId);
	}
	
}
