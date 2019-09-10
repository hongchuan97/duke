package Command;

import AllTask.Task;
import Data.TaskList;
import Exceptions.DukeException;
import Storage.Storage;
import Ui.Ui;

public class DoneCommand extends Command {
    private int index;

    public DoneCommand(int index) {
        this.index = index - 1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            Task done = tasks.doneTask(this.index);
            ui.showDone(done);
            storage.saveFile(tasks.list());
        } catch (DukeException e) {
            throw e;
        }
    }
}
