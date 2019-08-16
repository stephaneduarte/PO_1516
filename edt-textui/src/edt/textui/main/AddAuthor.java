/** @version $Id: AddAuthor.java,v 1.6 2015/11/30 19:52:52 ist181186 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;

/**
 * §2.1.3.
 */
public class AddAuthor extends Command<Editor> {
	public AddAuthor(Editor editor) {
		super(MenuEntry.ADD_AUTHOR, editor);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	    String name, email;
	    name = IO.readString(Message.requestAuthorName());
	    email = IO.readString(Message.requestEmail());
	    if (_receiver.addAuthor(name,email))
		  IO.println(Message.duplicateAuthor(name));
	}
}
