import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static final String BASE_DIR = "D:\\Games\\";
    private static final StringBuilder logger = new StringBuilder();

    public static void main(String[] args) {
        File baseDir = new File(BASE_DIR);

        createDir("src");
        createDir("res");
        createDir("savegames");
        createDir("temp");

        createDir("src\\main");
        createDir("src\\test");

        createFile("src\\main\\Main.java");
        createFile("src\\main\\Utils.java");

        createDir("res\\drawables");
        createDir("res\\vectors");
        createDir("res\\icons");

        createFile("temp\\temp.txt");

        writeLogToFile();
    }

    private static void log(File f, boolean result) {
        logger.append("Создание ")
                .append(f.isDirectory() ? "директории " : "файла ")
                .append(f.getAbsolutePath())
                .append(" ")
                .append(result ? "успешно" : "неуспешно")
                .append("\n");
    }

    private static void createDir(String path) {
        File tmp = new File(BASE_DIR + path);
        boolean result = tmp.mkdir();
        log(tmp, result);
    }

    private static void createFile(String path) {
        File tmp = new File(BASE_DIR + path);
        boolean result;
        try {
            result = tmp.createNewFile();
            log(tmp, result);

        } catch (IOException e) {
            log(tmp, false);
        }
    }

    private static void writeLogToFile() {
        File log = new File(BASE_DIR + "temp\\temp.txt");
        try (FileWriter fileWriter = new FileWriter(log)) {
            fileWriter.write(logger.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}