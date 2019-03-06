package edu.cascadia.mobile.apps.passwordcheck;
// Adapted from https://www.bignerdranch.com/blog/two-way-data-binding-on-android-observing-your-view-with-xml/
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

// 1.Extend ViewModel instead of BaseObservable
//2.Make the password and passwordQuality property types MutableLiveData<String>;
// 2.1 initiallize these in a constructor
//3. Make the necessary changes to the class; removing @Bindable and BR references, and
//4. Update the getValue() and setValue() method for password and passwordQuality
// (it's setValue won't take any parameters) to work with MutableLiveData<String>
//5 Add a onPasswordTextChanged method that takes a CharSequence
// and calls the setPassword  and setPasswordQuality
public class PasswordViewModel extends ViewModel{

   /** public void setPassword(MutableLiveData<String> password) {
        this.password = password;
    }*/

    // private String password;
 public MutableLiveData<String> password;
    public MutableLiveData<String> passwordQuality;

    //constructor
    // 2.1 initiallize these in a constructor
    public PasswordViewModel(){

        password = new MutableLiveData<>();
        passwordQuality = new MutableLiveData<>();
    }

    //3.removing @Bindable
    //4. Update the setValue()  method for passwordQuality
    //@Bindable
    public String getPassword() {
        return password.getValue();
    }
    //4. Update the getValue() and setValue() method for passwordQuality
// (it's setValue won't take any parameters) to work with MutableLiveData<String>
   // @Bindable
    public String getPasswordQuality() {

        if (password.getValue() == null || password.getValue().isEmpty()) {
            return "Enter a password";
        } else if (password.getValue().equals("password")) {
            return "Very bad";
        } else if (password.getValue().length() < 6) {
            return "Short";
        } else {
            return "Okay";
        }


       /** if (password == null || password.isEmpty()) {
            return "Enter a password";
        } else if (password.equals("password")) {
            return "Very bad";
        } else if (password.length() < 6) {
            return "Short";
        } else {
            return "Okay";
        }*/
    }
//3. Make the necessary changes to the class; removing @Bindable and BR references,
//4. Update the getValue() and setValue() method for password
    //public void setPassword(String password) {
        public void setPassword(String password) {
            this.password.setValue(password);
       // if(this.password != password) {
           // this.password = password;
            //notifyPropertyChanged(BR.passwordQuality);
           // notifyPropertyChanged(BR.password);
        //}
    }

    //5 Add a onPasswordTextChanged method that takes a CharSequence
// and calls the setPassword  and setPasswordQuality
    public void onPasswordTextChanged(CharSequence Cs){
        setPassword(Cs.toString());
        getPasswordQuality();

    }

}
