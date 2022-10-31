package com.example.musicez.controller;

import com.example.musicez.model.Music;
import com.example.musicez.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("musics")
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping("musics")
    public ModelAndView ListMusic() {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("musics", musicService.findAll());
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showCreateFrom() {
        ModelAndView modelAndView = new ModelAndView("/form");
        modelAndView.addObject("music", new Music());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView saveMusic(@ModelAttribute("music")Music music) {
        ModelAndView modelAndView = new ModelAndView("/form");
        modelAndView.addObject("music", new Music());
        modelAndView.addObject("message", "New music created successfully");
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Music> music = musicService.findById(id);
        if(music.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/form");
            modelAndView.addObject("music", music.get());
            return modelAndView;
        }else {
            return new ModelAndView("/error");
        }

    }

    @PostMapping("edit/{id}")
    public ModelAndView updateMusic(@ModelAttribute("music")Music music) {
        musicService.save(music);
        ModelAndView modelAndView = new ModelAndView("/form");
        modelAndView.addObject("music", new Music());
        modelAndView.addObject("message", "Music updated successfully");
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Music> music = musicService.findById(id);
        if(music.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/form");
            modelAndView.addObject("music", music.get());
            return modelAndView;
        }else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("delete/{id}")
    public String deleteForm(@ModelAttribute("music")Music music) {
        musicService.remove(music.getId());
        return "redirect:musics";
    }
}
