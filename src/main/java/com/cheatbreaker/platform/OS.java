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

import java.util.Arrays;
import java.util.List;

public enum OS {
    LINUX("linux", "unix"),
    MACOS("mac"),
    SOLARIS("solaris", "sunos"),
    WINDOWS("win"),
    UNKNOWN();

    public static final OS[] VALUES = values();
    private final List<String> names;

    OS(String... names) {
        this.names = Arrays.asList(names);
    }

    public static OS current() {
        final String name = System.getProperty("os.name").toLowerCase();
        return Arrays.stream(VALUES).filter(os -> os.names.contains(name)).findFirst().orElse(UNKNOWN);
    }
}
