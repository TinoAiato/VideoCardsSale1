package org.exampl.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.exampl.comparison.GameComparison;
import org.exampl.manager.GameComparisonManager;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class GameComparisonController {
    private GameComparisonManager comparisonManager;

    @RequestMapping("/save")
    public GameComparison save(@ModelAttribute GameComparison item){
        return comparisonManager.save(item);
    }

    @RequestMapping("/getById")
    public GameComparison getById(@RequestParam long id){
        return comparisonManager.getById(id);
    }
    @RequestMapping("/deleteById")
    public GameComparison deleteById(@RequestParam long id){
        return comparisonManager.deleteById(id);
    }
}
