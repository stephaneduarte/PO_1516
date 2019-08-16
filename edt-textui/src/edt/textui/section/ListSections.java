/** @version $Id: ListSections.java,v 1.4 2015/11/30 00:33:29 ist181186 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;

/**
 * §2.2.2.
 */
public class ListSections extends SectionCommand {
	public ListSections(Section sec, Document doc/* FIXME: decls of argument(s) for receiver(s) */) {
		super(MenuEntry.LIST_SECTIONS, sec, doc/* FIXME: receiver(s) */);
	}

	@Override
	public final void execute() throws DialogException, IOException {
    		Visitor v = new ListSectionVisitor();
    		String _content = _receiver.accept(v);
    		try{
		  IO.println(_content.substring(0, _content.length() - 1));
		}
		catch(StringIndexOutOfBoundsException e){}
	}
}
