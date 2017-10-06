package chapter6.lawofdemeter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by kamil on 2017-10-06.
 * Law of Demeter says that method f from class C should be only called by:
 * class C
 * object created by f
 * object passed as an argument to f
 * object placed in class C variable
 */
public class LawOfDemeter {
    public static void main(String[] args) throws FileNotFoundException {
        //take an examlpe:
        Txt ctxt = new Txt();

        final String outputDir = ctxt.getOptions().getScratchDir().getAbsolutePath();
        //this looks like train wreckage and is no good

        Options options = ctxt.getOptions();
        File scratchDir = options.getScratchDir();
        final String outDir = scratchDir.getAbsolutePath();
        //better? it depends if ctxt, Options and ScratchDir are objects or data structures
        //if objects, then knowledge of whats inside them is breaking Demeter's law
        //if they would be data structures, then there would be no question about Demeter's law, but they'd be like this:
        // final String outputDir = ctxt.options.scratchDir.absolutePath;
        // BUT some standards require that even data structures must have accesors and mutators, like beans
        //so there are classes that are hybrides and they are bad news


        //so assume that ctxt, options and scratchDir are objects. they should hide their insides
        ctxt.getAbsolutePathOfScratchDirectoryOption();
        //or
        ctxt.getScratchDirectoryOption().getAbsolutePath();

        //second one returns data structure, both don't look good

        //why we use ctxt object? let's take a look
        String classFileName = "";
        String outFile = outputDir + "/" + classFileName.replace(".", "/") + ".class";
        FileOutputStream fout = new FileOutputStream(outFile);
        BufferedOutputStream bos = new BufferedOutputStream(fout);
        //this code is poorly written but what we must observe is that outputDir was only needed to create file stream
        //having that information:

        BufferedOutputStream bous = ctxt.createScratchFileStream(classFileName);
        //looks like simple operation that object can do. hides object's details and law of demeter is obeyed
    }
}
