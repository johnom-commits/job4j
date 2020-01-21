package io;

import org.apache.commons.cli.*;
import java.util.HashMap;
import java.util.Map;

public class Parsing {
    private Map<String, String> mapArgs = new HashMap<>();

    public Parsing(String[] args) throws ParseException {
        parsingArgs(args);
    }

    private void parsingArgs(String[] args) throws ParseException {
        Option directory = new Option("d", "directory", true, "Директория, в которой начинать поиск.");
        directory.setArgs(1);
        Option name = new Option("n", "name", true, "Имя файл, маска, либо регулярное выражение.");
        name.setArgs(1);
        Option output = new Option("o", "output", true, "Путь и имя файла с результатами.");
        output.setArgs(1);

        Options opts = new Options();
        opts.addOption(directory);
        opts.addOption(name);
        opts.addOption(output);
        OptionGroup group = new OptionGroup();
        group.addOption(new Option("f", false, "Поиск по полному имени файла"));
        group.addOption(new Option("m", false, "Поиск по маске"));
        group.addOption(new Option("r", false, "Поиск по регулярному сообщению"));
        opts.addOptionGroup(group);

        var parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(opts, args);
        } catch (ParseException e) {
            help(opts);
            System.err.println("Parsing failed. Reason: " + e.getMessage());
        }

        if (cmd.hasOption("d")) {
            mapArgs.put("d", cmd.getOptionValue("d"));
        } else {
            help(opts);
            throw new ParseException("Не указана опция -d");
        }

        if (cmd.hasOption("n")) {
            String[] n = cmd.getOptionValues("n");
            mapArgs.put("n", n[0]);
        } else {
            help(opts);
            throw new ParseException("Не указана опция -n");
        }

        if (cmd.hasOption("m")) {
            mapArgs.put("typeName", "-m");
        } else if (cmd.hasOption("f")) {
            mapArgs.put("typeName", "-f");
        } else if (cmd.hasOption("r")) {
            mapArgs.put("typeName", "-r");
        } else {
            help(opts);
            throw new ParseException("Не указана опция -m или -f или -r");
        }

        if (cmd.hasOption("o")) {
            mapArgs.put("o", cmd.getOptionValue("o"));
        } else {
            help(opts);
            throw new ParseException("Не указана опция -о");
        }
    }

    private void help(Options opts) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("find", opts);
    }

    public String directory() {
        return mapArgs.get("d");
    }

    public String name() {
        return mapArgs.get("n");
    }

    public String typeName() {
        return mapArgs.get("typeName");
    }

    public String output() {
        return mapArgs.get("o");
    }
}
