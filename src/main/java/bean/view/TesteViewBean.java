package bean.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@ManagedBean
@ViewScoped
/*A session fica viva enquanto não fechar o browser ou chamar algum metodo pra invalida-lá*/
public class TesteViewBean implements Serializable {
    /*codigo é para gerar um numero aleatorio e colocar um nome da lista personagens na lista personagemSelecionado*/
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();

    @PostConstruct
    public void init(){
        System.out.println("Entrou no PostConstruct do View Scoped");
        personagens = asList("Naruto", "Sasuke", "Sakura");
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "view?faces-redirect=true";
    }

    /*Metodo*/
    public void selecionarPersonagem() {
        /*gerando numeros aleatorios, 3 é o limite*/
        int index = ThreadLocalRandom.current().nextInt(3);
        String personagem = personagens.get(index);
        personagemSelecionado.add(personagem);
    }

    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }
}
