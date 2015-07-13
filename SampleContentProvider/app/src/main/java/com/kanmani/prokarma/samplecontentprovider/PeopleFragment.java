package com.kanmani.prokarma.samplecontentprovider;

import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Kanmani on 5/18/2015.
 */
public class PeopleFragment extends Fragment {
    private ListView mContactList;
    private ContentResolver resolver;
    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_list,container,false);
        mContactList = (ListView) view.findViewById(R.id.ContactListView);

        getPeopleInformation();
        return view;
    }

    private void getPeopleInformation() {

        resolver = getActivity().getContentResolver();
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String[] projection = {ContactsContract.Contacts._ID,ContactsContract.Contacts.DISPLAY_NAME,
                                                             ContactsContract.CommonDataKinds.Note.CONTENT_ITEM_TYPE};
        Cursor peopleCursor = resolver.query(uri,projection,null,null,null);

        PeopleAdaptor peopleAdaptor = new PeopleAdaptor(getActivity(),peopleCursor,0);
        mContactList.setAdapter(peopleAdaptor);

    }

    class PeopleAdaptor extends CursorAdapter {
        public PeopleAdaptor(Context context, Cursor c,int flags) {
            super(context, c,flags);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {

            View view = LayoutInflater.from(context).inflate(R.layout. contact_list_item,parent,false);
            return view;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {

            String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            String note = cursor.getString(cursor.getColumnIndex("data1"));
            Log.v("Note of the People: " ,note);
            mTextView = (TextView)view.findViewById(R.id.TextViewId);
            mTextView.setText(displayName);


        }
    }
}
