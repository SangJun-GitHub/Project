package spring3;

/**
 * Created by bobsang89@gmail.com on 2018-09-15
 * Project: blog
 * Github : http://github.com/SangJun-GitHub
 */
public class VersionPrinter {

    public int getMajorVersion() {
        return majorVersion;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    private int majorVersion;
    private int minorVersion;

    public void print(){
        System.out.println("This program version is "+ getMajorVersion() + "." + getMinorVersion());
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }
}
