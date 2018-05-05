package com.kennyyou.project_1;

/**
 * Created by Kenny You on 3/26/2018.
 */

import java.util.LinkedList;

public final class ResortList extends LinkedList<Resort> {

    private static ResortList instance = null;

    private ResortList() {
        // Exists only to defeat additional instantiations.
    }

    public static ResortList getInstance() {
        if (instance == null)
            instance = new ResortList();

        return instance;
    }

} // end ResortList
