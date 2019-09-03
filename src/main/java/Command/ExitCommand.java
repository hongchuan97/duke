package Command;

import Data.TaskList;
import Exceptions.DukeException;
import Storage.Storage;
import Ui.Ui;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Ui.showExit();
    }

    @Override
    public boolean isExit(){
        return true;
    }
}
