package Ex4;

import java.util.ArrayList;
import java.time.*;
import java.util.List;
import java.util.Objects;

public class FBPost {

    private int ID;
    private String userName;
    private LocalDateTime instantCreated;
    private String content;
    private int likes;
    private ArrayList<String> comments;

    //CONSTRUTORES
    public FBPost(int ID, String userName, String content) {
        this.ID = ID;
        this.userName = userName;
        this.content = content;
        this.instantCreated = LocalDateTime.now();
        this.likes = 0;
        this.comments = new ArrayList<>();
    }

    public FBPost(int ID, String userName, String content, int likes) {
        this.ID = ID;
        this.userName = userName;
        this.content = content;
        this.instantCreated = LocalDateTime.now();
        this.likes = likes;
        this.comments = new ArrayList<>();
    }

    public FBPost(int ID, String userName, String content, int likes, List<String> comments) {
        this.ID = ID;
        this.userName = userName;
        this.content = content;
        this.instantCreated = LocalDateTime.now();
        this.likes = likes;
        this.comments = new ArrayList<>(comments);
    }

    public FBPost(int ID, String userName, String content, int likes, List<String> comments, LocalDateTime dateTime) {
        this.ID = ID;
        this.userName = userName;
        this.content = content;
        this.instantCreated = dateTime;
        this.likes = likes;
        this.comments = new ArrayList<>(comments);
    }

    public FBPost(FBPost post) {
        this.ID = post.getID();
        this.userName = post.getUserName();
        this.content = post.getContent();
        this.instantCreated = post.getInstantCreated();
        this.likes = post.getLikes();
        this.comments = new ArrayList<>(post.getComments());
    }

    //METODOS


    //GETTERS && SETTERS


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getInstantCreated() {
        return instantCreated;
    }

    public void setInstantCreated(LocalDateTime instantCreated) {
        this.instantCreated = instantCreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    //CLONE
    public FBPost clone() {
        return new FBPost(this);
    }

    //EQUALS

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FBPost)) return false;
        FBPost fbPost = (FBPost) o;
        return getID() == fbPost.getID() && getLikes() == fbPost.getLikes() && Objects.equals(getUserName(), fbPost.getUserName()) && Objects.equals(getInstantCreated(), fbPost.getInstantCreated()) && Objects.equals(getContent(), fbPost.getContent()) && Objects.equals(getComments(), fbPost.getComments());
    }
}
