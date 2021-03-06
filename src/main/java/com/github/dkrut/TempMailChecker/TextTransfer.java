package com.github.dkrut.TempMailChecker;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

/**
 * Created by Denis Krutikov on 10.05.2020.
 */

public class TextTransfer implements ClipboardOwner {
    private String data = null;

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
    }

    public void setData(String data){
        StringSelection stringSelection = new StringSelection(data);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, this);
    }

    public String getData() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            data = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}