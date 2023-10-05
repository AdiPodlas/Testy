package Testw.Test2.Ad;

import java.time.LocalDateTime;

class AdvertisementSummary {
    private int id;
    private String title;
    private LocalDateTime creationDate;

    private String content;

    public AdvertisementSummary(int id, String title,String content, LocalDateTime creationDate) {
        this.id = id;
        this.title = title;
        this.creationDate = creationDate;
        this.content = content;

    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}