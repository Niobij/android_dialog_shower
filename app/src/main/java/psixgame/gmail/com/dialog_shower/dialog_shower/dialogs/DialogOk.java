package psixgame.gmail.com.dialog_shower.dialog_shower.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import psixgame.gmail.com.dialog_shower.dialog_shower.listeners.DialogOkClickListener;

/**
 * Created by ZOG on 11/25/2015.
 */
public final class DialogOk extends DialogFragment {

    @NonNull
    @Override
    public final Dialog onCreateDialog(final Bundle _savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        final Bundle args = getArguments();

        final String title = args.getString(DialogKeys.TITLE);
        final String message = args.getString(DialogKeys.MESSAGE);
        final int code = args.getInt(DialogKeys.CODE);

        builder.setTitle(title);
        builder.setMessage(message);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public final void onClick(final DialogInterface _dialog, final int _which) {
                ((DialogOkClickListener) (getParentFragment() == null ? getActivity() : getParentFragment())).onClickDialogOk(code);
                dismiss();
            }
        });

        return builder.create();
    }

}
