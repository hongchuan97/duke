package Command;

import AllTask.Task;
import Data.TaskList;
import Exceptions.DukeException;
import Storage.Storage;
import Ui.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {
    private String keyword;
    public FindCommand(String keyword){
        this.keyword = keyword;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ArrayList<Task> newlist = tasks.find(this.keyword , tasks.list());
        ui.showMatch(newlist);

    }
}
