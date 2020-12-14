/*
 * Copyright (c) $today.year.Hasan Masum
 * Email : connectwithmasum@gmail.com
 *  Github: https://github.com/Hmasum18
 *  You can copy the code but please give due credit to the author
 * This code is under MIT LICENSE
 */

package example.res.image;

import java.io.InputStream;
import java.net.URL;

public class IMAGE {
    public URL getURLByName(String name){
        return getClass().getResource(name);
    }

    public String getPathByName(String name){
        return getClass().getResource(name).toString();
    }

    public InputStream getInputStreamByName(String name){
        return getClass().getResourceAsStream(name);
    }
}
