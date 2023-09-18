package MeiDOTAnaka.Services;

import org.jetbrains.annotations.NotNull;

import java.io.File;

public class ProjectStructureGenerator {
    static int spaces = 0;
    static int directory_spaces = 0;
    static String space = " ";

    public static void main(String[] args) {
        File currentDir = new File("./src");
        displayDirectory(currentDir);
    }

    public static void displayDirectory(@NotNull File dir) {
        File[] files = dir.listFiles();

        // For-each loop for iteration
        for (File file : files) {

            // Checking of file inside directory
            if (file.isDirectory()) {

                // Display directories inside directory

                if (directory_spaces > 0)  System.out.println(space.repeat(directory_spaces) + "|" + space.repeat(spaces - directory_spaces) + "|---+ " + file.getName());
                else System.out.println(space.repeat(spaces) + "|---+ " + file.getName());

                if (file.getName().equals("GUI_Components")) directory_spaces = spaces;

                spaces += 4;
                displayDirectory(file);

            } else {
                if (directory_spaces > 0 && (spaces - directory_spaces) >= 4)  System.out.println(space.repeat(directory_spaces) + "|" + space.repeat(spaces - directory_spaces) + "|---+ " + file.getName());
                else System.out.println(space.repeat(spaces) + "|---#> " + file.getName());
            }

        }
        System.out.println(space.repeat(directory_spaces) + "|");
        if (spaces >= 4 ) spaces = spaces -4;
    }
}
