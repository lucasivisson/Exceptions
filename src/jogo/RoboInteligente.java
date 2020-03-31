package jogo;

import java.util.Random;

public class RoboInteligente extends Robo{
    private Integer contadorDeErroDown;
    private Integer contadorDeErroLeft;
    
    public RoboInteligente(String cor){
        super(cor);
        this.x = 0;
        this.y = 0;
        this.contadorDeErroDown = 0;
        this.contadorDeErroLeft = 0;
    }
    
    public String mover(){
        Random gerador = new Random();
        Integer opcaoRobo = gerador.nextInt(5);
        
        try{
        /*
        1 - up
        2 - down
        3 - right
        4 - left
        */
        if(opcaoRobo == 2){
            //down
            contadorDeErroDown = 0;
            contadorDeErroLeft = 0;
            if(y == 4){
                throw new MovimentoInvalidoException(x, y);
            }
            else if(y < 5){
            y++;
            }
        }    
        else if(opcaoRobo == 1){
            //up
            if(y == 0 || y > 4){
                // Se o y for igual a 0 significa que o robo está no limite do jogo.
                contadorDeErroDown++;
                contadorDeErroLeft = 0;
                throw new MovimentoInvalidoException(x, y);
            }else if(y > 0){
                //down - move para baixo.
                y--;
            }
            if(contadorDeErroDown > 0 && x != 0){
                /* Se o contador de erro para baixo for maior do que 1, significa que o robo tentou ir para baixo
                e não conseguiu e esta no limite do jogo no angulo y, se o x for diferente de 0, o robo não está 
                no limite do jogo no angulo x.
                */
                
                /* Então o robo terá 3 opções de movimento para escolher, exceto para baixo pois ele já está no 
                limite.
                */
                Integer opcaoRoboContraErro = gerador.nextInt(4);
                if(opcaoRoboContraErro == 1){
                    //up
                    y++;
                }
                else if(opcaoRoboContraErro == 2){
                    //right
                    x++;
                }
                else if(opcaoRoboContraErro == 3){
                    //left
                    x--;
                }
            }
            if(contadorDeErroDown > 0 && x == 0){
                /* Se o contadorDeErroDown for maior do que 0, significa que o robo ja tentou ir para baixo mas está
                no limite do jogo no angulo y, se o x for igual a 0 significa que o robo está no limite do jogo no 
                angulo x.
                */
                
                /*Então o robo terá apenas 2 opções para se mover, exceto para baixo e para esquerda pois ele já está
                no limite
                */
                Integer opcaoRoboContraErro = gerador.nextInt(3);
                if(opcaoRoboContraErro == 1){
                    //up
                    y++;
                }
                else if(opcaoRoboContraErro == 2){
                    //right
                    x++;
                }
            }
        }else if(opcaoRobo == 3){
            contadorDeErroDown = 0;
            contadorDeErroLeft = 0;
            if(x == 4){
                throw new MovimentoInvalidoException(x, y);
            }else if(x < 5){
                x++;
            }
        }
        else if(opcaoRobo == 4){
            if(x == 0 || x > 4){
                contadorDeErroDown = 0;
                contadorDeErroLeft++;
                throw new MovimentoInvalidoException(x, y);
            }else if(x > 0){
                //left
                x--;
            }
            if(contadorDeErroLeft > 0 && y!= 0){
                /* Se o contadorDeErroLeft for maior do que 1, significa que o robo tentou ir para o lado esquerdo
                e não conseguiu e esta no limite do jogo no angulo x, se o y for diferente de 0, o robo não está 
                no limite do jogo no angulo y.
                */
                
                /* Então o robo terá 3 opções de movimento para escolher, exceto para esquerda pois ele já está no 
                limite.
                */
                Integer opcaoRoboContraErro = gerador.nextInt(4);
                if(opcaoRoboContraErro == 1){
                    //up
                    y++;
                }
                else if(opcaoRoboContraErro == 2){
                    //down
                    y--;
                }
                else if(opcaoRoboContraErro == 3){
                    //right
                    x++;
                }
            }
            if(contadorDeErroLeft > 0 && y == 0){
                /* Se o contadorDeErroLeft for maior do que 0, significa que o robo ja tentou ir para esquerda mas está
                no limite do jogo no angulo x, se o y for igual a 0 significa que o robo está no limite do jogo no 
                angulo y.
                */
                
                /*Então o robo terá apenas 2 opções para se mover, exceto para baixo e para esquerda pois ele já está
                no limite
                */
                Integer opcaoRoboContraErro = gerador.nextInt(3);
                if(opcaoRoboContraErro == 1){
                    //up
                    y++;
                }
                else if(opcaoRoboContraErro == 2){
                    //right
                    x++;
                }
            }
        }
        }catch (MovimentoInvalidoException ex) {
            System.out.println("Campos negativos são inválidos. Movimento não executado!");
        }
        return "O robo " + this.cor + " está na posição [" + (this.x + 1) + "," + (this.y + 1) + "]";
    }
}
