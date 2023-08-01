public abstract class Pet implements Hunger , Emotion , Sleep{

	String wild = "No";

	public abstract String getName();

	public abstract String getType();

	public abstract void checkHunger();

	public abstract void feed();

	public abstract void fast();

	public abstract void checkEmotion();

	public abstract void play();

	public abstract void ignore();

	public abstract void checkSleep();

	public abstract void sleep();

	public abstract void awake();

	public String getHunger(int x){

		if(x <= 1){
			return Hunger.h1;
		}
		
		else if(x == 2){
			return Hunger.h2;
		}

		else if(x == 3){
                        return Hunger.h3;
                }

		else if(x == 4){
                        return Hunger.h4;
                }

		else if(x >= 5){
                        return Hunger.h5;
                }
		
		return " ";

	}

	public String getEmotion(int x){

                if(x <= 1){
                        return Emotion.e1;
                }

                else if(x == 2){
                        return Emotion.e2;
                }

                else if(x == 3){
                        return Emotion.e3;
                }

                else if(x == 4){
                        return Emotion.e4;
                }

                else if(x >= 5){
                        return Emotion.e5;
                }

		return " ";		

        }

	public String getSleep(int x){

                if(x <= 1){
                        return Sleep.t1;
                }

                else if(x == 2){
                        return Sleep.t2;
                }

                else if(x == 3){
                        return Sleep.t3;
                }

                else if(x == 4){
                        return Sleep.t4;
                }

                else if(x >= 5){
                        return Sleep.t5;
                }

		return " ";


        }


}
