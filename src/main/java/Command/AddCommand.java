package Command;

import AllTask.Task;
import Data.TaskList;
import Exceptions.DukeException;
import Storage.Storage;
import Ui.Ui;

public class AddCommand extends Command {
    private Task add;
    public AddCommand(Task add){
        this.add = add;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.addTask(this.add);
        ui.showAdded(this.add);
        ui.showSize(tasks.list());
    }
}
