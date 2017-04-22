package pl.mberkan.ocp.chapter6;

import java.io.File;

/**
 * @author Marek Berkan
 */
public class AMultiCatch {
    public static void main(String[] args) {
        validMultiCatch();
        invalidMultiCatchDoubleE();
        invalidMultiCatchRelatedClause();
    }

    private static void validMultiCatch() {
        try {
            new File("/tmp/test/").mkdir();
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private static void invalidMultiCatchDoubleE() {
        try {
            new File("/tmp/test/").mkdir();
//        } catch (NullPointerException e | IndexOutOfBoundsException e) { // doesn't compile! -> double e
//            e.printStackTrace();
        } finally {
            // nothing
        }
    }

    private static void invalidMultiCatchRelatedClause() {
        try {
//            throw new IOException();
//        } catch (IOException | FileNotFoundException e) { // doesn't compile! -> related cloause
//            e.printStackTrace();
        } finally {
            // nothing
        }
    }
}
