package pl.marcinkowalczyk.tictactoe;

import pl.marcinkowalczyk.tictactoe.enums.GameType;
import pl.marcinkowalczyk.tictactoe.objects.Game;
import pl.marcinkowalczyk.tictactoe.objects.Player;
import pl.marcinkowalczyk.tictactoe.utils.Util;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static Game game;

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        String[] name = new String[2];
        Util.print("Podaj nazwe 1 gracza.");
        name[0] = scanner.nextLine();
        Util.print("Podaj nazwe 2 gracza.");
        name[1] = scanner.nextLine();
        Game game = new Game(new Player(name[0]), new Player(name[1]));
        game.create();
            do {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                game.screenRefresh();
                game.changeTour();
                Util.print("Obecna tura: " + game.getActualTour().getName());
                Util.print("Wybierz pole i zatwierdz enterem.");
                Integer choose = scanner.nextInt();
                Boolean set = game.checkChoose(choose);
                if (!set) {
                    Boolean bool = true;
                    Util.print("Podany numer pola jest nieprawidlowy! Wybierz inny i zatwierdz enterem.");
                    do {
                        Integer choosei = scanner.nextInt();
                        Boolean seti = game.checkChoose(choosei);
                        if (!seti) {
                            Util.print("Podany numer pola jest nieprawidlowy! Wybierz inny i zatwierdz enterem.");
                        } else {
                            game.getActualTour().addField(choosei);
                            bool = false;
                        }
                    } while (bool);
                } else {
                    game.getActualTour().addField(choose);
                }
                if (game.checkFields(game.getActualTour())) {
                    game.setType(GameType.STOPING);
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    game.screenRefresh();
                    Util.print("Wygral: " + game.getActualTour().getName());
                    return;
                }
            } while (game.getType() == GameType.PLAYING);
    }
}
