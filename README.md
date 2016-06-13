## Dialog shower

Create local variable in activity or fragment:

    private final IDialogShower mDialogShower;
    
    public MainActivity() {
        mDialogShower = new DialogShowerImpl();
    }
    

Implement needed interface:

    public class MainActivity implements DialogOkClickListener

Show dialog with single line:

    private final void clickedBtnShowOk() {
        mDialogShower.showOk(getSupportFragmentManager(), 1234, true, "Title", "Dialog ok");
    }

Handle clicks in interface's method:

    @Override
    public final void onClickDialogOk(final int _code) {
        Toast.makeText(getApplicationContext(), "Clicked ok: " + _code, Toast.LENGTH_SHORT).show();
    }
