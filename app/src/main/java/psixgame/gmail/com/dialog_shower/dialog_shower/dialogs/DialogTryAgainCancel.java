package psixgame.gmail.com.dialog_shower.dialog_shower.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import psixgame.gmail.com.dialog_shower.dialog_shower.listeners.DialogCancelClickListener;
import psixgame.gmail.com.dialog_shower.dialog_shower.listeners.DialogTryAgainClickListener;

/**
 * Created by ZOG on 12/3/2015.
 */
public final class DialogTryAgainCancel extends DialogFragment {

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

        builder.setPositiveButton("Try again", new DialogInterface.OnClickListener() {
            @Override
            public final void onClick(final DialogInterface _dialog, final int _which) {
                final DialogTryAgainClickListener listener = (DialogTryAgainClickListener)
                        (getParentFragment() == null ? getActivity() : getParentFragment());
                listener.onClickTryAgain(code);
                dismiss();
            }
        });

        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public final void onClick(final DialogInterface _dialog, final int _which) {
                final DialogCancelClickListener listener = (DialogCancelClickListener)
                        (getParentFragment() == null ? getActivity() : getParentFragment());
                listener.onClickCancel(code);
                dismiss();
            }
        });

        return builder.create();
    }

}
