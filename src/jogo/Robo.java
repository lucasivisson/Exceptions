package jogo;

public class Robo {
    private String cor;
    private Integer x;
    private Integer y;
    
    public Robo(String cor){
        this.cor = cor;
        this.x = 0;
        this.y = 0;
    }
    public String GetCor(){
        return this.cor;
    }
    public void SetCor(String cor){
        this.cor = cor;
    }
    public Integer GetX(){
        return this.x;
    }
    public void SetX(Integer x){
        this.x = x;
    }
    public Integer GetY(){
        return this.y;
    }
    public void SetY(Integer y){
        this.y = y;
    }
    
    public String Mover(String posição){
        try{
        if(posição == "up"){
            y++;
        }    
        else if(posição == "down"){
           if(y == 0){
               throw new MovimentoInvalidoException(x, y);
           }else if(y > 0){
               y--;
           }
        }else if(posição == "right"){
            x++;
        }
        else if(posição == "left"){
           if(x == 0){
               throw new MovimentoInvalidoException(x, y);
           }else if(x > 0){
               x--;
           }
        }else{
            System.out.println("Movimento inválido!");
        }
        } catch (MovimentoInvalidoException ex) {
            System.out.println("Ocorreu um erro");
            ex.printStackTrace();
        }
        return "O robo está na posição [" + x + "," + y + "]";
    }
    public String Mover(Integer opção){
        try{
        /*
        1 - up
        2 - down
        3 - right
        4 - left
        */
        if(opção == 1){
            y++;
        }    
        else if(opção == 2){
           if(y == 0){
               throw new MovimentoInvalidoException(x, y);
           }else if(y > 0){
               y--;
           }
        }else if(opção == 3){
            x++;
        }
        else if(opção == 4){
           if(x == 0){
               throw new MovimentoInvalidoException(x, y);
           }else if(x > 0){
               x--;
           }
        }else{
            System.out.println("Movimento inválido!");
        }
        } catch (MovimentoInvalidoException ex) {
            System.out.println("Ocorreu um erro");
            ex.printStackTrace();
        }
        return "O robo está na posição [" + x + "," + y + "]";
    }
    public boolean EncontrouAlimento(Integer x, Integer y){
        boolean encontrouAlimento = false;
        if(this.x == x && this.y == y){
            encontrouAlimento = true;
            return encontrouAlimento;
        }else{
            return encontrouAlimento;
        }
    }
}
