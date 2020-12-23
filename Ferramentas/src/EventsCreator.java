import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EventsCreator {

    public static void main(String[] args) {
        create("events.txt");
        try {
            FileWriter myWriter = new FileWriter("events.txt");
            myWriter.write("Events.nrof = 100\n");
            myWriter.write("###################################\n");
            int k = 0;
            for (int i = 0; i<=99; i++){
                myWriter.write("Events"+(i+1)+".class = MessageEventGenerator\n");
                myWriter.write("Events"+(i+1)+".interval = 60,60\n");
                myWriter.write("Events"+(i+1)+".size = 10k,10k\n");
                myWriter.write("Events"+(i+1)+".hosts = "+i+","+i+"\n");
                myWriter.write("Events"+(i+1)+".tohosts = 100,105\n");
                myWriter.write("Events"+(i+1)+".prefix = M"+k+"\n");
                myWriter.write("Events"+(i+1)+".time = 0, 600\n");
                myWriter.write("###################################\n");
                k++;
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void create(String path){
        try {
            File myObj = new File(path);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists. Deleting...");
                myObj.delete();
                myObj.createNewFile();
                System.out.println("File created: " + myObj.getName());

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
