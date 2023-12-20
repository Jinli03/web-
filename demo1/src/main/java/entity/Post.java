package entity;

import java.util.Date;

public class Post {
    private int id; // 帖子的唯一标识
    private String title; // 帖子标题
    private String content; // 帖子内容
    private String author; // 发帖者
    private Date datePosted; // 发帖日期

    private int likes;
    private byte[] image; // 用于存储图片数据

    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
   this.datePosted = new Date();
    }
    public Post(int id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.datePosted = datePosted;
    }

    public Post() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }
    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}

