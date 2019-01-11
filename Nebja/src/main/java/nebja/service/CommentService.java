package nebja.service;

import java.util.List;

import nebja.beans.Comment;

public interface CommentService {
	
		public List<Comment> getAllComments();
		public List<Comment> getAllCommentsbyID(int id);
		public void makeAComment(Comment comment);


}