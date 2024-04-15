package pageActions;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Controller.Controller;
import com.example.myapplication.View.ConsultingActivity;
import com.example.myapplication.R;
import com.example.myapplication.View.ResultActivity;

public class ConsultingPageActions {

    /*
    * consultingActivity this variable is used to access the input variables inside the interfaces and access the button to add the eventListenners
    * user variable is used to add the user information to it, calculate user information  and use it from the mainActivity if we need it to access the data and
    * */

    private int userAgeOnProgressBar = 0;
    ConsultingActivity consultingActivity;

    public ConsultingPageActions(ConsultingActivity consultingActivity){
        this.consultingActivity = consultingActivity;
    }

    //this function is used to add the event listenners to the progress bar changement and the button used for the calculation
    public void addPageEventListenners(){

        getUserAgeOnProgressBar();
        clickOnConsultButton();
    }

    //this function is used to get the other information of the user and display the result
    private void clickOnConsultButton(){

        RadioGroup areYouFast = consultingActivity.findViewById(R.id.speed);
        EditText userGlycemie = consultingActivity.findViewById(R.id.userGlycemie);
        Button consult = consultingActivity.findViewById(R.id.consultButton);
        TextView displayedResult = consultingActivity.findViewById(R.id.tvReponse);

        consult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {

                    /*
                    * checking the user information to notify him if he forgot a field to add it */
                    String glycemieInput = userGlycemie.getText().toString();

                    if(userAgeOnProgressBar == 0)
                        Toast.makeText(consultingActivity.getWindow().getContext(), "vous n'avez pas ajouté votre age", Toast.LENGTH_SHORT).show();
                    if(glycemieInput.trim().isEmpty())
                        Toast.makeText(consultingActivity.getWindow().getContext(), "vous n'avez pas ajouté votre valeur de glycémie", Toast.LENGTH_SHORT).show();


                    Controller controller = Controller.getInstance();
                    RadioButton answer = consultingActivity.findViewById(areYouFast.getCheckedRadioButtonId());

                    controller.createPatient(userAgeOnProgressBar, Float.parseFloat(glycemieInput), getQuestionAnswer(answer.getText().toString()));

                    //displaying the result on the result activity
                    Intent intent = new Intent(consultingActivity.getWindow().getContext(), ResultActivity.class);

                    intent.putExtra("result", controller.getResult());
                    consultingActivity.startActivity(intent);

                }
                catch (NumberFormatException e){
                    e.printStackTrace();
                }


            }
        });
    }

    //this function is used to get the user age from the progress bar and update on the user class
    private void getUserAgeOnProgressBar(){
        SeekBar userAge = consultingActivity.findViewById(R.id.userAge);
        TextView userAgeText = consultingActivity.findViewById(R.id.userAgeText);

        //changing the appeared value of the user age text in the screen
        userAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                userAgeText.setText(Integer.toString(progress));
                userAgeOnProgressBar = progress;
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
