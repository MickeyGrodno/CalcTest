import java.io.*;
import java.util.ArrayList;

public class Calc {
    public static void main(String[] args) throws IOException {
        try {
            creatfile();
            setValues("123","321");
            calculate();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void creatfile() throws IOException {

        File dir = new File("C:\\JavaTest");
        dir.mkdir();
        File textFile = new File("C:\\JavaTest\\Calc.txt");
        textFile.createNewFile();
    }

    public static void setValues(String a, String b) throws IOException {
            try (FileWriter writer = new FileWriter("C:\\JavaTest\\Calc.txt", true))
            {
            writer.write(a);
            writer.write("\r\n");
            writer.write(b);
            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void calculate() throws IOException {

        BufferedReader reader = new BufferedReader (new FileReader("C:\\JavaTest\\Calc.txt"));
        BufferedWriter writer = new BufferedWriter (new FileWriter("C:\\JavaTest\\Calc.txt", true));
        ArrayList<Integer> arr = new ArrayList<>();
        String c;
        int x = 0;
        while ((c = reader.readLine()) != null) {

            arr.add(Integer.valueOf(c));
        }
        for (Integer num : arr) {
            x = x + num;
        }
        writer.append("\r\n");
        writer.write(String.valueOf(x));
        writer.close();


    }
}
