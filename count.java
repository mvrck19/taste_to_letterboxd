import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class count {
    public static void main(String[] args) throws IOException {
        File html = new File("C:\\Users\\phaid\\OneDrive\\Υπολογιστής\\folder\\ratings.txt");
        File txt = new File("C:\\Users\\phaid\\OneDrive\\Υπολογιστής\\folder\\output.txt");
        Scanner scanner = new Scanner(html);
        FileWriter writer = new FileWriter(txt);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("styles_name__206XZ")) {
                System.out.print(removeTags(line)+",");
                writer.write(removeTags(line)+",");
            }
            if (line.contains("styles_userRating__36Tor")) {
                System.out.println(rating(line));
                writer.write(rating(line)+"\n");
            }
        }
        scanner.close();
        writer.close();
    }
    private static String rating(String str) {
        String data="";
        if (str.contains("Meh")) data="2.5";
        else if (str.contains("Awful")) data= "1";
        else if (str.contains("Good")) data= "4";
        else if (str.contains("Amazing")) data= "5";
        return data;
    }
    public static String removeTags(String str) {
        String data = str.substring(56);
        data = data.substring(0,data.length()-6);
        // System.out.println(data);
        return data;
    }
}

