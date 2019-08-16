
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;

/**
 * §2.1.3.
 */
public class CleanAll extends Command<Editor> {
	public CleanAll(Editor editor) {
		super("Limpar documento", editor);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	   Document doc = _receiver.getDocument();
	   doc.removeTextElements(doc.cleanThis());
	   doc.removeAuthors();
	   IO.println("Toda a informação foi removida.");
	}
}
