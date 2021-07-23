package bean.conversation;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
@ConversationScoped
public class TesteConversationBean implements Serializable {
    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();
    @Inject
    private Conversation conversation;
    @PostConstruct
    public void init() {
        System.out.println("Entrou no PostConstruct");
        personagens = asList("Tanjiro", "Nezuko", "Zenitsu");
        if(conversation.isTransient()){
            //Long running
            conversation.begin();
            System.out.println("Iniciando Conversation Scoped, ID= "+conversation.getId());
        }
    }
    public String endConversation(){
        if(!conversation.isTransient()){
            conversation.end();
        }
        return "conversation?faces-redirect=true"; //não manter o id
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

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
