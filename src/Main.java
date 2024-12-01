import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String filePath = "input.txt";

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2= new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Zeile splitten
                String[] parts = line.trim().split("\\s+");
                if (parts.length == 2) {
                    // Zahlen parsen und in die Listen einfügen
                    list1.add(Integer.parseInt(parts[0]));
                    list2.add(Integer.parseInt(parts[1]));
                }
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }

        Collections.sort(list1);
        Collections.sort(list2);

        List<Integer> similarityScore  = new ArrayList<>();
        Integer result = 0;
        Integer count = 0;
        for(Integer x : list1){

            for(Integer y : list2){
                if(Objects.equals(x, y)){
                    count ++;
                }
            }
            similarityScore.add(count);
            result = result + (x * count);
            count = 0;
        }

        //Part One
        /*List<Integer> distance= new ArrayList<>();
        Integer result = 0;

        for(int i = 0 ; i < list1.size() ; i++) {
            if(list1.get(i) <= list2.get(i)) {
                distance.add(list2.get(i) - list1.get(i));
            } else distance.add(list1.get(i) - list2.get(i));
            result = result + distance.get(i);
        }*/
        System.out.println(result);
    }
}