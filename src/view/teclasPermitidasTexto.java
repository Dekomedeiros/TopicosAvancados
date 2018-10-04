package view;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class teclasPermitidasTexto extends PlainDocument{
	@Override
	public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException{
		super.insertString(offset, str.replaceAll("[^a-z|^A-Z|^ç|^~|^ |^´]", ""), attr);
	}
	public void replace(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException{
		super.insertString(offset, str.replaceAll("[^a-z|^A-Z|^ç|^~|^ |^´]", ""), attr);
	}
}