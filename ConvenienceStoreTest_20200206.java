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
	int moneyReceived = 0; // (손님에게서) 받은 돈
	int change; // 거스름 돈
	
	int productNum; // 상품 순번
	int productCnt; // 상품 재고 
	// {상품명, 가격, 재고 수}
	String[][] product = {{"과자","1000","5"},{"음료","500","5"},{"껌","300","5"}}; 
	
	// 시간
	// 6시 오픈, 13시 근무자 교체
	// 각각의 행위을 한 후 30분 간격으로 시간 흐름
	int hour = 6;
	int minute;
	
	// 문(true: 열림, false: 닫힘)
	boolean door = false;
	
	Scanner scan = new Scanner(System.in);
	
	public void Open() {
		// 오픈(6시)
		// 	1. 문열기
		//	2. 시재 확인(카운터기 마지막 확인 금액과 비교)
		
		door = true;
		System.out.println("문을 열었습니다. 현재시각 "+hour+"시 입니다.");
		System.out.println("===========시재 확인===========");
		System.out.println("마지막 확인 금액은 "+lastCheckMoneyInCounter+"원 입니다.");
		System.out.print("현재 카운터기(포스기)의 금액 확인 후 입력해주세요: ");
		moneyInCounter = scan.nextInt();
		
		System.out.println("============================");
		if(lastCheckMoneyInCounter==moneyInCounter) {
			System.out.println("시재 이상없습니다.");
		} else {
			System.out.println("시재 이상있습니다.");
			if(moneyInCounter-lastCheckMoneyInCounter>0) {
				// 현재 카운터기(포스기) 금액 > 마지막 확인 금액
				System.out.println((moneyInCounter-lastCheckMoneyInCounter)+"원 초과했습니다.");
			} else {
				// 현재 카운터기(포스기) 금액 < 마지막 확인 금액
				System.out.println((lastCheckMoneyInCounter-moneyInCounter)+"원 감소했습니다");
			}
		}
		System.out.println("============================");
		
	} // end of Open
	
	public void Purchase() {
		// 구입: 상품스캔 -> 돈받기 -> 잔돈주기
		// {상품명, 가격, 재고 수}
		
		System.out.println("============상품 구입============");
		for(int i=0; i<product.length; i++)
			System.out.println((i+1)+"."+product[i][0]);
		
		System.out.print("구입 상품 순번 입력: ");
		productNum = scan.nextInt();
		System.out.println("============================");
		System.out.println(product[productNum][0]+"을 스캔합니다.");
		System.out.println(product[productNum][1]+"원 입니다.");
		
		System.out.print("손님에게서 받은 돈: ");
		moneyReceived = scan.nextInt();
		moneyInCounter += moneyReceived; 
				
		change = moneyReceived-Integer.parseInt(product[productNum][1]);
		System.out.println("거스름 돈: "+change);
		moneyReceived -= change;
		
		productCnt = Integer.parseInt(product[productNum][2]);
		System.out.println("남은 재고 수: "+(productCnt-1));
		product[productNum][2]= Integer.toString(productCnt-1);
		
	} // end of Purchase
	
	
	public void ReceiveInventory() {
		// 재고 매입 및 입고
		// 각자 재고 +10
		for(int i=0; i<product.length; i++) {
			System.out.println(product[i][0]+"의 재고의 수가 +10 되었습니다");
			product[i][2]+=10;
		}
		CheckProductCnt();
		
	} // end of ReceiveInventory
	
	public void CleaningTheStore() {
		// 매장 청소
		System.out.println("============매장 안을 청소했습니다.============");
	}
	 
	public void waiting () {
		// 손님이 없는 시간 
		System.out.println("============손님 기다리는중============");
	}
	
	public void TimeFlow() {
		minute+=30;
		if(minute>=60) {
			minute=0;
			hour+=1;
		}
		System.out.println("현재 시각은 "+hour+"시 "+minute+"분 입니다.");
		
		
	}// end of TimeFlow
	

	public void CheckProductCnt() {
		// 상품 재고 수 확인
		
		System.out.println("============상품 재고 수 확인============");
		for(int i=0; i<product.length; i++) 
			System.out.println((i+1)+"."+product[i][0]+"("+product[i][1]+"원)의 재고 수: "+product[i][2]);
	
	} // end of CheckProductCnt
	
	public void CheckCurrentStatus() {
		System.out.println("============상태 확인============");
		System.out.println("방문자 수: "+numberOfVisits); // 손님 수
		System.out.println("포스기 돈(카운터기 돈)"+moneyInCounter); // 포스기 돈(카운터 돈)
		System.out.println("현재 시각은: "+hour+"시"+"minute"+"분 입니다.");  // 현재 시각
		CheckProductCnt(); // 상품 재고 수 확인
		if(door==true) 
			System.out.println("문이 열려있습니다.");
		else
			System.out.println("문이 닫혀있습니다.");
	}
	
}

public class ConvenienceStoreTest_20200226 {
	
	/*
	 * 오픈(6시): 문열기 -> 시재확인(카운터기 마지막 확인 금액과 비교)
	 * 구입: 상품스캔 -> 돈받기 -> 잔돈주기
	 * 매입
	 * 청소
	 * 근무자 교체(13시)
	 * */

	public static void main(String[] args) {
		
		int BehaviorNum = 0; 
		
		Scanner scan = new Scanner(System.in);
		
		ConvenienceStore store1 = new ConvenienceStore();
		System.out.println("============편의점 아르바이트 시작============");
		
		while(store1.hour!=13) { // 근무자 교체(13시)까지 반복
			if(store1.hour==6&&store1.minute==0) {
				// 6시 정시 오픈
				store1.Open(); 
			} else if(store1.hour%2==0&&store1.minute==0) {
				// 6시부터 2시간 단위로 청소 실행
				// but 6시에는 Open()를 실행, 10시에는 ReceiveInventory()를 실행
				store1.CleaningTheStore();
			} else if(store1.hour==10&&store1.minute==0) {
				// 10시 재고 매입및 입고
				store1.ReceiveInventory();
			} else {
				// 오픈, 청소, 재고 매입 이외의 시간에는
				// 웨이팅을 하거나 손님맞이를 한다.
				
				System.out.println("행위 넘버를 입력해주세요.");
				System.out.println("1. 웨이팅");
				System.out.println("2. 손님 맞이");
				System.out.print("입력: ");
				BehaviorNum = scan.nextInt();
				if(BehaviorNum==0)
					// 웨이팅
					store1.waiting();
				else if(BehaviorNum==1) 
					// 손님 맞이
					store1.Purchase();
			}
			
			// 한 행위가 끝나면 30분이 흐른다.
			store1.TimeFlow();
		}
		

	}

}
