package bean.estudante;

import bean.model.Estudante;
import com.sun.faces.renderkit.html_basic.HtmlBasicRenderer;

import java.io.Serializable;
import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import static java.util.Arrays.asList;


@ManagedBean
@ViewScoped
public class EstudanteRegistrarBean {
    private Estudante estudante = new Estudante();
    private String[] nomesArray = {"Dev", "eh", "incrivel"};
    private List<String> nomesList =asList("Marcio", "Joao", "Fernando");
    private Set<String> nomesSet =new HashSet<>(asList("Lindo", "dia", "nublado"));
    private Map<String, String> nomesMap=new HashMap<>();
    private boolean mostrarNotas;
    private boolean mostrarLink;

    {
        nomesMap.put("Goku", "O mais forte");
        nomesMap.put("One piece", "O mais longo");
        nomesMap.put("Naruto", "O mais lenga lenga");
//        for(Map.Entry<String, String> entry: nomesMap.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
        }
        public void executar(){
            System.out.println("Fazendo uma busca no BD");
            System.out.println("Processando os dados");
            System.out.println("Exibindo os dados");
        }
    public String executarRetorno(String param){
        return "Quem é o(a) melhor? "+param;

    }
    public String irParaIndex2(){
        System.out.println("Entrou");
        return "index2?faces-redirect=true";

    }

    public void exibirNotas(){
        System.out.println(mostrarNotas);
        this.mostrarNotas = true;
        System.out.println(mostrarNotas);
    }


    public void esconderNotas(){
        System.out.println(mostrarNotas);
        this.mostrarNotas = false;
        System.out.println(mostrarNotas);
    }

    public void exibirLink(){
        this.mostrarLink = true;
    }


    public void esconderLink(){
        this.mostrarLink = false;
    }

    public boolean isMostrarLink() {
        return mostrarLink;
    }

    public void setMostrarLink(boolean mostrarLink) {
        this.mostrarLink = mostrarLink;
    }

    public boolean isMostrarNotas() {
        return mostrarNotas;
    }

    public void setMostrarNotas(boolean mostrarNotas) {
        this.mostrarNotas = mostrarNotas;
    }

    public Map<String, String> getNomesMap() {
        return nomesMap;
    }

    public void setNomesMap(Map<String, String> nomesMap) {
        this.nomesMap = nomesMap;
    }

    public Set<String> getNomesSet() {
        return nomesSet;
    }

    public void setNomesSet(Set<String> nomesSet) {
        this.nomesSet = nomesSet;
    }

    public List<String> getNomesList() {
        return nomesList;
    }

    public void setNomesList(List<String> nomesList) {
        this.nomesList = nomesList;
    }

    public String[] getNomesArray() {
        return nomesArray;
    }

    public void setNomesArray(String[] nomesArray) {
        this.nomesArray = nomesArray;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
