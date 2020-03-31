package jogo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Robo robo = new RoboInteligente("Vermelho");
        System.out.println("Você é o Robo Vermelho.");
        System.out.println("Determine a posição do alimento que o Robo Vermelho irá encontrar: ");
        System.out.println("Digite o X do alimento: ");
        Integer xAlimento = teclado.nextInt();
        System.out.println("Digite o Y do alimento: ");
        Integer yAlimento = teclado.nextInt();
        
        System.out.println("O robo está na posição (0,0)");
        
        do {
            //i = coluna
            //j = linha
            for(int i=0; i<5; i++){
                System.out.println("\n");
                for(int j=0; j<5; j++){
                        if(i == yAlimento && j == xAlimento){
                            System.out.print("A ");
                        }else if(robo.GetX() == j && robo.GetY() == i){
                            System.out.print("R ");
                        }else {
                            System.out.print(". ");
                        }
                    }
                }
            System.out.println("\n");
            System.out.println("O alimento está na posição (" + xAlimento + "," + yAlimento + ")");
            System.out.println("Mova o robo!");
            System.out.println("1 - cima / 2 - baixo / 3 - direita / 4 - esquerda");
            Integer posicao = teclado.nextInt();
            String posiçãoAtualRobo = robo.mover(posicao);
            System.out.println(posiçãoAtualRobo);
                
        } while(robo.encontrouAlimento(xAlimento, yAlimento) != true);
        System.out.println("O robo + " + robo.GetCor() + " encontrou o alimento!");
    }
}
