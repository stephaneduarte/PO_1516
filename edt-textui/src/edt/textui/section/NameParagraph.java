/** @version $Id: NameParagraph.java,v 1.3 2015/11/29 17:56:57 ist181186 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;
/* FIXME: import core classes here */

/**
 * §2.2.9.
 */
public class NameParagraph extends SectionCommand {
  public NameParagraph(Section sec, Document doc/* FIXME: decls of argument(s) for receiver(s) */) {
    super(MenuEntry.NAME_PARAGRAPH, sec, doc/* FIXME: receiver(s) */);
  }

  @Override
  public final void execute() throws DialogException, IOException {
      int id_local = IO.readInteger(Message.requestParagraphId());
      String id_uniq = IO.readString(Message.requestUniqueId());
      try{
	    Paragraph paragraph = _receiver.selectParagraph(id_local);
	    if (paragraph.getID() != "")
		 IO.println(Message.paragraphNameChanged());
	    _receiver2.changeTextElement(id_uniq, paragraph);
      }
      catch (NoSuchParagraphException e){
	    IO.println(Message.noSuchParagraph(id_local));
      }
  }
}
