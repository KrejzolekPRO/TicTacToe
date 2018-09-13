package pl.marcinkowalczyk.tictactoe.objects;

import com.sun.istack.internal.NotNull;
import pl.marcinkowalczyk.tictactoe.objects.impl.PlayerImpl;

import java.util.ArrayList;
import java.util.List;

public class Player implements PlayerImpl {

    @NotNull
    private List<Integer> fields;
    private String name;

    public Player(String name) {
        this.fields = new ArrayList<>();
        this.name = name;
    }

    public void addField(int field){
        this.fields.add(field);
    }

    public List<Integer> getFields() {
        return fields;
    }

    public String getName() {
        return name;
    }

    public void restart(){
        this.fields.clear();
    }
}
