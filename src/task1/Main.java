package task1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String path1 = createDir("../Games/temp");
        addInfoToTempTxt(path1);

        String path2 = createDir("../Games/src");
        addInfoToTempTxt(path2);

        String path3 = createDir("../Games/res");
        addInfoToTempTxt(path3);

        String path4 = createDir("../Games/savegames");
        addInfoToTempTxt(path4);

        String path5 = createDir("../Games/src/main");
        addInfoToTempTxt(path5);

        String path6 = createDir("../Games/src/test");
        addInfoToTempTxt(path6);

        String path7 = createFile("../Games/src/main/Main.java");
        addInfoToTempTxt(path7);

        String path8 = createFile("../Games/src/main/Utils.java");
        addInfoToTempTxt(path8);

        String path9 = createDir("../Games/res/drawables");
        addInfoToTempTxt(path9);

        String path10 = createDir("../Games/res/vectors");
        addInfoToTempTxt(path10);

        String path11 = createDir("../Games/res/icons");
        addInfoToTempTxt(path11);
    }

    private static String createFile(String path) throws IOException {
        return new File(path).createNewFile() ? path : null;
    }

    private static String createDir(String path) {
        return new File(path).mkdir() ? path : null;
    }

    private static void addInfoToTempTxt(String path) throws IOException {
        if (!new File("../Games/temp/temp.txt").exists()) {
            String tempPath = createFile("../Games/temp/temp.txt");
            addInfo(tempPath);
        }
        addInfo(path);
    }

    private static void addInfo(String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("../Games/temp/temp.txt"))) {
            if (path != null) {
                builder.append("Файл/директория успешно создан(а) по пути: ").append(path).append("\n");
            } else {
                builder.append("Файл/директория не создан(а)").append("\n");
            }
            bw.write(String.valueOf(builder));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
