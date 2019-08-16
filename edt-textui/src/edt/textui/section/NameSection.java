/** @version $Id: NameSection.java,v 1.4 2015/11/30 15:39:30 ist181186 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;
/* FIXME: import core classes here */

/**
 * §2.2.6.
 */
public class NameSection extends SectionCommand {
  public NameSection(Section sec, Document doc/* FIXME: decls of argument(s) for receiver(s) */) {
    super(MenuEntry.NAME_SECTION, sec, doc /* FIXME: receiver(s) */);
  }

  @Override
  public final void execute() throws DialogException, IOException {
      int id_local = IO.readInteger(Message.requestSectionId());
      String id_uniq = IO.readString(Message.requestUniqueId());
      try{
	    if (_receiver2.changeTextElement(id_uniq, _receiver.selectSection(id_local)))
		 IO.println(Message.sectionNameChanged());
      }
      catch (NoSuchSectionException e){
	    IO.println(Message.noSuchSection(id_local));
      }
  }
}
