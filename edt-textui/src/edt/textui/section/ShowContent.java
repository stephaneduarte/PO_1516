/** @version $Id: ShowContent.java,v 1.4 2015/11/30 01:40:06 ist181186 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;
import edt.textui.*;

/**
 * §2.2.3.
 */
public class ShowContent extends SectionCommand {
	public ShowContent(Section sec, Document doc/* FIXME: decls of argument(s) for receiver(s) */) {
		super(MenuEntry.SHOW_CONTENT, sec, doc/* FIXME: receiver(s) */);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	  	Visitor v = new ContentVisitor();
	  	String _content = _receiver.accept(v);
	  	try{
		  IO.println(_content.substring(0, _content.length() - 1));
		}
		catch(StringIndexOutOfBoundsException e){}
	}
}
