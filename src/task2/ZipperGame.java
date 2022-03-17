package task2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipperGame {
    public static void zipFiles(String desPath, List<String> packedObjectsPaths) {
        for (String path : packedObjectsPaths) {
            try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(desPath));
                 BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path))) {
                ZipEntry entry = new ZipEntry(path);
                zos.putNextEntry(entry);

                byte[] buffer = new byte[bis.available()];
                bis.read(buffer);
                zos.write(buffer);

                zos.closeEntry();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
