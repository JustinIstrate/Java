package org.example;
import java.awt.Desktop;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import com.fasterxml.jackson.databind.ObjectMapper;
public interface Command {
    void executeCommand() throws CommandExecutionException;
}
