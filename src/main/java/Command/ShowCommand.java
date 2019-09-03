package Command;

import Data.TaskList;
import Exceptions.DukeException;
import Storage.Storage;
import Ui.Ui;

public class ShowCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
            ui.showList(tasks.list());
    }
}
