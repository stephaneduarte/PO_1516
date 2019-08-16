/** @version $Id: ChangeTitle.java,v 1.4 2015/11/28 20:01:27 ist181186 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;

/**
 * §2.2.1.
 */
public class ChangeTitle extends SectionCommand {
	public ChangeTitle(Section sec, Document doc) {
		super(MenuEntry.CHANGE_TITLE, sec, doc);
	}

	@Override
	public final void execute() throws DialogException, IOException {
    		String title = IO.readString(Message.requestSectionTitle());
    		_receiver.changeTitle(title);
	}
}
