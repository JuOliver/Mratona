package bean.session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@ManagedBean
@SessionScoped
/*A session fica viva enquanto não fechar o browser ou chamar algum metodo pra invalida-lá*/
public class TesteSessionBean implements Serializable {
    /*codigo é para gerar um numero aleatorio e colocar um nome da lista personagens na lista personagemSelecionado*/
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();

    @PostConstruct
    public void init(){
        System.out.println("Entrou");
        personagens = asList("Goku", "Vegeta", "Gohan");
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "session?faces-redirect=true";
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
