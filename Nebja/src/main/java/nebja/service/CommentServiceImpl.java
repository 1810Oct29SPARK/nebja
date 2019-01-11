package nebja.service;

import java.util.List;

import nebja.beans.Comment;
import nebja.dao.CommentDAO;
import nebja.dao.CommentDAOImpl;

public class CommentServiceImpl implements CommentService {

	CommentDAO cd = new CommentDAOImpl();
	
	@Override
	public List<Comment> getAllComments() {
		// TODO Auto-generated method stub
		return cd.getAllComments();
	}

	@Override
	public List<Comment> getAllCommentsbyID(int id) {
		// TODO Auto-generated method stub
		return cd.getAllCommentsbyID(id);
	}

	@Override
	public void makeAComment(Comment comment) {
		// TODO Auto-generated method stub
		cd.makeAComment(comment);
	}

}
