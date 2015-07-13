package com.kanmani.prokarma.samplecontentprovider;

import android.app.Activity;
import android.app.Fragment;
import android.content.ContentResolver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.provider.ContactsContract;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Kanmani on 4/8/2015.
 */
public class ContactFragment extends Fragment {

    private static final String TAG = ContactFragment.class.getSimpleName();
    private ListView mContactList;
    private ArrayList<People> peopleNameList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.contact_list, container, false);
        mContactList = (ListView) view.findViewById(R.id.ContactListView);
        getContactInformation();
        return view;

    }

    private void getContactInformation() {
        peopleNameList = new ArrayList<People>();
        ContentResolver cr = getActivity().getApplicationContext().getContentResolver();
        Uri contactUri = ContactsContract.Contacts.CONTENT_URI;
        Cursor contactsCursor = cr.query(contactUri, null, null, null, null);
        Log.v(TAG, "contactsCursorQuery : " + contactsCursor);

        if (contactsCursor.moveToFirst()) {
            do {
                long contactId = contactsCursor.getLong(contactsCursor.getColumnIndex("_ID"));
                Uri dataUri = ContactsContract.Data.CONTENT_URI;
                Cursor dataCursor = getActivity().getContentResolver().query(dataUri, null, ContactsContract.Data.CONTACT_ID + " = " + contactId, null, null);

                if (dataCursor.moveToFirst()) {
                    People people = new People();
                    people.displayName = dataCursor.getString(dataCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    do {
                        Log.d(TAG, "Current field --- : " + dataCursor.getString(dataCursor.getColumnIndex("mimetype")));
                        if (dataCursor.getString(dataCursor.getColumnIndex("mimetype"))
                                .equalsIgnoreCase(ContactsContract.CommonDataKinds.Note.CONTENT_ITEM_TYPE)) {
                            people.notes = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                            Log.d(TAG, "Name of contact: " + people.displayName + " Notes: " + people.notes);
                        }
                    } while (dataCursor.moveToNext());

                    peopleNameList.add(people);
                }

            }
            while (contactsCursor.moveToNext());
        }

        ContactAdaptor adaptor = new ContactAdaptor(getActivity().getApplicationContext(), peopleNameList);
        mContactList.setAdapter(adaptor);
        Log.v(TAG, "Done ");
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }


}
