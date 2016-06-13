package psixgame.gmail.com.dialog_shower.dialog_shower.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

import psixgame.gmail.com.dialog_shower.dialog_shower.listeners.DialogCancelClickListener;
import psixgame.gmail.com.dialog_shower.dialog_shower.listeners.DialogEditTextClickListener;

/**
 * Created by ZOG on 6/2/2016.
 */
public final class DialogEditText extends DialogFragment {

    @NonNull
    @Override
    public final Dialog onCreateDialog(final Bundle _savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        final Bundle args = getArguments();
        final int code = args.getInt(DialogKeys.CODE);
        final String title = args.getString(DialogKeys.TITLE);
        final String message = args.getString(DialogKeys.MESSAGE);
        final String textToEdit = args.getString(DialogKeys.TEXT_TO_EDIT);

        final EditText editText = new EditText(getContext());
        editText.setText(textToEdit);

        builder.setTitle(title);
        builder.setMessage(message);
        builder.setView(editText, 50, 0, 50, 0);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public final void onClick(final DialogInterface _dialog, final int _which) {
                final DialogEditTextClickListener listener = (DialogEditTextClickListener)
                        (getParentFragment() == null ? getActivity() : getParentFragment());
                listener.onClickDialogEditTextOk(code, editText.getText().toString());
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
