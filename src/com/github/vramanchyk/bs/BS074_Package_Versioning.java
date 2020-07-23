package com.github.vramanchyk.bs;

/**
 * Created by Vitali Ramanchyk on 7/13/20.
 */
public class BS074_Package_Versioning {

    public boolean solve(String older, String newer) {

        String[] partsOlder = older.split("\\.");
        String[] partsNewer = newer.split("\\.");

        for (int index = 0; index < 3; index++) {
            int partNewer = Integer.parseInt(partsNewer[index]);
            int partOlder = Integer.parseInt(partsOlder[index]);

            if (partNewer > partOlder) {
                return true;
            }

            if (partOlder > partNewer) {
                return false;
            }
        }

        return false;
    }
}
