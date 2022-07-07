package com.example.sqlite_full.models;

import android.app.ProgressDialog;
import android.content.Context;

    public class Dialog {

    Context maincontext;
    ProgressDialog dialog;

    public Dialog(Context context) {
        this.maincontext = context;
        //dialog=new ProgressDialog(maincontext);
    }

    public void   dialogBegin(String message, boolean iscanceble){
        dialog=new ProgressDialog(this.maincontext);
        //Set message
        dialog.setMessage(message);
        // Set Non canceble
        dialog.setCancelable(iscanceble);
        //show progressdialog
        dialog.show();
    }

    public void  dialogClose(){
    dialog.dismiss();
}

}
