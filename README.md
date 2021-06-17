# ShotPut Maven
## What is this?
This is a maven plugin connected to [ShotPut](https://github.com/bralax/ShotPut). It allows you to generate documentation as a maven task.

## How To Use
This plugin can be easily added to a pom.xml file.
Just add the following to your `pom.xml` file.
```XML
<build>
    <plugins>
      <plugin>
        <groupId>io.github.bralax</groupId>
        <artifactId>shotput-maven-plugin</artifactId>
        <version>0.1</version>
      </plugin>
    </plugins>
  </build>
```

The system offers a number of options you can configure for the resulting output.
To do so, change the `pom.xml` with the following options. Each configuration option has a default value specified.
```XML
<plugin>
  <groupId>io.github.bralax</groupId>
  <artifactId>shotput-maven-pluginn</artifactId>
  <version>0.1</version>
  <configuration>
    <srcDir>src</srcDir> <!-- Default: src/main/java/-->
    <outDir>apidocs</outDir> <!-- Default: docs-->
    <generateExcel>true</generateExcel> <!-- Default: false-->
    <generateHTML>true</generateHTML> <!-- Default: false-->
    <generateOpenAPI>true</generateOpenAPI> <!-- Default: false-->
    <languages>  <!-- Default: []-->
        <param>java</param>
    </languages>
    <title>My Docs</title> <!-- Default: Documentation -->
    <intro>Intro Text</intro> <!-- Default: '' -->
    <baseURL>https://example.com</baseURL> <!-- Default: http://localhost:3000 -->
    <description>Doc Description</description> <!-- Default: '' -->
    <interactive>false</interactive> <!-- Default: true -->
    <disableMethodParsing>true</disableMethodParsing> <!-- Default: false -->
    <logo>src/main/resources/img.png</log> <!-- Default: '' -->
  </configuration>
</plugin>
```

## Documenting
See the [ShotPut Documentation](https://github.com/bralax/ShotPut) on how to document your endpoints