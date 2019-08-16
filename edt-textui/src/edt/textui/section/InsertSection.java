/** @version $Id: InsertSection.java,v 1.6 2015/11/30 19:52:52 ist181186 Exp $ */
package edt.textui.section;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.DialogException;

import java.io.IOException;

/* FIXME: import core classes here */
import edt.core.*;
/**
 * §2.2.5.
 */
public class InsertSection extends SectionCommand {
  public InsertSection(Section sec, Document doc/* FIXME: decls of argument(s) for receiver(s) */) {
    super(MenuEntry.INSERT_SECTION, sec, doc /* FIXME: receiver(s) */);
  }

  @Override
  public final void execute() throws DialogException, IOException {
    int id = IO.readInteger(Message.requestSectionId());
    String title = IO.readString(Message.requestSectionTitle());
    _receiver.insertSection(title,id);
  }
}
