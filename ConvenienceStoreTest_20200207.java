import java.util.Scanner;

/*
 * Java
 * 2020.02.05 ~ 2020.02.07
 * ������ �Ƹ�����Ʈ
 * */

class ConvenienceStore {
	/*
	 * ����(6��): ������ -> ����Ȯ��(ī���ͱ� ������ Ȯ�� �ݾװ� ��)
	 * ����: ��ǰ��ĵ -> ���ޱ� -> �ܵ��ֱ�
	 * ����
	 * û��
	 * �ٹ��� ��ü(13��)
	 * */
	
	int numberOfVisits; // �湮 �մ� ��
	int lastCheckMoneyInCounter = 100000; // ī���ͱ�(������) ������ Ȯ�� �ݾ�
	int moneyInCounter; // ī���ͱ�(������) �ݾ�
	int moneyReceived = 0; // (�մԿ��Լ�) ���� ��
	int change; // �Ž��� ��
	
	int productNum; // ��ǰ ����
	int productCnt; // ��ǰ ��� 
	// {��ǰ��, ����, ��� ��}
	String[][] product = {{"����","1000","5"},{"����","500","5"},{"��","300","5"}}; 
	
	// �ð�
	// 6�� ����, 13�� �ٹ��� ��ü
	// ������ ������ �� �� 30�� �������� �ð� �帧
	int hour = 6;
	int minute;
	
	// ��(true: ����, false: ����)
	boolean door = false;
	
	Scanner scan = new Scanner(System.in);
	
	public void Open() {
		// ����(6��)
		// 	1. ������
		//	2. ���� Ȯ��(ī���ͱ� ������ Ȯ�� �ݾװ� ��)
		
		door = true;
		System.out.println("���� �������ϴ�. ����ð� "+hour+"�� �Դϴ�.");
		System.out.println("===========���� Ȯ��===========");
		System.out.println("������ Ȯ�� �ݾ��� "+lastCheckMoneyInCounter+"�� �Դϴ�.");
		System.out.print("���� ī���ͱ�(������)�� �ݾ� Ȯ�� �� �Է����ּ���: ");
		moneyInCounter = scan.nextInt();
		
		System.out.println("============================");
		if(lastCheckMoneyInCounter==moneyInCounter) {
			System.out.println("���� �̻�����ϴ�.");
		} else {
			System.out.println("���� �̻��ֽ��ϴ�.");
			if(moneyInCounter-lastCheckMoneyInCounter>0) {
				// ���� ī���ͱ�(������) �ݾ� > ������ Ȯ�� �ݾ�
				System.out.println((moneyInCounter-lastCheckMoneyInCounter)+"�� �ʰ��߽��ϴ�.");
			} else {
				// ���� ī���ͱ�(������) �ݾ� < ������ Ȯ�� �ݾ�
				System.out.println((lastCheckMoneyInCounter-moneyInCounter)+"�� �����߽��ϴ�");
			}
		}
		System.out.println("============================");
		
	} // end of Open
	
	public void Purchase() {
		// ����: ��ǰ��ĵ -> ���ޱ� -> �ܵ��ֱ�
		// {��ǰ��, ����, ��� ��}
		
		System.out.println("============��ǰ ����============");
		for(int i=0; i<product.length; i++)
			System.out.println((i+1)+"."+product[i][0]);
		
		System.out.print("���� ��ǰ ���� �Է�: ");
		productNum = scan.nextInt();
		System.out.println("============================");
		System.out.println(product[productNum][0]+"�� ��ĵ�մϴ�.");
		System.out.println(product[productNum][1]+"�� �Դϴ�.");
		
		System.out.print("�մԿ��Լ� ���� ��: ");
		moneyReceived = scan.nextInt();
		moneyInCounter += moneyReceived; 
				
		change = moneyReceived-Integer.parseInt(product[productNum][1]);
		System.out.println("�Ž��� ��: "+change);
		moneyReceived -= change;
		
		productCnt = Integer.parseInt(product[productNum][2]);
		System.out.println("���� ��� ��: "+(productCnt-1));
		product[productNum][2]= Integer.toString(productCnt-1);
		
	} // end of Purchase
	
	
	public void ReceiveInventory() {
		// ��� ���� �� �԰�
		// ���� ��� +10
		for(int i=0; i<product.length; i++) {
			System.out.println(product[i][0]+"�� ����� ���� +10 �Ǿ����ϴ�");
			product[i][2]+=10;
		}
		CheckProductCnt();
		
	} // end of ReceiveInventory
	
