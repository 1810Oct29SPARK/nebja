package nebja.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import nebja.beans.Comment;
public interface CommentDAO {
	public List<Comment> getAllComments();
	public List<Comment> getAllCommentsbyID(int id);
	public void makeAComment(Comment comment);

}
