package org.example;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ReportCommand implements Command {
    private DocumentRepository repo;

    public ReportCommand(DocumentRepository repo) {
        this.repo = repo;
    }

    @Override
    public void executeCommand() throws CommandExecutionException {
        Configuration config = new Configuration(Configuration.VERSION_2_3_31);
        config.setClassForTemplateLoading(ReportCommand.class, "/");
        config.setDefaultEncoding("UTF-8");
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        try {
            Template template = config.getTemplate("report_template.ftl");
            Map<String, Object> data = new HashMap<>();
            data.put("repository", repo);

            StringWriter out = new StringWriter();
            template.process(data, out);

            String reportContent = out.toString();
            Files.write(Paths.get("report.html"), reportContent.getBytes());

            File reportFile = new File("report.html");
            Desktop.getDesktop().open(reportFile);
        } catch (IOException | TemplateException e) {
            throw new CommandExecutionException("Error generating or opening report: " + e.getMessage());
        }
    }
}
