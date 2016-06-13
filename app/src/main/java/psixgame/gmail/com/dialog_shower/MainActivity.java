package psixgame.gmail.com.dialog_shower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import psixgame.gmail.com.dialog_shower.dialog_shower.DialogShowerImpl;
import psixgame.gmail.com.dialog_shower.dialog_shower.IDialogShower;
import psixgame.gmail.com.dialog_shower.dialog_shower.listeners.DialogCancelClickListener;
import psixgame.gmail.com.dialog_shower.dialog_shower.listeners.DialogOkClickListener;
import psixgame.gmail.com.dialog_shower.dialog_shower.listeners.DialogTryAgainClickListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        DialogOkClickListener, DialogCancelClickListener, DialogTryAgainClickListener {

    private static final int DLG_CODE_OK                = 1000;
    private static final int DLG_CODE_TRY_AGAIN         = 1001;

    private final IDialogShower mDialogShower;

    public MainActivity() {
        mDialogShower = new DialogShowerImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOk_AM).setOnClickListener(this);
        findViewById(R.id.btnTryAgain_AM).setOnClickListener(this);
    }

    @Override
    public final void onClick(final View v) {
        switch (v.getId()) {
            case R.id.btnOk_AM: clickedBtnShowOk(); break;
            case R.id.btnTryAgain_AM: clickedBtnShowTryAgain(); break;
        }
    }

    private final void clickedBtnShowOk() {
        mDialogShower.showOk(getSupportFragmentManager(), DLG_CODE_OK, true, "Title", "Dialog ok");
    }

    private final void clickedBtnShowTryAgain() {
        mDialogShower.showTryAgainCancel(getSupportFragmentManager(), DLG_CODE_TRY_AGAIN, "Title", "Dialog try again/cancel");
    }

    @Override
    public final void onClickCancel(final int _code) {
        Toast.makeText(getApplicationContext(), "Clicked cancel: " + getCodeName(_code), Toast.LENGTH_SHORT).show();
    }

    @Override
    public final void onClickDialogOk(final int _code) {
        Toast.makeText(getApplicationContext(), "Clicked ok: " + getCodeName(_code), Toast.LENGTH_SHORT).show();
    }

    @Override
    public final void onClickTryAgain(final int _code) {
        Toast.makeText(getApplicationContext(), "Clicked try again: " + getCodeName(_code), Toast.LENGTH_SHORT).show();
    }

    private final String getCodeName(final int _code) {
        final String name;
        switch (_code) {
            case DLG_CODE_OK:               name = "DLG_CODE_OK";               break;
            case DLG_CODE_TRY_AGAIN:        name = "DLG_CODE_TRY_AGAIN";        break;

            default: throw new RuntimeException("Unknown dlg code: " + _code);
        }
        return name;
    }

}
