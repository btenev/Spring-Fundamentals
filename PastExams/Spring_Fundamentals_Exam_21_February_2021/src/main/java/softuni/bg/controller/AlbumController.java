package softuni.bg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.bg.model.dto.AlbumAddDto;

import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    @ModelAttribute
    public AlbumAddDto albumAddDto() {
        return new AlbumAddDto();
    }

    @GetMapping("/add")
    public String albumAdd() {
        return "add-album";
    }

    @PostMapping("/add")
    public String albumAddConfirm(@Valid AlbumAddDto albumAddDto) {
        return "redirect:add";
    }
}
