package objective.Logica;


import objective.Entidades.Caracteristicas;
import objective.UI.Messages;
import objective.Entidades.Pratos;

/*Base lógica para a realização do jogo*/
public class GameLogic extends Messages {
    /*lastCheck acompanha sobre qual caracteristica foi a ultima pergunta
     * yesCheck acompanha para qual caracteristica foi dado a ultima resposta "sim"(efetivamente o prato acossiado à ela é o que a pessoa está pensando)*/
    static Caracteristicas lastCheck, yesCheck;
    static  boolean gameStarted;
    public static void startGame() {
        if(!gameStarted){
            /*gameStarted impede que esse bloco seja executado uma segunda vez*/
            gameStarted = true;
            new Caracteristicas();
        }

        int answer = ask(Caracteristicas.getRoot());
        checkAnswer(answer);


    }
    /*começando na Entities.root(Massa) pergunta sobre a caracteristica atual e, dependendo da resposta, navega para a proxima caracteristica(caso exista).
     * atualiza a variável lastCheck com a caracteristica passada e, em caso de resposta "Sim", atualiza, com essa, a variavel yesCheck
     * retorna o valor da resposta fornecida à questão(YES_OPTION = 0 ; NO_OPTION = 1)*/
    private static int ask(Caracteristicas current) {
        /*A resposta é sempre sim para current apontar para "Bolo de chocolate"*/
        int answer = 0;
        try {
            answer = current.getNome().equals("Bolo de chocolate") ? 0 : getConfirm(current);
        } catch (NullPointerException e) {
            answer = getConfirm(current);
        }
        lastCheck = current;
        if (answer == YES_OPTION) {
            yesCheck = lastCheck;

        }
        if (current.hasNext(answer)) {
            return ask(current.getNext(answer));
        }

        return answer;
    }

    /*verifica se a resposta alcançada foi a correta e, ou avisa que acertou, ou desiste e pede por um par prato-caracteristica novo.*/
    private static void checkAnswer(int answer) {
        int ans = getConfirm(yesCheck.getPlate());
        if (ans == YES_OPTION) {
            gotRight();
        } else {
            getNewDish(answer);
        }
    }



    /*Cria uma nova caracteristica e aponta a lastCheck.next[index] para ela.*/
    private static void getNewDish(int index) {
        String tempDish = newPlate();
        String tempCaracteristic = newCaracteristic(yesCheck, tempDish);

        new Caracteristicas(tempCaracteristic, index,  new Pratos(tempDish),  lastCheck);

    }




}
