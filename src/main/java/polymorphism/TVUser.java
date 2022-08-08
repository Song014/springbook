package polymorphism;

public class TVUser {

	public static void main(String[] args) {

		// 1 결합도가 높은 방식 
//		SamsungTV tv = new SamsungTV();
//		LgTV tv = new LgTV();
//		tv.powerOn();
//		tv.powerOff();
//		tv.volumeUp();
//		tv.volumeDown();
	
		
		
		// 2 다형성 .. 결합도를 낮추는 방식으로 개발 해야한다
		// 삼성티비와 엘지티비를 직접 호출해서 사용하는게아닌 인터페이스를 통해 사용한다
//		TV tv = new SamsungTV();
//		TV tv = new LgTV();
//		tv.powerOn();
//		tv.powerOff();
//		tv.volumeUp();
//		tv.volumeDown();
	
		
		
		// 3 팩토리에 호출해서 해당하는 클래스를 가져온다
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean("samsung"); // TVUser클래스는 SamsungTV,LgTV 클래스의 존재를 모른다
//		TV tv = (TV)factory.getBean("lg");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
	}

}
