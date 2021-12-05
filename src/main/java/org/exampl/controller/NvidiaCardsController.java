package org.exampl.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.exampl.comparison.GameComparison;
import org.exampl.manager.GameComparisonManager;
import org.exampl.manager.NvidiaCardsManager;
import org.exampl.videoCards.NvidiaCards;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class NvidiaCardsController {
    private NvidiaCardsManager nvidiaCardsManager;
    @RequestMapping("/save")
    public NvidiaCards save(@ModelAttribute NvidiaCards item){

        return nvidiaCardsManager.save(item);
    }

    @RequestMapping("/getById")
    public NvidiaCards getById(@RequestParam long id){
        return nvidiaCardsManager.getById(id);
    }
    @RequestMapping("/deleteById")
    public NvidiaCards deleteById(@RequestParam long id){
        return nvidiaCardsManager.deleteById(id);
    }
}
