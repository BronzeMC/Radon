/*
 * Copyright (C) 2018 ItzSomebody
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package me.itzsomebody.radon;

import me.itzsomebody.radon.config.ConfigurationParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Main class of obfuscator.
 * @author ItzSomebody
 */
public class Main {
    public static final String PREFIX = "[Radon]";
    public static final String VERSION = "1.0.5";
    public static final String CONTRIBUTORS = "ItzSomebody, x0ark, Col-E, Artel, kazigk, Olexorus and freeasbird";
    public static final String PROPAGANDA_GARBAGE = String.format("Radon is a free and open-source Java obfuscator " +
                    "with contributions from %s.\nVersion: %s\nWebsite: https://github.com/ItzSomebody/Radon",
            Main.CONTRIBUTORS, Main.VERSION);
    public static final String RADON_ASCII_ART = "##############################################\n" +
            "# +----------------------------------------+ #\n" +
            "# |  _____            _____   ____  _   _  | #\n" +
            "# | |  __ \\     /\\   |  __ \\ / __ \\| \\ | | | #\n" +
            "# | | |__) |   /  \\  | |  | | |  | |  \\| | | #\n" +
            "# | |  _  /   / /\\ \\ | |  | | |  | | . ` | | #\n" +
            "# | | | \\ \\  / ____ \\| |__| | |__| | |\\  | | #\n" +
            "# | |_|  \\_\\/_/    \\_\\_____/ \\____/|_| \\_| | #\n" +
            "# |                                        | #\n" +
            "# +----------------------------------------+ #\n" +
            "##############################################\n";

    /**
     * Main method.
     *
     * @param args arguments from command line.
     */
    public static void main(String[] args) {
            File file = new File("config.yml");
            ConfigurationParser config;
            try {
                config = new ConfigurationParser(new FileInputStream(file));
            } catch (FileNotFoundException exc) {
                Logger.stdErr(String.format("Configuration \"%s\" file not found", file.getName()));
                return;
            }

            Radon radon = new Radon(config.createSessionFromConfig());
            radon.run();
    }
}
