package task1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        createDir("../Games/temp");
        createDir("../Games/src");
        createDir("../Games/res");
        createDir("../Games/savegames");
        createDir("../Games/src/main");
        createDir("../Games/src/test");
        createFile("../Games/src/main/Main.java");
        createFile("../Games/src/main/Utils.java");
        createDir("../Games/res/drawables");
        createDir("../Games/res/vectors");
        createDir("../Games/res/icons");
    }

    private static void createFile(String path) throws IOException {
        boolean isCreated = new File(path).createNewFile();
        addInfoToTempTxt(path, isCreated);
    }

    private static void createDir(String path) {
        boolean isCreated = new File(path).mkdir();
        addInfoToTempTxt(path, isCreated);
    }

    private static void addInfoToTempTxt(String path, boolean isCreated) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("../Games/temp/temp.txt"))) {
            if (isCreated) {
                builder.append("Файл/директория успешно создан(а) по пути: ").append(path).append("\n");
            } else {
                builder.append("Файл/директория не создан(а) по пути: ").append(path).append("\n");
            }
            bw.write(String.valueOf(builder));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
