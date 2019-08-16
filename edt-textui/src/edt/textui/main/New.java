/** @version $Id: New.java,v 1.6 2015/11/16 11:54:29 ist181186 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;


/**
 * Open a new document.
 */
public class New extends Command<Editor> {
	public New(Editor receiver) {
		super(MenuEntry.NEW, receiver);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		_receiver.NewDocument();
	}

}
