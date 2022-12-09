package mentees.service;

import java.util.List;

import mentees.entity.MentorComments;
import mentees.repository.MentorCommentsRepository;

public class MentorCommentsService {
	private static final MentorCommentsRepository mentorCommentsRepository = new MentorCommentsRepository();
	
	public boolean insert(MentorComments mentorComments) {
		return mentorCommentsRepository.insert(mentorComments);
	}
	
	public List<MentorComments> read(int mentorId) {
		return mentorCommentsRepository.read(mentorId);
	}
	
	public List<MentorComments> readPaging(int mentorId, int amount, int pageNum) {
		return mentorCommentsRepository.readPaging(mentorId, amount, pageNum);
	}
	
	public boolean delete(int id, int mentorId) {
		return mentorCommentsRepository.delete(id, mentorId);
	}
	
	public boolean update(int id, int mentorId, String content) {
		return mentorCommentsRepository.update(id, mentorId, content);
	}
	
	public int total(int mentorId) {
		return mentorCommentsRepository.total(mentorId);
	}

}
