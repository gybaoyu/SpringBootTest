package cn.abalone.service.repository;

import cn.abalone.entity.Video;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video,Long> {
    List<Video> findByName(String name);//select video.* from VideoEntity video where video.name = ?1
    List<Video> findByNameContainsOrDescriptionContainsAllIgnoreCase(String name, String description, Sort sort);
    List<Video> findByNameContainsIgnoreCase(String name, Sort sort);
    List<Video> findByDescriptionContainsIgnoreCase(String description, Sort sort);
}