	public void CleaningTheStore() {
		// ���� û��
		System.out.println("============���� ���� û���߽��ϴ�.============");
	}
	 
	public void waiting () {
		// �մ��� ���� �ð� 
		System.out.println("============�մ� ��ٸ�����============");
	}
	
	public void TimeFlow() {
		minute+=30;
		if(minute>=60) {
			minute=0;
			hour+=1;
		}
		System.out.println("���� �ð��� "+hour+"�� "+minute+"�� �Դϴ�.");
		
		
	}// end of TimeFlow
	

	public void CheckProductCnt() {
		// ��ǰ ��� �� Ȯ��
		
		System.out.println("============��ǰ ��� �� Ȯ��============");
		for(int i=0; i<product.length; i++) 
			System.out.println((i+1)+"."+product[i][0]+"("+product[i][1]+"��)�� ��� ��: "+product[i][2]);
	
	} // end of CheckProductCnt
	
	public void CheckCurrentStatus() {
		System.out.println("============���� Ȯ��============");
		System.out.println("�湮�� ��: "+numberOfVisits); // �մ� ��
		System.out.println("������ ��(ī���ͱ� ��)"+moneyInCounter); // ������ ��(ī���� ��)
		System.out.println("���� �ð���: "+hour+"��"+"minute"+"�� �Դϴ�.");  // ���� �ð�
		CheckProductCnt(); // ��ǰ ��� �� Ȯ��
		if(door==true) 
			System.out.println("���� �����ֽ��ϴ�.");
		else
			System.out.println("���� �����ֽ��ϴ�.");
	}
	
}

public class ConvenienceStoreTest_20200226 {
	
	/*
	 * ����(6��): ������ -> ����Ȯ��(ī���ͱ� ������ Ȯ�� �ݾװ� ��)
	 * ����: ��ǰ��ĵ -> ���ޱ� -> �ܵ��ֱ�
	 * ����
	 * û��
	 * �ٹ��� ��ü(13��)
	 * */

	public static void main(String[] args) {
		
		int BehaviorNum = 0; 
		
		Scanner scan = new Scanner(System.in);
		
		ConvenienceStore store1 = new ConvenienceStore();
		System.out.println("============������ �Ƹ�����Ʈ ����============");
		
		while(store1.hour!=13) { // �ٹ��� ��ü(13��)���� �ݺ�
			if(store1.hour==6&&store1.minute==0) {
				// 6�� ���� ����
				store1.Open(); 
			} else if(store1.hour%2==0&&store1.minute==0) {
				// 6�ú��� 2�ð� ������ û�� ����
				// but 6�ÿ��� Open()�� ����, 10�ÿ��� ReceiveInventory()�� ����
				store1.CleaningTheStore();
			} else if(store1.hour==10&&store1.minute==0) {
				// 10�� ��� ���Թ� �԰�
				store1.ReceiveInventory();
			} else {
				// ����, û��, ��� ���� �̿��� �ð�����
				// �������� �ϰų� �մԸ��̸� �Ѵ�.
				
				System.out.println("���� �ѹ��� �Է����ּ���.");
				System.out.println("1. ������");
				System.out.println("2. �մ� ����");
				System.out.print("�Է�: ");
				BehaviorNum = scan.nextInt();
				if(BehaviorNum==0)
					// ������
					store1.waiting();
				else if(BehaviorNum==1) 
					// �մ� ����
					store1.Purchase();
			}
			
			// �� ������ ������ 30���� �帥��.
			store1.TimeFlow();
		}
		

	}

}
