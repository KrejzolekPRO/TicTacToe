package pl.marcinkowalczyk.tictactoe.objects.impl;

import pl.marcinkowalczyk.tictactoe.enums.GameType;
import pl.marcinkowalczyk.tictactoe.objects.Player;

public interface GameImpl {

    Player getActualTour();

    GameType getType();

    void setType(GameType type);

    void screenRefresh();

    Boolean checkFields(Player player);

    void create();

    Player changeTour();

    Boolean isFieldSet(Integer field);

    Boolean checkChoose(Integer field);
}
