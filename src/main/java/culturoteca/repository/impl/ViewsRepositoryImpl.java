package culturoteca.repository.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import culturoteca.model.View;
import culturoteca.repository.ViewsRepository;
import org.springframework.stereotype.Component;

@Component
public class ViewsRepositoryImpl implements ViewsRepository {

    private final List<View> views;

    public ViewsRepositoryImpl() {
        this.views = new ArrayList<>();
    }

    @Override
    public void addView(String usuario, LocalDateTime viewTime, int edad) {

    }

    @Override
    public List<View> findByVideoCodigo(String videoCodigo) {
        return List.of();
    }

    @Override
    public View save(View view) {
        this.views.add( view );
        return view;
    }

}