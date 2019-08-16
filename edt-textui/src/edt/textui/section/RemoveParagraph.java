/** @version $Id: RemoveParagraph.java,v 1.3 2015/11/29 21:56:45 ist181186 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */
import edt.core.*;
/**
 * §2.2.11.
 */
public class RemoveParagraph extends SectionCommand {
	public RemoveParagraph(Section sec, Document doc/* FIXME: decls of argument(s) for receiver(s) */) {
		super(MenuEntry.REMOVE_PARAGRAPH, sec, doc/* FIXME: receiver(s) */);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	    int id = IO.readInteger(Message.requestParagraphId());
	    try{
      		_receiver2.removeId(_receiver.removeParagraph(id));
	    }
	    catch(NoSuchParagraphException e){
		IO.println(Message.noSuchParagraph(id));
	    }
	}

}
