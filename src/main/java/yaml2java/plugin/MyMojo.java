package yaml2java.plugin;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Goal which touches a timestamp file.
 *
 * @goal touch
 * 
 * @phase process-sources
 */
@Mojo( name = "startParsing",defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class MyMojo extends AbstractMojo{

    @Parameter (required = true)
    private String file2Parse;

    @Parameter (required = true)
    private String outputDir;

    /**
     * @parameter default-value="${project}"
     * @required
     * @readonly
     */

    public void execute() throws MojoExecutionException {
    Parser p = new Parser();
    new Utils().deleteAllFiles(outputDir);
        try {
            p.startParsing(new Yaml(),file2Parse,outputDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
