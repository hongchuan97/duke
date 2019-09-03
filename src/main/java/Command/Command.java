package Command;

import Data.TaskList;
import Exceptions.DukeException;
import Storage.Storage;
import Ui.Ui;

public abstract class Command {
    public boolean isExit(){
        return false;
    }

    abstract public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
}
