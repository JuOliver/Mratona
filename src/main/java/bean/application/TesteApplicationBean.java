package bean.application;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

@ManagedBean
@ApplicationScoped /*Joga tudo na memoria do servidor*/
public class TesteApplicationBean implements Serializable {
    private List<String> categoriaList;

    @PostConstruct
    public void init(){
        System.out.println("Entrou no PostConstruct do ApplicationScoped");
        categoriaList = asList("RPG","sci-fi", "Terror");
    }

    public void mudarLista(){
        categoriaList =asList("RPG","sci-fi", "Terror","humor");
    }

    public List<String> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<String> categoriaList) {
        this.categoriaList = categoriaList;
    }
}
