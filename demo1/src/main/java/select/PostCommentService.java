package select;

import dao.PostCommentDao;
import entity.PostComment;

import java.util.List;

public class PostCommentService {
    private PostCommentDao postCommentDao=new PostCommentDao();
    public List<PostComment> getPostComments(int postId){
        return postCommentDao.getCommentsByPostId(postId);
    }

    public void addPostComment(PostComment postComment){
        postCommentDao.addComment(postComment);
    }
}
