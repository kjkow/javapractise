package chapter6.lawofdemeter;

import java.io.File;

/**
 * Created by kamil on 2017-10-06.
 */
public class Options {
    private File scratchDir;
    private String absolutePath;

    public String getAbsolutePath() {
        return absolutePath;
    }

    public File getScratchDir() {
        return scratchDir;
    }

}
