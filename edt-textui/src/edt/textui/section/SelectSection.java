/** @version $Id: SelectSection.java,v 1.4 2015/11/29 21:56:45 ist181186 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;
/* FIXME: import core classes here */

/**
 * §2.2.4.
 */
public class SelectSection extends SectionCommand {
	public SelectSection(Section sec, Document doc) {
		super(MenuEntry.SELECT_SECTION, sec, doc);
	}

	@Override
	public final void execute() throws DialogException, IOException  {
	 	int id = IO.readInteger(Message.requestSectionId());
	 	try{
		    Section newReceiver = _receiver.selectSection(id);
		    IO.println(Message.newActiveSection(id));
		    edt.textui.section.MenuBuilder.menuFor(newReceiver,_receiver2);
		}
		catch(NoSuchSectionException e) {
		    IO.println(Message.noSuchSection(id));
		}
	}
}
