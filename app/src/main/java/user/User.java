package user;

import androidx.annotation.NonNull;

public class User {
    private int age;
    private boolean areYouFast;
    private float glycemieValue;

    public User(){
        age = 18;
        areYouFast = true;
        glycemieValue = 0;
    }

    public float getGlycemieValue() {
        return glycemieValue;
    }

    public int getAge() {
        return age;
    }

    public boolean getAreYouFast(){
        return areYouFast;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAreYouFast(boolean areYouFast) {
        this.areYouFast = areYouFast;
    }

    public void setGlycemieValue(float glycemieValue) {
        this.glycemieValue = glycemieValue;
    }

    //this class is used to display the result based on the user information inside the class
    public String getResult(){
        String result = "votre niveau de glycémie est ";

        if(areYouFast == true){
            if(age < 6){
                if(glycemieValue < 5.5f )
                    result = result.concat("trop bas");
                else if(glycemieValue > 10 )
                    result = result.concat("trop élevée");
                else
                    result = result.concat("normal");
            }
            else if(age >= 6 && age <= 12){
                if(glycemieValue < 5 )
                    result = result.concat("trop bas");
                else if(glycemieValue > 10 )
                    result = result.concat("trop élevée");
                else
                    result = result.concat("normal");
            }
            else if (age >= 13){
                if(glycemieValue < 5 )
                    result = result.concat("trop bas");
                else if(glycemieValue > 7.2f )
                    result = result.concat("trop élevée");
                else
                    result = result.concat("normal");
            }
        }
        else {

            float minGlycemieValue = age < 6 ? 5.5f : 5;

            if(glycemieValue < minGlycemieValue )
                result = result.concat("trop bas");
            else if(glycemieValue > 10.5f )
                result = result.concat("trop élevée");
            else
                result = result.concat("normal");
        }


        return result;

    }
    @NonNull
    @Override
    public String toString() {
        return "age : " + age + " are you fast : " + areYouFast + " glycemie value :" + glycemieValue;
    }
}
