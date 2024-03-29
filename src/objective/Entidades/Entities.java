package objective.Entidades;


import java.util.ArrayList;
import java.util.List;

public class Entities {
    protected static final List<Caracteristicas> allCaracteristics = new ArrayList<>();
    protected static List<Pratos> dishes = new ArrayList<>();
    private static Caracteristicas root;
    private String nome;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String toString() {
        return getNome();

    }
    public static Caracteristicas getRoot() {
        return root;
    }

    public static void setRoot(Caracteristicas root) {
        Entities.root = root;
    }

    public static void addToList(Entities nova) {
        if(nova instanceof  Caracteristicas){
            allCaracteristics.add((Caracteristicas) nova);
        }else{
            dishes.add((Pratos) nova);
        }

    }
}
