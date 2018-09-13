package pl.marcinkowalczyk.tictactoe.objects;

import pl.marcinkowalczyk.tictactoe.enums.GameType;
import pl.marcinkowalczyk.tictactoe.objects.impl.GameImpl;
import pl.marcinkowalczyk.tictactoe.utils.Util;

import java.util.List;

public class Game implements GameImpl {

    private Player playerX,
                   playerO,
                   actualTour;

    private GameType type;

    public Game(Player playerX, Player playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.actualTour = Math.random() >= 0.5D ? playerX : playerO;
        this.type = GameType.STOPING;
    }

    public Player getActualTour() {
        return actualTour;
    }

    public GameType getType() {
        return type;
    }

    public void setType(GameType type) {
        this.type = type;
    }

    public void screenRefresh(){
        List<Integer> fieldsO = this.playerO.getFields();
        List<Integer> fieldsX = this.playerX.getFields();
        String[] fields = new String[10];
        for(int i=1; i<10; i++){
            fields[i] = fieldsO.contains(i) ? "O" : fieldsX.contains(i) ? "X" : i + "";
        }
        Util.print("|---|---|---|");
        Util.print(String.format("| %s | %s | %s |", fields[1], fields[2], fields[3]));
        Util.print("|---|---|---|");
        Util.print(String.format("| %s | %s | %s |", fields[4], fields[5], fields[6]));
        Util.print("|---|---|---|");
        Util.print(String.format("| %s | %s | %s |", fields[7], fields[8], fields[9]));
        Util.print("|---|---|---|");
    }

    public Boolean checkFields(Player player){
        List<Integer> fields = player.getFields();
        if(fields.size() >= 3) {
            if (fields.contains(1) && fields.contains(2) && fields.contains(3)) {
                return true;
            }
            if (fields.contains(4) && fields.contains(5) && fields.contains(6)) {
                return true;
            }
            if (fields.contains(7) && fields.contains(8) && fields.contains(9)) {
                return true;
            }
            if (fields.contains(1) && fields.contains(4) && fields.contains(7)) {
                return true;
            }
            if (fields.contains(2) && fields.contains(5) && fields.contains(8)) {
                return true;
            }
            if (fields.contains(3) && fields.contains(6) && fields.contains(9)) {
                return true;
            }
            if (fields.contains(1) && fields.contains(5) && fields.contains(9)) {
                return true;
            }
            if (fields.contains(3) && fields.contains(5) && fields.contains(7)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void create(){
        this.playerO.restart();
        this.playerX.restart();
        this.type = GameType.PLAYING;
    }

    public Player changeTour(){
        if(this.actualTour == this.playerO){
            this.actualTour = this.playerX;
        } else {
            this.actualTour = this.playerO;
        }
        return this.actualTour;

    }

    public Boolean isFieldSet(Integer field){
        if(this.playerO.getFields().contains(field)){
            return true;
        }
        if(this.playerX.getFields().contains(field)){
            return true;
        }
        return false;
    }

    public Boolean checkChoose(Integer field){
        if(this.isFieldSet(field)){
            return false;
        }
        if(field > 0 && field < 10) {
            return true;
        }
        return false;
    }
}
