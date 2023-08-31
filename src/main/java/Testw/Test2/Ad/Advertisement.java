package Testw.Test2.Ad;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
class Advertisement {
    @Id
    private int id;
    private String title;
    private String content;
    private LocalDateTime creationDate;
    private String authorEmail;
    private int readCount;

    public Advertisement() {
    }

    public Advertisement(int id, String title, String content, LocalDateTime creationDate, String authorEmail) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
        this.authorEmail = authorEmail;
        this.readCount = 0;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public String getAuthorEmail() {
        return authorEmail;
    }
    public int getReadCount() {
        return readCount;
    }

    public void incrementReadCount() {
        readCount++;
    }
}
