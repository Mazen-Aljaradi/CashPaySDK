package com.tamkeen.cashpaysdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;


import static com.tamkeen.cashpaysdk.CashPayBuilder.CASHPAY_REQUEST_CODE;

public final class CashPay {

    public static final String CASHPAY_URL = "cash://cashy.page.link";
    private CashPay() {
        // no instance
    }

    public static CashPayBuilder init(Activity activity) {

        return new CashPayBuilder(activity);
    }

    public static CashPayBuilder Scan(Intent data,Activity activity) {
        new AlertDialog.Builder(activity)
                .setTitle("")
                .setMessage(data.getExtras().getString("data"))

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
        return new CashPayBuilder(activity);
    }

    static void build(CashPayBuilder CashPayBuilder) {
try {
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(CASHPAY_URL));
    intent.putExtra("inputPhone", CashPayBuilder.getShortcode());
    intent.putExtra("inputAmount", CashPayBuilder.getAmount());
    intent.putExtra("edNote", CashPayBuilder.getEdNote());

    CashPayBuilder.getActivity().startActivityForResult(intent, CASHPAY_REQUEST_CODE);
}catch (Exception e){
    CashPayBuilder.getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.tamkeen.sms" )));

}
    }
}
