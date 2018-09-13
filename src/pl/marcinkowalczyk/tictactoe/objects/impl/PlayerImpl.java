package pl.marcinkowalczyk.tictactoe.objects.impl;

import java.util.List;

public interface PlayerImpl {

    void addField(int field);

    List<Integer> getFields();

    String getName();

    void restart();
}
