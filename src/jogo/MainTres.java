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
        
        System.out.println("Determine a posição do alimento: ");
        System.out.println("Digite o X do alimento: ");
        Integer xAlimento = teclado.nextInt();
        System.out.println("Digite o Y do alimento: ");
        Integer yAlimento = teclado.nextInt();
        
        while (roboUm.encontrouAlimento(xAlimento, yAlimento) == false ) {
            System.out.println("\n");
            System.out.println("O alimento está na posição (" + xAlimento + "," + yAlimento + ")");
            
            //i = coluna
            //j = linha
            for(int i=0; i<5; i++){
                System.out.println("\n");
                for(int j=0; j<5; j++){
                        if(i == yAlimento && j == xAlimento){
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
        while (roboDois.encontrouAlimento(xAlimento, yAlimento) == false) {
            System.out.println("\n");
            System.out.println("O alimento está na posição (" + xAlimento + "," + yAlimento + ")");
            
            //i = coluna
            //j = linha
            for(int i=0; i<5; i++){
                System.out.println("\n");
                for(int j=0; j<5; j++){
                        if(i == yAlimento && j == xAlimento){
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
