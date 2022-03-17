package task2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaverGame {
    public static void saveGame(String desPath, GameProgress progress) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(desPath))) {
            oos.writeObject(progress);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
