package cn.abalone.controller;

import cn.abalone.entity.Video;
import cn.abalone.record.VideoSearch;
import cn.abalone.service.VideoService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static cn.abalone.tools.JsonUtils.convertToJson;

@Controller
public class HomeController {
    private final VideoService videoService;
    public HomeController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("videos",videoService.getVideos());
        return "index";
    }
    @PostMapping("/new-video")
    public String newVideo(@ModelAttribute Video video) {
        videoService.create(video);
        return "redirect:/";
    }
    @SneakyThrows
    @PostMapping("/multi-field-search")
    public String multiFieldSearch(@ModelAttribute VideoSearch videoSearch, Model model) {
        List<Video>searchResults =videoService.search(videoSearch);
//        String encodedResults = URLEncoder.encode(convertToJson(searchResults), StandardCharsets.UTF_8);
        model.addAttribute("videos",searchResults);
        return "search";
    }
    @GetMapping("/search")
    public String search(Model model) {
        return "search";
    }
}
