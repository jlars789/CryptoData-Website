package database;

public class DatabaseGrabber implements Runnable {

	public DatabaseGrabber() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		DBRunner.permDataRefresh();
	}

}
