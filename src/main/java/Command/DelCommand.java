package Command;

import AllTask.Task;
import Data.TaskList;
import Exceptions.DukeException;
import Storage.Storage;
import Ui.Ui;

public class DelCommand extends Command {
    private int index;
    public DelCommand(int index){
        this.index = index - 1;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task del = tasks.delTask(this.index);
        ui.showDel(del);
        ui.showSize(tasks.list());
    }
}
