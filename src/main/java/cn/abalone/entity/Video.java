package cn.abalone.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "video")
public class Video {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;
    private String description;
    public Video(String name, String description) {
        this.id = null;
        this.name = name;
        this.description = description;
    }
    public Video(String name) {
        this.id = null;
        this.name = name;
        this.description = null;
    }
}

