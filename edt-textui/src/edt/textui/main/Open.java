/** @version $Id: Open.java,v 1.6 2015/12/01 10:53:47 ist181186 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;

/* FIXME: import core classes here */

/**
 * Open existing document.
 */
public class Open extends Command<Editor> {
	public Open(Editor receiver) {
		super(MenuEntry.OPEN, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	    String file_Name = IO.readString(Message.openFile());
	    if(!(_receiver.open(file_Name)))
		 IO.println(Message.fileNotFound());
	}
}
