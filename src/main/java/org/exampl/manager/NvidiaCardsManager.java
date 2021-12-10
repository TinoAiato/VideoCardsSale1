package org.exampl.manager;

import lombok.RequiredArgsConstructor;
import org.exampl.Jdbc.NvidiaJdbc;
import org.exampl.videoCards.NvidiaCards;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NvidiaCardsManager {
    private final NvidiaJdbc jdbc;
    private final JdbcTemplate template;

    public List<NvidiaCards> getAll(){
        return
        return jdbc.getAll();
    }

    public NvidiaCards save(NvidiaCards item){
        if(item.getId()==0){
            return jdbc.add(item);
        }
        return jdbc.update(item);
    }

    public void removeById(long id){
        jdbc.removeById(id);
    }

    public void restoreById(long id){
        jdbc.restoreById(id);
    }

}
