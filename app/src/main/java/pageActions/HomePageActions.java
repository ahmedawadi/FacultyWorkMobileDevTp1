package pageActions;

import android.content.Intent;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.View.HomeActivity;
import com.example.myapplication.View.ConsultingActivity;

public class HomePageActions {

    private HomeActivity homeActivity;
    public HomePageActions(HomeActivity homeActivity){
        this.homeActivity = homeActivity;
        addConsultingButtonEventListenner();
    }

    public void addConsultingButtonEventListenner(){
        homeActivity.findViewById(R.id.btnConsultation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeActivity.getWindow().getContext(), ConsultingActivity.class);

                homeActivity.startActivity(intent);
                homeActivity.finish();
            }
        });

    }
}
