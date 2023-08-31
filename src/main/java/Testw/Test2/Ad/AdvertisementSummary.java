package Testw.Test2.Ad;

import java.time.LocalDateTime;

class AdvertisementSummary {
    private int id;
    private String title;
    private LocalDateTime creationDate;

    public AdvertisementSummary(int id, String title, LocalDateTime creationDate) {
        this.id = id;
        this.title = title;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}