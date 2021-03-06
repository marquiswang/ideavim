package com.maddyhome.idea.vim.ui;

/*
 * IdeaVim - A Vim emulator plugin for IntelliJ Idea
 * Copyright (C) 2003-2005 Rick Maddy
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

/**
 * This is a utility class for working with the system clipboard
 */
public class ClipboardHandler {
  /**
   * Returns the string currently on the system clipboard.
   *
   * @return The clipboard string or null if data isn't plain text
   */
  public static String getClipboardText() {
    String res = null;
    try {
      Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
      Transferable trans = board.getContents(null);
      Object data = trans.getTransferData(DataFlavor.stringFlavor);

      if (data != null) {
        res = data.toString();
      }
    }
    catch (HeadlessException e) {
      // ignore
    }
    catch (UnsupportedFlavorException e) {
      // ignore
    }
    catch (IOException e) {
      // ignore
    }

    return res;
  }

  /**
   * Puts the supplied text into the system clipboard
   *
   * @param text The text to add to the clipboard
   */
  public static void setClipboardText(String text) {
    try {
      Clipboard board = Toolkit.getDefaultToolkit().getSystemClipboard();
      StringSelection data = new StringSelection(text);
      board.setContents(data, null);
    }
    catch (HeadlessException e) {
      // ignore
    }
  }
}
