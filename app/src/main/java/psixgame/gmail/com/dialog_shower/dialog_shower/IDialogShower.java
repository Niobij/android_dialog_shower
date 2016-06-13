package psixgame.gmail.com.dialog_shower.dialog_shower;

import android.support.v4.app.FragmentManager;

/**
 * Created by ZOG on 6/1/2016.
 */
public interface IDialogShower {

    void showOk(FragmentManager _manager, int _code, boolean _cancelable, String _title, String _message);
    void showOkCancel(FragmentManager _manager, int _code, String _title, String _message);
    void showTryAgainCancel(FragmentManager _manager, int _code, String _title, String _message);
    void showList(FragmentManager _manager, int _code, String _title, String[] _list);
    void showEditText(FragmentManager _manager, int _code, String _title, String _message, String _textToEdit);

    void showLoader(FragmentManager _manager);
    void removeLoader(FragmentManager _manager);

}
