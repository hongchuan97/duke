package Storage;

import AllTask.Deadline;
import AllTask.Event;
import AllTask.Task;
import AllTask.ToDos;
import Exceptions.DukeException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String filePath;
    public Storage(String filePath){
        this.filePath = filePath;
    }
    public ArrayList<Task> load() throws DukeException{
        ArrayList<Task> list = new ArrayList<>();
        try{
            File fw = new File(filePath);
            Scanner fileReader = new Scanner(fw);

            while (fileReader.hasNext()){
                String[] component = fileReader.nextLine().split(" \\| ");
                switch (component[0]){
                    case "T" :
                        Task todo = new ToDos(component[2] , "true".equals(component[1]));
                        list.add(todo);
                        break;
                    case "D" :
                        Task deadline = new Deadline(component[2] , "true".equals(component[1]) , component[3]);
                        list.add(deadline);
                        break;
                    case "E" :
                        Task event = new Event(component[2] , "true".equals(component[1]) , component[3] ,component[4]);
                        list.add(event);
                        break;
                }
            }
            return list;
        }catch(Exception e){
            throw new DukeException(e.getMessage());
        }

    }
    public void saveFile(ArrayList<Task> list) throws DukeException {
        File f = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(f);
            for (Task t : list) {
                String line;
                if (t instanceof Deadline) {
                    line = ((Deadline) t).saveFormat();
                } else if (t instanceof ToDos) {
                    line = ((ToDos) t).saveFormat();
                } else {
                    line = ((Event) t).saveFormat();
                }
                fileWriter.write(line + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new DukeException("File not found: " + e.getMessage());
        }
    }

}
