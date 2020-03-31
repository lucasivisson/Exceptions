package jogo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Robo robo = new Robo("Vermelho");
        
        Integer xAlimento;
        Integer yAlimento;
        
        Boolean jaEncontrou = false;
        
        System.out.println("Você é o Robo Vermelho.");
        
        do {
            System.out.println("Determine a posição do alimento que o Robo Vermelho irá encontrar: ");
            System.out.println("OBS: Posições no limite de 1 a 5.");
            System.out.println("Digite o X do alimento: ");
            xAlimento = teclado.nextInt();
            System.out.println("Digite o Y do alimento: ");
            yAlimento = teclado.nextInt();
        } while ((xAlimento > 5 || xAlimento < 1) || (yAlimento > 5 || yAlimento < 1));
        
        System.out.println("\n");
          
        System.out.println("O robo " + robo.getCor() + " está na posição (1,1)");
        
        do {
            //i = coluna
            //j = linha
            for(int i = 0; i < 5; i++){
                System.out.println("\n");
                for(int j = 0; j < 5; j++){
                    if(i == (yAlimento - 1) && j == (xAlimento - 1)){
                        System.out.print("A ");
                    } else if(robo.getX() == j && robo.getY() == i){
                        System.out.print("R ");
                    } else {
                        System.out.print(". ");
                    }
                }
            }
            
            if(robo.encontrouAlimento((xAlimento - 1), (yAlimento- 1))) {
            	jaEncontrou = true;
            	System.out.println("\n");
            	System.out.println("O robo " + robo.getCor() + " encontrou o alimento!");
            } else {
            	System.out.println("\n");
                System.out.println("O alimento está na posição (" + xAlimento + "," + yAlimento + ")");
                System.out.println("Mova o robo!");
                System.out.println("1 - cima / 2 - baixo / 3 - direita / 4 - esquerda");
                Integer posicao = teclado.nextInt();
                String posiçãoAtualRobo = robo.mover(posicao);
                System.out.println(posiçãoAtualRobo);
            }        
        } while(robo.encontrouAlimento((xAlimento - 1), (yAlimento - 1)) != true);
        
        if(jaEncontrou == false) {
        	System.out.println("O robo " + robo.getCor() + " encontrou o alimento!");
        }                
    }
}
