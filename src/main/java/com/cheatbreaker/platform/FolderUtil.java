/**
 * The LGPL License
 * <p>
 * Copyright (C) 2019-2025 CheatBreaker.net
 * <p>
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 */

package com.cheatbreaker.platform;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FolderUtil {
    public static void openDirectory(File directory) throws IOException, IllegalArgumentException, UnsupportedOperationException {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(directory);
        } else {
            String absolutePath = directory.getAbsolutePath();
            try {
                switch (OS.current()) {
                    case MACOS:
                    case LINUX:
                    case SOLARIS:
                        Runtime.getRuntime().exec(new String[]{"/usr/bin/open", absolutePath});
                        break;
                    case WINDOWS:
                        Runtime.getRuntime().exec(String.format("cmd.exe /C start \"Open file\" \"%s\"", absolutePath));
                        break;
                    default:
                        Runtime.getRuntime().exec("file://" + absolutePath);
                }
            } catch (IOException exception) {
                System.out.println("Couldn't open file");
                exception.printStackTrace();
            }
        }
    }
}
