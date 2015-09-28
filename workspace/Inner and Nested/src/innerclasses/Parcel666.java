package innerclasses;

public class Parcel666 {
	private void internalTracking(boolean b){
		if(b){
			class TrackingSlip{
				private String id;
				public TrackingSlip(String s) { id = s;
					}
				public String getId(){return id;}
			}
			TrackingSlip slip = new TrackingSlip("pending");
			String s = slip.getId();
		}
		//exception
		//TrackingSlip s;
	}
	public void track(){internalTracking(true);}
	public static void main(String[] args) {
		Parcel666 p = new Parcel666();
		p.track();
	}
}