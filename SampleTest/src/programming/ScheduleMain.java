package programming;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class ScheduleTest extends TimerTask{

	
	public void run(){
		Date date = new Date();
		System.out.println("Current Time..."+date);
	}
}


public class ScheduleMain{
	public static void main(String args[]) {
		Timer timer = new Timer();
		ScheduleTest schedule = new ScheduleTest();
		timer.schedule(schedule, 1, 1000);
		for (int i = 0; i < 10; i++){
			System.out.println(i);
		}
	}
}
