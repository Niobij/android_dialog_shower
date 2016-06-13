package psixgame.gmail.com.dialog_shower.dialog_shower;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static  psixgame.gmail.com.dialog_shower.dialog_shower.dialogs.DialogKeys.*;

import psixgame.gmail.com.dialog_shower.R;
import psixgame.gmail.com.dialog_shower.dialog_shower.dialogs.DialogEditText;
import psixgame.gmail.com.dialog_shower.dialog_shower.dialogs.DialogList;
import psixgame.gmail.com.dialog_shower.dialog_shower.dialogs.DialogLoader;
import psixgame.gmail.com.dialog_shower.dialog_shower.dialogs.DialogOk;
import psixgame.gmail.com.dialog_shower.dialog_shower.dialogs.DialogOkCancel;
import psixgame.gmail.com.dialog_shower.dialog_shower.dialogs.DialogTryAgainCancel;

/**
 * Created by ZOG on 6/1/2016.
 */
public final class DialogShowerImpl implements IDialogShower {

    private static final Logger logger = LoggerFactory.getLogger("DialogShower");
    private static final String TAG_LOADER = "loader_dialog";

    @Override
    public final void showOk(final FragmentManager _manager, final int _code, final boolean _cancelable, final String _title, final String _message) {
        logger.trace("Entered showOk(): code={} cancelable={} title={} message={}", new Object[] { _code, _cancelable, _title, _message });

        final Bundle bundle = new Bundle();
        bundle.putInt(CODE, _code);
        bundle.putString(TITLE, _title);
        bundle.putString(MESSAGE, _message);

        final DialogOk ok = new DialogOk();
        ok.setCancelable(_cancelable);
        ok.setArguments(bundle);
        ok.show(_manager, null);
    }

    @Override
    public final void showOkCancel(final FragmentManager _manager, final int _code, final String _title, final String _message) {
        logger.trace("Entered showOkCancel(): code={} title={} message={}", new Object[] { _code, _title, _message });

        final Bundle bundle = new Bundle();
        bundle.putInt(CODE, _code);
        bundle.putString(TITLE, _title);
        bundle.putString(MESSAGE, _message);

        final DialogOkCancel dlg = new DialogOkCancel();
        dlg.setCancelable(false);
        dlg.setArguments(bundle);
        dlg.show(_manager, null);
    }

    @Override
    public final void showTryAgainCancel(final FragmentManager _manager, final int _code, final String _title, final String _message) {
        logger.trace("Entered showTryAgainCancel(): code={} title={} message={}", new Object[] { _code, _title, _message });

        final Bundle bundle = new Bundle();
        bundle.putInt(CODE, _code);
        bundle.putString(TITLE, _title);
        bundle.putString(MESSAGE, _message);

        final DialogTryAgainCancel dlg = new DialogTryAgainCancel();
        dlg.setCancelable(false);
        dlg.setArguments(bundle);
        dlg.show(_manager, null);
    }

    @Override
    public final void showList(final FragmentManager _manager, final int _code, final String _title, final String[] _list) {
        logger.trace("Entered showList(): code={} title={} list={}", new Object[] { _code, _title, _list });

        final Bundle bundle = new Bundle();
        bundle.putInt(CODE, _code);
        bundle.putString(TITLE, _title);
        bundle.putStringArray(LIST, _list);

        final DialogList list = new DialogList();
        list.setArguments(bundle);
        list.show(_manager, null);
    }

    @Override
    public final void showEditText(final FragmentManager _manager, final int _code, final String _title, final String _message, final String _textToEdit) {
        logger.trace("Entered showTryAgainCancel(): code={} title={} message={} textToEdit={}", new Object[] { _code, _title, _message, _textToEdit });

        final Bundle bundle = new Bundle();
        bundle.putInt(CODE, _code);
        bundle.putString(TITLE, _title);
        bundle.putString(MESSAGE, _message);
        bundle.putString(TEXT_TO_EDIT, _textToEdit);

        final DialogEditText dlg = new DialogEditText();
        dlg.setArguments(bundle);
        dlg.show(_manager, null);
    }

    @Override
    public final void showLoader(final FragmentManager _manager) {
        logger.trace("Entered showLoader()");
        _manager.executePendingTransactions();
        final DialogLoader loader = new DialogLoader();
        loader.setCancelable(false);
        loader.setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogLoader);
        loader.show(_manager, TAG_LOADER);
    }

    @Override
    public final void removeLoader(final FragmentManager _manager) {
        logger.trace("Entered removeLoader()");
        _manager.executePendingTransactions();
        final Fragment fragment = _manager.findFragmentByTag(TAG_LOADER);
        if (fragment != null) ((DialogLoader) fragment).dismiss();
    }

}
