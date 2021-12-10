package org.exampl.controller;

import lombok.RequiredArgsConstructor;
import org.exampl.manager.NvidiaCardsManager;
import org.exampl.videoCards.NvidiaCards;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class NvidiaCardsController {
    private final NvidiaCardsManager manager;

    @RequestMapping("/getAll")
    public List<NvidiaCards> getAll(){
        return manager.getAll();
    }

    @RequestMapping("/save")
    public NvidiaCards save(@ModelAttribute NvidiaCards item){
        return manager.save(item);
    }

    @RequestMapping("/removeById")
    public void removeById(@RequestParam long id){
        manager.removeById(id);
    }

    @RequestMapping("/restoreById")
    public void restoreById(@RequestParam long id){
        manager.restoreById(id);
    }
}
