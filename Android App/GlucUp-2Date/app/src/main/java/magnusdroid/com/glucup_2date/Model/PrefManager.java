package magnusdroid.com.glucup_2date.Model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Dell on 12/06/2016.
 */
public class PrefManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "glucup2date";
    // Preference first launch
    private static final String TOKEN_FCM = "Token_FCM";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    // Preference ip server
    private static final String IP_SERVER = "IpServer";
    // Preference login
    private static  final String USER = "mUser";
    private static  final String DOC = "mDoc";
    private static  final String PASSWORD = "mPassword";
    private static  final String ROL = "mRol";
    // Preference patient
    private static  final String PATIENT_NAME = "mPatient";
    // Preference pacient fragment
    private static  final String FRAGMENT = "mFragment";


    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setClear(){
        editor.remove(USER);
        editor.remove(DOC);
        editor.remove(PASSWORD);
        editor.remove(ROL);
        editor.remove(IP_SERVER);
        editor.commit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public void setUser(String user){
        editor.putString(USER, user);
        editor.commit();
    }

    public void setPassword(String password){
        editor.putString(PASSWORD, password);
        editor.commit();
    }

    public void setDoc(String doc){
        editor.putString(DOC, doc);
        editor.commit();
    }

    public void setRol(String rol){
        editor.putString(ROL, rol);
        editor.commit();
    }

    public void setPatientName(String patientName){
        editor.putString(PATIENT_NAME, patientName);
        editor.commit();
    }

    public void setFragment(int fragment){
        editor.putInt(FRAGMENT, fragment);
        editor.commit();
    }

    public void setToken(String token) {
        editor.putString(TOKEN_FCM, token);
        editor.commit();
    }

    public String getRol(){
        return pref.getString(ROL, "");
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public String getUser(){
        return pref.getString(USER, "");
    }

    public String getPassword(){
        return pref.getString(PASSWORD, "");
    }

    public String getDoc(){
        return pref.getString(DOC, "");
    }

    public String getPatientName(){
        return pref.getString(PATIENT_NAME, "");
    }

    public int getFragment(){
        return pref.getInt(FRAGMENT, 0);
    }



}
