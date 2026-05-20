package com.geminiIntegrate.model;

import com.geminiIntegrate.services.StringListConverter;
import jakarta.persistence.*;
import lombok.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Gemini_recommended")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private Long activityId;
    private String activityType;

    @Column(columnDefinition = "LONGTEXT")
    private String recommendation;

    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "LONGTEXT")
    private List<String> safety;

    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "LONGTEXT")
    private List<String> improvements;

    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "LONGTEXT")
    private List<String> suggestions;

    @CreatedDate
    private LocalDateTime createdAt;
}


