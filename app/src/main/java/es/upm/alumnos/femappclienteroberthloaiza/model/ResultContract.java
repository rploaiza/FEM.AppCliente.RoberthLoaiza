package es.upm.alumnos.femappclienteroberthloaiza.model;

import android.provider.BaseColumns;

/**
 * Created by Usuario on 29/10/2017.
 */

public class ResultContract {

    public static class licorsTable implements BaseColumns {
        public final static String TABLE_NAME = "licors";
        public final static String COLUMN_NAME_ID = _ID;
        public final static String COLUMN_NAME_LICORS_ID = "licorsId";
        public final static String COLUMN_NAME_LICORS_NAME = "name";
        public final static String COLUMN_NAME_LICORS_TAGS = "tags";
        public final static String COLUMN_NAME_LICORS_PRICE_IN_CENTS = "priceInCents";
        public final static String COLUMN_NAME_LICORS_PRIMARY_CATEGORY = "primaryCategory";
        public final static String COLUMN_NAME_LICORS_ORIGIN = "origin";
        public final static String COLUMN_NAME_LICORS_PACKAGE_VOL_MIL = "packageUnitVolumeInMilliliters";
        public final static String COLUMN_NAME_LICORS_ALCOHOL_CONT = "alcoholContent";
        public final static String COLUMN_NAME_LICORS_PRODUCER_NAME = "producerName";
        public final static String COLUMN_NAME_LICORS_IMAGE_THUMB_URL = "imageThumbUrl";
        public final static String COLUMN_NAME_LICORS_VARIETAL = "varietal";
        public final static String COLUMN_NAME_LICORS_STYLE = "style";
    }
}