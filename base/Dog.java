import java.util.*;
import java.io.*;

public class Dog extends Pet implements Serializable{

	int hunger = 3;
	int emotion = 3;
	int sleep = 3;
	String name = "Anon";
	String type = "Unknown";

	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		ArrayList<Dog> dogs = new ArrayList<Dog>();
                int num = 0;
		int pos = 789;
		String n,t,p;
		
		
		dogs.add(new Dog("ruffles","mutt"));
		//dogs.get(0).saveDogs(dogs);
		dogs = dogs.get(0).loadDogs(dogs);

		while(num != 999){
			
			System.out.println("What whould you like to do?  ");
			System.out.println("(1) Create a new dog");
                	System.out.println("(2) Pull out an existing dog");
               		System.out.println("(3) Save and Exit");
                        num = scan.nextInt();

                	if(num == 1){
				System.out.println("What would you like your dogs breed to be?  ");
				t = scan.next();
	
                		System.out.println("What are you nameing your " + t + "?  ");
        	        	n = scan.next();
	
				dogs.add(new Dog(n,t));
				System.out.println("Here is your new " + t + " named " + n + "! ");

				dogs.get(0).saveDogs(dogs);
			}
			
			else if(num == 2){
				System.out.println("Who do you want to pull out?  ");
				for(int j=0 ; j < dogs.size() ; j++){
					System.out.println("(" +j+ ")  " + dogs.get(j).getName());
				}//end for

                                p = scan.nextLine();

				for(int k=0;k< dogs.size();k++){
                                        if (dogs.get(k).getName().equalsIgnoreCase(p)){
						pos = k;
					}
                                }//end for

				
				if (pos >=0 || pos <=dogs.size()-1){
					
					while(num != 888){

						dogs.get(pos).menu();

						
			                        if(num == 1){
                        		        	dogs.get(pos).checkHunger();
							dogs.get(pos).checkEmotion();
							dogs.get(pos).checkSleep();
                     				}

            			 	        else if(num == 2){
                         	       			dogs.get(pos).feed();
							dogs.get(pos).ignore();
							dogs.get(pos).awake();
                        			}

                        			else if(num == 3){
                                			dogs.get(pos).play();
                                                        dogs.get(pos).fast();
                                                        dogs.get(pos).awake();

                        			}

                        			else if(num == 4){
                                			dogs.get(pos).sleep();
                                                        dogs.get(pos).ignore();
                                                        dogs.get(pos).fast();

                        			}

                        			else if(num == 5){
							dogs.get(0).saveDogs(dogs);
                                			num = 888;
                        			}

                        			else{
                                			System.out.println("ERROR OPTION NOT FOUND");
                        			}//end menu if

					}//end dog while
					
				}

				else{
					 System.out.println("ERROR!  NOT AN OPTION!");
				}//end dog if
			}
			
			else if(num == 3){
				dogs.get(0).saveDogs(dogs);
				num = 999;
			}//end whole if
		
		
		}//end whole while



	}

	public Dog(String n , String t){
		name = n;
		type = t;
	}

	public String getName(){
		return name;
	}

	public String getType(){
		return type;
	}

	public void checkHunger(){
		System.out.println(name + " is " + super.getHunger(hunger));
	}

	public void feed(){
		hunger+=1;
		System.out.println(name + "enjoys a nice bowl of dog kibble");
	}	

	public void fast(){
                hunger-=1;
                System.out.println(name + "did not get feed");
        }

	public void checkEmotion(){
		System.out.println(name + " is " + super.getEmotion(emotion));
	}

	public void play(){
		emotion+=1;
		System.out.println("You played fetch with " + name);	
	}

	public void ignore(){
		emotion-=1;
		System.out.println(name + "did not get attention");	
	}

	public void checkSleep(){
		System.out.println(name + " is " + super.getSleep(sleep));	
	}

	public void sleep(){
		sleep+=1;
		System.out.println(name + "took a nice long nap");
	}

	public void awake(){
		sleep-=1;
		 System.out.println(name + "stayed up");
	}

	public int menu(){

		
                Scanner scan = new Scanner(System.in);
                int x;

                System.out.println("What would you like to do with" + name + "?");
                System.out.println("(1) Check Status");
                System.out.println("(2) Give Food");
                System.out.println("(3) Play");
                System.out.println("(4) Let Them Sleep ");
                System.out.println("(5) Save & EXIT");

                x = scan.nextInt();

                return x;
		
	}
	
	public void saveDogs(ArrayList dogs){

		try{
			FileOutputStream fo = new FileOutputStream("dogArray.dat");
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			oo.writeObject(dogs);
			
		}

		catch (Exception e){
			System.out.println(e.getMessage());
		}

	}

	public ArrayList loadDogs(ArrayList dogs){

		try{
			FileInputStream fi = new FileInputStream("dogArray.dat");
                        ObjectInputStream oi = new ObjectInputStream(fi);
			dogs = (ArrayList)oi.readObject();
			return dogs;
		}
		
		catch (Exception e){
                        System.out.println(e.getMessage());
                }
		
		return dogs;

	}

}
