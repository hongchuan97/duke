import Command.Command;
import Data.TaskList;
import Exceptions.DukeException;
import Parser.Parser;
import Storage.Storage;
import Ui.Ui;

import java.util.StringTokenizer;


public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public static void main(String[] args) {
        new Duke(".\\src\\main\\java\\Data\\duke.txt").run();
    }

    /**
     * Load all requirement before running duke.
     *
     * @param filePath String of path to file that contains task list.
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /**
     * Run Duke.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                StringTokenizer fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }


}
