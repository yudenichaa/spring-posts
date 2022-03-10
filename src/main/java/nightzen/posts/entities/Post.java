package nightzen.posts.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
public class Post {

    static final String dateFormat = "dd-MM-yyyy";

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String text;
    @JsonFormat(pattern = Post.dateFormat)
    private Date createdAt;
    @JsonFormat(pattern = Post.dateFormat)
    private Date updatedAt;

    public Post() {
    }

    public Post(String title, String text, Date createdAt, Date updatedAt) {
        this.title = title;
        this.text = text;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Post(Long id, String title, String text, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt(String createdAt) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Post.dateFormat);
        this.createdAt = dateFormat.parse(createdAt);
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUpdatedAt(String updatedAt) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Post.dateFormat);
        this.createdAt = dateFormat.parse(updatedAt);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
