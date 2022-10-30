import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String BASE_DIR = "D:/__Games/";
    private static final StringBuilder logger = new StringBuilder();

    public static void main(String[] args) {
        List<String> fileList = new ArrayList<>();

        fileList.add("src/");
        fileList.add("res/");
        fileList.add("savegames/");
        fileList.add("temp/");
        fileList.add("src/main/");
        fileList.add("src/test/");
        fileList.add("src/main/Main.java");
        fileList.add("src/main/Utils.java");
        fileList.add("res/drawables/");
        fileList.add("res/vectors/");
        fileList.add("res/icons/");
        fileList.add("temp/temp.txt");

        install(fileList);

        writeLogToFile();
    }

    private static void install(List<String> fileList) {
        File tmp;
        for (String s : fileList) {
            tmp = new File(BASE_DIR + s);
            boolean result;
            if (s.endsWith("/")) {
                result = tmp.mkdir();
            } else {
                try {
                    result = tmp.createNewFile();
                    log(tmp, result);

                } catch (IOException e) {
                    e.printStackTrace();
                    result = false;
                }
            }
            log(tmp, result);
        }
    }

    private static void log(File f, boolean result) {
        logger.append("Создание ")
                .append(f.isDirectory() ? "директории " : "файла ")
                .append(f.getAbsolutePath())
                .append(" ")
                .append(result ? "успешно" : "неуспешно")
                .append("\n");
    }

    private static void writeLogToFile() {
        File log = new File(BASE_DIR + "temp/temp.txt");
        try (FileWriter fileWriter = new FileWriter(log)) {
            fileWriter.write(logger.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}