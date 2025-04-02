package cn.abalone.service;

import cn.abalone.entity.Video;
import cn.abalone.entity.pojo.VideoSearch;
import cn.abalone.service.repository.VideoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Service
public class VideoService {
    private final VideoRepository repository;
    private final Sort.TypedSort<Video> video = Sort.sort(Video.class);
    private final Sort sort = video.by(Video::getName).ascending().and(video.by(Video::getDescription).descending());


    public VideoService(VideoRepository repository) {
        this.repository = repository;
    }

    public List<Video> getVideos() {
        return repository.findAll(sort);
    }

    public Video create(Video newVideo) {
        repository.save(newVideo);
        return newVideo;
    }

    public List<Video> search(VideoSearch videoSearch) {

        if ((StringUtils.hasText(videoSearch.name()))
                && StringUtils.hasText(videoSearch.description())) {
            return repository.findByNameContainsOrDescriptionContainsAllIgnoreCase(videoSearch.name(), videoSearch.description(),sort);
        }
        if ((StringUtils.hasText(videoSearch.name()))){
            return repository.findByNameContainsIgnoreCase(videoSearch.name(),sort);
        }
        if ((StringUtils.hasText(videoSearch.description()))){
            return repository.findByDescriptionContainsIgnoreCase(videoSearch.description(),sort);
        }
        return Collections.emptyList();
    }
}
