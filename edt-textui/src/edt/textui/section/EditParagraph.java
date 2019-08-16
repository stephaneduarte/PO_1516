/** @version $Id: EditParagraph.java,v 1.3 2015/11/29 21:56:45 ist181186 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;
/* FIXME: import core classes here */

/**
 * §2.2.10.
 */
public class EditParagraph extends SectionCommand {
	public EditParagraph(Section sec, Document doc/* FIXME: decls of argument(s) for receiver(s) */) {
		super(MenuEntry.EDIT_PARAGRAPH, sec, doc/* FIXME: receiver(s) */);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	  	int id = IO.readInteger(Message.requestParagraphId());
	  	String content = IO.readString(Message.requestParagraphContent());
	  	try{
		    _receiver.changeParagraphContent(id, content);
		}
		catch(NoSuchParagraphException e){
		    IO.println(Message.noSuchParagraph(id));
		}
	}

}
