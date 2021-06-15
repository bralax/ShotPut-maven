package io.github.bralax.shotput.maven;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.slf4j.Logger;

import io.github.bralax.shotput.Config;
import io.github.bralax.shotput.Shotput;

@Mojo( name="apidoc" )
public class MyMojo extends AbstractMojo {

    @Parameter(defaultValue = "src/main/java")
    public File srcDir;

    @Parameter(defaultValue = "docs/")
    public File outputDir;

    @Parameter(defaultValue = "false")
    public Boolean generateExcel;

    @Parameter(defaultValue = "false")
    public Boolean generateHTML;

    @Parameter(defaultValue = "false")
    public Boolean generateOpenAPI;

    @Parameter
    public List<String> languages;

    @Parameter(defaultValue = "Documentation")
    public String title;

    @Parameter
    public String intro;

    @Parameter(defaultValue = "http://localhost:3000")
    public String baseURL;

    @Parameter
    public String description;

    @Parameter(defaultValue = "true")
    public boolean interactive;

    @Parameter
    public String logo;

    public void execute() throws MojoExecutionException, MojoFailureException {
        Logger logger = new MavenLogger(getLog());
        Shotput.setLogger(logger);
        Config config = new Config();
        config.languages = this.languages;
        config.title = this.title;
        config.intro = this.intro;
        config.baseUrl = this.baseURL;
        config.description = this.description;
        config.interactive = this.interactive;
        config.logo = this.logo;
        Shotput shot = new Shotput(config, srcDir, generateExcel, generateHTML, generateOpenAPI, outputDir);
        try {
            shot.start();
        } catch (IOException ex) {
            throw new MojoFailureException(ex, "File not found!", ex.getStackTrace().toString());
        }
    }
}
