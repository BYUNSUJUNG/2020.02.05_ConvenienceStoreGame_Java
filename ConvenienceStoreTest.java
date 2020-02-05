import java.util.Scanner;

/*
 * Java
 * 2020.02.05 ~ 2020.02.07
 * 편의점 아르바이트
 * */

class ConvenienceStore {
	/*
	 * 오픈(6시): 문열기 -> 시재확인(카운터기 마지막 확인 금액과 비교)
	 * 구입: 상품스캔 -> 돈받기 -> 잔돈주기
	 * 매입
	 * 청소
	 * 근무자 교체(13시)
	 * */
	
	int numberOfVisits; // 방문 손님 수
	int lastCheckMoneyInCounter = 100000; // 카운터기(포스기) 마지막 확인 금액
	int moneyInCounter; // 카운터기(포스기) 금액
	int moneyReceived; // (손님에게서) 받은 돈
	int change; // 거스름 돈
	
	int productNum;
	// {상품명, 가격, 재고 수}
	String[][] product = {{"과자","1000","5"},{"음료","500","5"},{"껌","300","5"}}; 
	
	// 시간
	// 6시 오픈, 13시 근무자 교체
	// 30분 간격으로 시간 흐름
	int hours = 6; 
	int minutes;
	
	// 문(true: 열림, false: 닫힘)
	boolean door = false;
	
	Scanner scan = new Scanner(System.in);
	
	public void Open() {
		// 오픈(6시)
		// 	1. 문열기
		//	2. 시재 확인(카운터기 마지막 확인 금액과 비교)
		
		door = true;
		System.out.println("============================");
		System.out.println("문을 열었습니다. 현재시각: "+hours+"시 입니다.");
		System.out.println("===========시재 확인===========");
		System.out.println("마지막 확인 금액은"+lastCheckMoneyInCounter+"입니다.");
		System.out.print("현재 카운터기(포스기)의 금액: ");
		moneyInCounter = scan.nextInt();
		
		System.out.println("============================");
		if(lastCheckMoneyInCounter==moneyInCounter) {
			System.out.println("시재 이상없습니다.");
		} else {
			System.out.println("시재 이상있습니다.");
			if(moneyInCounter-lastCheckMoneyInCounter>0) {
				// 현재 카운터기(포스기) 금액 > 마지막 확인 금액
				System.out.println("초과 되었습니다.");
			} else {
				// 현재 카운터기(포스기) 금액 < 마지막 확인 금액
				System.out.println("감소 되었습니다");
			}
		}
		System.out.println("============================");
		
	} // end of Open()
	
	public void Purchase() {
		// 구입: 상품스캔 -> 돈받기 -> 잔돈주기
		
		productNum = (int)Math.random()*3;
		System.out.println(product[productNum][0]+"을 스캔합니다.");
		System.out.println(product[productNum][1]+"원 입니다.");
	}
	
	
	
	
}



public class ConvenienceStoreTest {

	public static void main(String[] args) {
		ConvenienceStore store1 = new ConvenienceStore();

	}

}
