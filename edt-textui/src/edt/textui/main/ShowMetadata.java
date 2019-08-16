/** @version $Id: ShowMetadata.java,v 1.8 2015/12/01 11:14:24 ist181186 Exp $ */
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.util.List;
import java.util.ArrayList;

import java.io.IOException;

import edt.core.*;

/**
 * §2.1.2.
 */
public class ShowMetadata extends Command<Editor> {
	
	public ShowMetadata(Editor editor) {
		super(MenuEntry.SHOW_METADATA, editor);
	}

	@Override
	public final void execute() throws DialogException, IOException {
		IO.println(Message.documentTitle((_receiver.getDocument()).getTitle()));
		ArrayList<ArrayList> _authors = (_receiver.getDocument()).getAuthorsInfo();
		for(ArrayList<String> _authorinfo : _authors){
		      IO.println(Message.author(_authorinfo.get(0),_authorinfo.get(1)));
		}
		IO.println(Message.documentSections((_receiver.getDocument()).getNumSections()));
		IO.println(Message.documentBytes((_receiver.getDocument()).calcDimension()));
		IO.println(Message.documentIdentifiers((_receiver.getDocument()).calcIDs()));
	}

}
