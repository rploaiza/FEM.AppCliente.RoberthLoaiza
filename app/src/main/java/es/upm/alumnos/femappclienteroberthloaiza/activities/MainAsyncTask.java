package es.upm.alumnos.femappclienteroberthloaiza.activities;

import android.database.Cursor;
import android.os.AsyncTask;
import android.widget.ListView;

/**
 * Created by Usuario on 29/10/2017.
 */

public abstract class MainAsyncTask extends AsyncTask<ListView, Void, Cursor> {
    private ListView listView;
    private String nameProduct;

    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    protected abstract void onPreExecute();

    protected abstract Cursor doInBackground(ListView... ListViews);

    protected abstract void onPostExecute(Cursor cursor);
}
