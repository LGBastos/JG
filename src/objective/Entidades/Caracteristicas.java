package objective.Entidades;

public class Caracteristicas extends Entities {
    private Pratos plate;
    /*aponta para alguma caracteristica, baseado na resposta dada à atual, this.next[0] para "sim" e this.next[1] para "não"*/
    private final Caracteristicas[] next = new Caracteristicas[2];
    public Caracteristicas(String nome, Pratos plate){
        this.setNome(nome);
        this.setPlate(plate);
        addToList(this);
    }
    public Caracteristicas(){
        setRoot(new Caracteristicas("massa", new Pratos("lasanha")));
        Caracteristicas temp = new Caracteristicas("Bolo de chocolate", new Pratos("bolo de chocolate"));
        getRoot().setNext(1,temp);
    }
    public Caracteristicas(String nome, int index, Pratos plate, Caracteristicas carac){
        setNome(nome);
        carac.setNext(index, this);
        setPlate(plate);
        addToList(this);
    }


    public Caracteristicas getNext(int index) {
        return this.next[index];
    }

    public void setPlate(Pratos plate) {
        this.plate = plate;
    }

    public void setNext( int index, Caracteristicas next) {
        this.next[index]=next;
    }

    public boolean hasNext(int index) {
        return !(this.next[index] == null);
    }

    public Pratos getPlate() {
        return this.plate;
    }
}

