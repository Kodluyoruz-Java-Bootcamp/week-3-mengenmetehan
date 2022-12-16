package com.emlakcepte.example2.models;

import java.time.LocalDateTime;

import static com.emlakcepte.example2.models.BlogStatus.DRAFT;

public class Blog {
    private final String name;
    private final String category;
    private User creater;
    private BlogStatus status = DRAFT;
    private LocalDateTime createDateTime;

    public Blog(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public User getCreater() {
        return creater;
    }

    public void setCreater(User creater) {
        this.creater = creater;
    }

    public BlogStatus getStatus() {
        return status;
    }

    public String getStatusName() {
        return status.name;
    }

    public void setStatus(BlogStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    @Override
    public String toString() {
        return String.format("%s isimli blog, %s kategorisinde %s tarihinde %s tarafından yazılmıştır. Şu an %s halindedir.",
                getName(), getCategory(), getCreateDateTime(), getCreater(), getStatusName());
    }
}
