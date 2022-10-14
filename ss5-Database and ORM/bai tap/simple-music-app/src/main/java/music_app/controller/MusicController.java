package music_app.controller;

import music_app.entity.Music;
import music_app.entity.MusicForm;
import music_app.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    MusicService musicService;
    @Value("${file-upload}")
    private String fileUpload;
    @GetMapping
    public ModelAndView getList() {
        List<Music> musicList = musicService.getAll();
        ModelAndView modelAndView = new ModelAndView("list","musicList",musicList);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView createForm() {
        MusicForm musicForm = new MusicForm();
        ModelAndView modelAndView = new ModelAndView("createForm","musicForm",musicForm);

        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("music") MusicForm musicForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = musicForm.getLink();
        String link = multipartFile.getOriginalFilename();

        try {
            FileCopyUtils.copy(musicForm.getLink().getBytes(), new File(fileUpload + link));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music = new Music(musicForm.getName(),musicForm.getArtist(),musicForm.getCategory(),link);
        musicService.create(music);

        redirectAttributes.addFlashAttribute("mess","Add song successfully");
        return "redirect:/music";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable("id") int id) {
        Music music = musicService.findById(id);
        ModelAndView modelAndView;
        if(music!=null) {
            modelAndView = new ModelAndView("editForm","music",music);
        }else {
            modelAndView = new ModelAndView("list","mess","Song not found!");
        }
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("music") Music music, RedirectAttributes redirectAttributes) {
        musicService.update(music);

        redirectAttributes.addFlashAttribute("mess","Edit song successfully");
        return "redirect:/music";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        musicService.delete(id);

        redirectAttributes.addFlashAttribute("mess","Delete song successfully");
        return "redirect:/music";
    }
}
