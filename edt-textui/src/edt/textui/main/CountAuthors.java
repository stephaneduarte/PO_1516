
package edt.textui.main;

import static ist.po.ui.Dialog.IO;
import ist.po.ui.Command;
import ist.po.ui.DialogException;

import java.io.IOException;

import edt.core.*;

/**
 * §2.1.3.
 */
public class CountAuthors extends Command<Editor> {
	public CountAuthors(Editor editor) {
		super("Contar autores", editor);
	}

	@Override
	public final void execute() throws DialogException, IOException {
	   IO.println((_receiver.getDocument()).countAuthors());
	}
}
