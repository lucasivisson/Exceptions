package jogo;

import java.util.Random;
import java.util.Scanner;

public class MainTres {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
    	Random gerador = new Random();
    	
    	Integer tentativasRoboUm = 0;
    	Integer tentativasRoboDois = 0;
    	
        Robo roboUm = new Robo("Azul");
        RoboInteligente roboDois = new RoboInteligente("Preto");
        
        Integer xAlimento;
        Integer yAlimento;
        
        do {
        System.out.println("Determine a posição do alimento que o Robo Vermelho irá encontrar: ");
        System.out.println("OBS: Posições no limite de 1 a 5.");
        System.out.println("Digite o X do alimento: ");
        xAlimento = teclado.nextInt();
        System.out.println("Digite o Y do alimento: ");
        yAlimento = teclado.nextInt();
        } while ((xAlimento > 5 || xAlimento < 1) || (yAlimento > 5 || yAlimento < 1));
        
        System.out.println("O robo " + roboDois.GetCor() + " está na posição (1,1)");
        
        while (roboUm.encontrouAlimento((xAlimento - 1), (yAlimento - 1)) == false ) {
            System.out.println("\n");
            System.out.println("O alimento está na posição (" + xAlimento + "," + yAlimento + ")");
            
            //i = coluna
            //j = linha
            for(int i=0; i<5; i++){
                System.out.println("\n");
                for(int j=0; j<5; j++){
                        if(i == (yAlimento - 1) && j == (xAlimento - 1)){
                            System.out.print("A ");
                        }else if(roboUm.GetX() == j && roboUm.GetY() == i){
                            System.out.print("R ");
                        }else {
                            System.out.print(". ");
                        }
                    }
                }
            
            System.out.println("\n");
            Integer opçãoRoboUm = gerador.nextInt(5);
                
            String posicaoAtualRoboUm = roboUm.mover(opçãoRoboUm);
            System.out.println(posicaoAtualRoboUm);
        	
            tentativasRoboUm++;
        }
        
        System.out.println("O robo " + roboDois.GetCor() + " está na posição (1,1)");
        
        while (roboDois.encontrouAlimento((xAlimento - 1), (yAlimento - 1)) == false) {
            System.out.println("\n");
            System.out.println("O alimento está na posição (" + xAlimento + "," + yAlimento + ")");
            
            //i = coluna
            //j = linha
            for(int i=0; i<5; i++){
                System.out.println("\n");
                for(int j=0; j<5; j++){
                        if(i == (yAlimento - 1) && j == (xAlimento - 1)){
                            System.out.print("A ");
                        }else if(roboDois.GetX() == j && roboDois.GetY() == i){
                            System.out.print("R ");
                        }else {
                            System.out.print(". ");
                        }
                    }
                }
            
            System.out.println("\n");
            
            String posicaoAtualRoboDois = roboDois.mover();
            System.out.println(posicaoAtualRoboDois);
                   
            tentativasRoboDois++;
        }
        
        System.out.println("=========================================");
        
        if(tentativasRoboUm < tentativasRoboDois) {
        	System.out.println("Robo " + roboUm.GetCor() + " encontrou o alimento primeiro!");
        	System.out.println("Número de tentativas do robo " + roboUm.GetCor() + ": " + tentativasRoboUm);
        	System.out.println("Número de tentativas do robo " + roboDois.GetCor() + ": " + tentativasRoboDois);
        } else if(tentativasRoboUm > tentativasRoboDois) {
        	System.out.println("Robo " + roboDois.GetCor() + " encontrou o alimento primeiro!");
        	System.out.println("Número de tentativas do robo " + roboUm.GetCor() + ": " + tentativasRoboUm);
        	System.out.println("Número de tentativas do robo " + roboDois.GetCor() + ": " + tentativasRoboDois);
        } else {
        	System.out.println("Os dois robos encontraram o alimento ao mesmo tempo!");
        	System.out.println("Número de tentativas do robo " + roboUm.GetCor() + ": " + tentativasRoboUm);
        	System.out.println("Número de tentativas do robo " + roboDois.GetCor() + ": " + tentativasRoboDois);
        }
    }
}
