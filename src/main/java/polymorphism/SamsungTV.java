package polymorphism;

public class SamsungTV implements TV{
	
	
	public SamsungTV() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("===> SamsungTV 객체생성");
	}
	public void powerOn() {
		System.out.println("SamsungTv---전원킨다.");
	}
	public void powerOff() {
		System.out.println("SamsungTv---전원끈다.");
	}
	public void volumeUp() {
		System.out.println("SamsungTv---소리올린다.");
	}
	public void volumeDown() {
		System.out.println("SamsungTv---소리내린다.");
	}
}
