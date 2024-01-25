package exercise;

import java.util.Arrays;

// BEGIN
public class App {

    public static void main(String[] args) {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };

        System.out.println(Arrays.deepToString(image));
        String[][] enlargedImage = App.enlargeArrayImage(image);
        System.out.println(Arrays.deepToString(enlargedImage));
    }
    public static String[][] enlargeArrayImage(String[][] image) {
        int numCols = image[0].length;

        return Arrays.stream(image)
                .flatMap(row -> {
                    String[] newRow = new String[numCols * 2];

                    for (var i = 0; i <numCols; i += 1) {
                        var pixel = row[i];
                        newRow[i * 2] = pixel;
                        newRow[i * 2 + 1] = pixel;
                    }

                    return Arrays.stream(new String[][] {newRow, newRow});
                })
                .toArray(String[][]::new);
    }
}
// END
