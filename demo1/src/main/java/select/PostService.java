package select;

import dao.PostDao;
import entity.Post;

import java.util.List;

public class PostService {
    private PostDao postDao = new PostDao();

    public Post getPostById(int id) {
        // 调用DAO层的getPostById方法
        return postDao.getPostById(id);
    }

    public List<Post> getAllPosts() {
        // 调用DAO层的getAllPosts方法
        return postDao.getAllPosts();
    }

    public void insertPost(Post post) {
        // 调用DAO层的insertPost方法
        postDao.insertPost(post);
    }
    public List<Post> searchPosts(String query) {
        return postDao.searchPosts(query);
    }
}
