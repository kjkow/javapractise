package chapter6.lawofdemeter;


import java.io.BufferedOutputStream;

/**
 * Created by kamil on 2017-10-06.
 */
public class Txt {
    private Options options;

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public String getAbsolutePathOfScratchDirectoryOption() {
        return null;
    }

    public Options getScratchDirectoryOption() {
        return options;
    }

    public BufferedOutputStream createScratchFileStream(String classFileName) {
        return null;
    }
}
