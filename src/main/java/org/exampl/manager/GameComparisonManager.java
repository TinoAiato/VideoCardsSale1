package org.exampl.manager;

import org.exampl.comparison.GameComparison;
import org.springframework.stereotype.Component;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;

@Component
public class GameComparisonManager {
    private long nextId =1;
    private List<GameComparison> items = new ArrayList<>();

    public GameComparison getById(long id) {
        for (GameComparison item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public GameComparison deleteById(long id) {
        int index = findIndexById(id);
        if (index==-1){
            return null;
        }
        return items.remove(index);
    }

    public GameComparison save(GameComparison item) {
        if (item.getId()==0){
            item.setId(nextId++);
            items.add(item);
            return item;
        }
        int index = findIndexById(item.getId());
        if (index==-1){
            return null;
        }
        items.set(index, item);
        return item;
    }

    private int findIndexById(long id){
        int index = 0;
        for (GameComparison item : items) {
            if(item.getId()==id){
                return index;
            }
            index++;
        }
        return -1;
    }
}
