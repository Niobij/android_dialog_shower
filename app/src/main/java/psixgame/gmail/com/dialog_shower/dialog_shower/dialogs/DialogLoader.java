package psixgame.gmail.com.dialog_shower.dialog_shower.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import psixgame.gmail.com.dialog_shower.R;

/**
 * Created by ZOG on 11/25/2015.
 */
public final class DialogLoader extends DialogFragment {

    @Nullable
    @Override
    public final View onCreateView(final LayoutInflater _inflater, final ViewGroup _container, final Bundle _savedInstanceState) {
        return _inflater.inflate(R.layout.dialog_loader, _container);
    }

}
