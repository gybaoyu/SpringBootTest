package cn.abalone.controller;

import cn.abalone.entity.Video;
import cn.abalone.service.VideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    private final VideoService videoService;
    public ApiController(VideoService videoService) {
        this.videoService = videoService;
    }//这里是构造注入(效果和自动注入即Autowired相同),能够确保这个service是和前面HomeController一样的对象副本
    @GetMapping("/api/videos")
    public List<Video> all(){
        return videoService.getVideos();
    }
    @PostMapping("/api/videos")
    public Video newVideo(@RequestBody Video newVideo){
        return videoService.create(newVideo);
    }
}
