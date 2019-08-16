/** @version $Id: ShowIndex.java,v 1.7 2015/12/01 11:14:24 ist181186 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;
import java.util.List;
import java.util.ArrayList;

import java.io.IOException;

import edt.core.*;

/**
 * §2.1.4.
 */
public class ShowIndex extends Command<Editor> {
	public ShowIndex(Editor editor) {
		super(MenuEntry.SHOW_INDEX, editor);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		IO.println("{"+(_receiver.getDocument()).getTitle()+"}");
		ArrayList<ArrayList> _sections = (_receiver.getDocument()).getSubsectionsInfo();
		for (ArrayList<String> section : _sections){
		    IO.println(Message.sectionIndexEntry(section.get(0), section.get(1)));
		}
	}
}
