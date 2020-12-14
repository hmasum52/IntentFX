/*
 * Copyright (c) $today.year.Hasan Masum
 * Email : connectwithmasum@gmail.com
 *  Github: https://github.com/Hmasum18
 *  You can copy the code but please give due credit to the author
 * This code is under MIT LICENSE
 */

package example.res.fxml;

import java.net.URL;

public class FXML {
    public URL getURLByName(String name){
        return getClass().getResource(name);
    }
}
