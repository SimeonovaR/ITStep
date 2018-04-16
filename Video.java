package introductionTasks;

import java.util.Scanner;

public class Video {
	
	public static int estimateDuration(String video) {
		String[] duration = video.split(":");
		String hours = duration[0];
		String minutes = duration[duration.length - 1];
		int hrs = Integer.parseInt(hours);
		int mins = Integer.parseInt(minutes);
		return (((hrs >=0 && hrs < 1000) && (mins >= 0 && mins < 60)) ? (hrs*60 + mins) : 0);
	}

	public static void main(String[] args) {
		String end = "end";
		int duration = 0;
		Scanner sc = new Scanner(System.in);
		String video = "";
		do {
			System.out.println("Print a video duration in format hours:minutes ");
			video = sc.nextLine();
			if (video.equalsIgnoreCase(end)) 
				break;

			duration += estimateDuration(video); 
			
		} while (video != null);
		
		int hours = duration / 60;
		int minutes = duration % 60;
		
		String allVideos = (String.valueOf(hours) + ":" + String.valueOf(minutes));
		System.out.println(allVideos);
		sc.close();	
	}

}
