/** @version $Id: Save.java,v 1.8 2015/12/01 10:53:47 ist181186 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<Editor> {
	public Save(Editor receiver) {
		super(MenuEntry.SAVE, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		    //if (_receiver.hasChanges()){
			if (_receiver.hasAssociatedFile()){
			    String associatedfile = _receiver.getDataFile();
			    _receiver.save(associatedfile);
			}
			else{
			    String filename = IO.readString(Message.newSaveAs());
			    _receiver.save(filename);
			}
		    //}
	}
}
