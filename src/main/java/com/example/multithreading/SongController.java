package com.example.multithreading;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SongController {
    @GetMapping("/song")
    public Map<String, String> getOneSong() {
        HashMap<String, String> map = new HashMap<>();
        map.put("artist_name", "adele");
        return map;
    }
}
