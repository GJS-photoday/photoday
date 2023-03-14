package com.photoday.photoday.image.entity;

import com.photoday.photoday.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reportId;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @CreatedDate
    private LocalDateTime createdAt; // 로직 고려

    public void setImage(Image image) {
        this.image = image;
        if(image.getReportList().contains(this)){
            image.getReportList().add(this);
        }
    }

    public void setUser(User user) {
        this.user = user;
        if(user.getReports().contains(this)){
            user.getReports().add(this);
        }
    }
}
