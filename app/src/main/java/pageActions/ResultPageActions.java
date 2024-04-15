package pageActions;

import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.View.ResultActivity;

public class ResultPageActions {
    private ResultActivity resultActivity;
    public ResultPageActions(ResultActivity resultActivity, String result){
        this.resultActivity = resultActivity;
        addComeBackButtonEventListenner();
        displayResult(result);
    }

    public void addComeBackButtonEventListenner(){
        resultActivity.findViewById(R.id.comeBackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultActivity.finish();
            }
        });

    }

    public void displayResult(String result){
        ((TextView) resultActivity.findViewById(R.id.result)).setText(result);
    }
}
