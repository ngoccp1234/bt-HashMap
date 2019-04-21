package mainthread;

import java.io.*;
import java.util.ArrayList;

public class PrintListVideo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/tomT.txt"));
        ArrayList<String> list = new ArrayList<>();
        String current;
        while ((current = br.readLine()) != null) {
            list.add(current);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        br.close();
    }
}
