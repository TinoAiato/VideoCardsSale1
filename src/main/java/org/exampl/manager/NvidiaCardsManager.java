package org.exampl.manager;

import org.exampl.comparison.GameComparison;
import org.exampl.videoCards.NvidiaCards;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NvidiaCardsManager {
    private long nextId =1;
    private List<NvidiaCards> items = new ArrayList<>();

    public NvidiaCards getById(long id) {
        for (NvidiaCards item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public NvidiaCards deleteById(long id) {
        int index = findIndexById(id);
        if (index==-1){
            return null;
        }
        return items.remove(index);
    }

    public NvidiaCards save(NvidiaCards item) {
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
        for (NvidiaCards item : items) {
            if(item.getId()==id){
                return index;
            }
            index++;
        }
        return -1;
    }
}
