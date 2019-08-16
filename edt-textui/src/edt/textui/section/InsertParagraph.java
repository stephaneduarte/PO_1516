/** @version $Id: InsertParagraph.java,v 1.6 2015/11/30 19:52:52 ist181186 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;
/* FIXME: import core classes here */

/**
 * §2.2.8.
 */
public class InsertParagraph extends SectionCommand {
	public InsertParagraph(Section sec, Document doc) {
		super(MenuEntry.INSERT_PARAGRAPH, sec, doc);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		int id = IO.readInteger(Message.requestParagraphId());
		String content = IO.readString(Message.requestParagraphContent());
		_receiver.insertParagraph(content,id);
	}

}
