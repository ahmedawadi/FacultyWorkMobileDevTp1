package GlycemieCalculationPage;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import user.User;

public class GlycemieCalculationPage {

    /*
    * glycemieCalculationPage this variable is used to access the input variables inside the interfaces and access the button to add the eventListenners
    * user variable is used to add the user information to it, calculate user information  and use it from the mainActivity if we need it to access the data and
    * */
    MainActivity glycemieCalculationPage;
    User user;

    public GlycemieCalculationPage(User user, MainActivity glycemieCalculationPage){
        this.user = user;
        this.glycemieCalculationPage = glycemieCalculationPage;
    }

    //this function is used to add the event listenners to the progress bar changement and the button used for the calculation
    public void addPageEventListenners(){

        getUserAgeOnProgressBar();
        clickOnConsultButton();
    }

    //this function is used to get the other information of the user and display the result
    private void clickOnConsultButton(){

        RadioGroup areYouFast = glycemieCalculationPage.findViewById(R.id.speed);
        EditText userGlycemie = glycemieCalculationPage.findViewById(R.id.userGlycemie);
        Button consult = glycemieCalculationPage.findViewById(R.id.consultButton);
        TextView displayedResult = glycemieCalculationPage.findViewById(R.id.tvReponse);

        consult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    user.setGlycemieValue(Float.parseFloat(userGlycemie.getText().toString()));
                    RadioButton answer = glycemieCalculationPage.findViewById(areYouFast.getCheckedRadioButtonId());
                    user.setAreYouFast(getQuestionAnswer(answer.getText().toString()));

                    displayedResult.setText(user.getResult());
                }
                catch (NumberFormatException e){
                    e.printStackTrace();
                }


            }
        });
    }

    //this function is used to get the user age from the progress bar and update on the user class
    private void getUserAgeOnProgressBar(){
        SeekBar userAge = glycemieCalculationPage.findViewById(R.id.userAge);
        TextView userAgeText = glycemieCalculationPage.findViewById(R.id.userAgeText);

        //putting a default vlaue for the user age
        userAge.setProgress(18);

        //changing the appeared value of the user age text in the screen
        userAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                userAgeText.setText(Integer.toString(progress));
                user.setAge(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private boolean getQuestionAnswer(String answer){
        return answer.equals("Oui");
    }

}
