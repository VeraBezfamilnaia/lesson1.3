package task2;

import java.io.File;
import java.util.List;

public class Main {
    private static final String PROGRESS_1_PATH = "../Games/savegames/progress1.txt";
    private static final String PROGRESS_2_PATH = "../Games/savegames/progress2.txt";
    private static final String PROGRESS_3_PATH = "../Games/savegames/progress3.txt";
    private static final String ARCHIVE_PATH = "../Games/savegames/zip.zip";

    public static void main(String[] args) {
        GameProgress progress1 = new GameProgress(99, 12, 8, 25);
        GameProgress progress2 = new GameProgress(16, 0, 18, 560);
        GameProgress progress3 = new GameProgress(2, 1, 2, 5);


        SaverGame.saveGame(PROGRESS_1_PATH, progress1);
        SaverGame.saveGame(PROGRESS_2_PATH, progress2);
        SaverGame.saveGame(PROGRESS_3_PATH, progress3);

        List<String> filesPaths = List.of(PROGRESS_1_PATH, PROGRESS_2_PATH, PROGRESS_3_PATH);
        ZipperGame.zipFiles(ARCHIVE_PATH, filesPaths);

        deleteFiles(filesPaths);
    }

    private static void deleteFiles(List<String> filesPaths) {
        for (String path : filesPaths) {
            new File(path).delete();
        }
    }
}
