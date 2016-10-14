package org.wit.myrent.helpers;
import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
<<<<<<< HEAD
import android.support.v4.app.NavUtils;
=======
import android.provider.ContactsContract;
import android.support.v4.app.NavUtils;
import android.content.Context;
import android.net.Uri;

>>>>>>> 36f43e5d726aee373a1256d878eca0a062d499df
public class IntentHelper
{
    public static void startActivity (Activity parent, Class classname)
    {
        Intent intent = new Intent(parent, classname);
        parent.startActivity(intent);
    }

    public static void startActivityWithData (Activity parent, Class classname, String extraID, Serializable extraData)
    {
        Intent intent = new Intent(parent, classname);
        intent.putExtra(extraID, extraData);
        parent.startActivity(intent);
    }

    public static void startActivityWithDataForResult (Activity parent, Class classname, String extraID, Serializable extraData, int idForResult)
    {
        Intent intent = new Intent(parent, classname);
        intent.putExtra(extraID, extraData);
        parent.startActivityForResult(intent, idForResult);
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 71a3b4e1b9d41b1028368295a43c53b64c2cb358
    public static void navigateUp(Activity parent)
    {
        Intent upIntent = NavUtils.getParentActivityIntent(parent);
        NavUtils.navigateUpTo(parent, upIntent);
<<<<<<< HEAD
=======
=======
    }

>>>>>>> 71a3b4e1b9d41b1028368295a43c53b64c2cb358
    public static void selectContact(Activity parent, int id)
    {
        Intent selectContactIntent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        parent.startActivityForResult(selectContactIntent, id);
>>>>>>> 36f43e5d726aee373a1256d878eca0a062d499df
    }

}