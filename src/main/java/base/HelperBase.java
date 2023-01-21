package base;

import java.io.IOException;

public interface HelperBase {

	public int takeSnap() throws IOException;

    public String getProperty(String propertyName);
}
