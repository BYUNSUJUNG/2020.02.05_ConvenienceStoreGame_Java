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
	int moneyReceived; // (�մԿ��Լ�) ���� ��
	int change; // �Ž��� ��
	
	int productNum;
	// {��ǰ��, ����, ��� ��}
	String[][] product = {{"����","1000","5"},{"����","500","5"},{"��","300","5"}}; 
	
	// �ð�
	// 6�� ����, 13�� �ٹ��� ��ü
	// 30�� �������� �ð� �帧
	int hours = 6; 
	int minutes;
	
	// ��(true: ����, false: ����)
	boolean door = false;
	
	Scanner scan = new Scanner(System.in);
	
	public void Open() {
		// ����(6��)
		// 	1. ������
		//	2. ���� Ȯ��(ī���ͱ� ������ Ȯ�� �ݾװ� ��)
		
		door = true;
		System.out.println("============================");
		System.out.println("���� �������ϴ�. ����ð�: "+hours+"�� �Դϴ�.");
		System.out.println("===========���� Ȯ��===========");
		System.out.println("������ Ȯ�� �ݾ���"+lastCheckMoneyInCounter+"�Դϴ�.");
		System.out.print("���� ī���ͱ�(������)�� �ݾ�: ");
		moneyInCounter = scan.nextInt();
		
		System.out.println("============================");
		if(lastCheckMoneyInCounter==moneyInCounter) {
			System.out.println("���� �̻�����ϴ�.");
		} else {
			System.out.println("���� �̻��ֽ��ϴ�.");
			if(moneyInCounter-lastCheckMoneyInCounter>0) {
				// ���� ī���ͱ�(������) �ݾ� > ������ Ȯ�� �ݾ�
				System.out.println("�ʰ� �Ǿ����ϴ�.");
			} else {
				// ���� ī���ͱ�(������) �ݾ� < ������ Ȯ�� �ݾ�
				System.out.println("���� �Ǿ����ϴ�");
			}
		}
		System.out.println("============================");
		
	} // end of Open()
	
	public void Purchase() {
		// ����: ��ǰ��ĵ -> ���ޱ� -> �ܵ��ֱ�
		
		productNum = (int)Math.random()*3;
		System.out.println(product[productNum][0]+"�� ��ĵ�մϴ�.");
		System.out.println(product[productNum][1]+"�� �Դϴ�.");
	}
	
	
	
	
}



public class ConvenienceStoreTest {

	public static void main(String[] args) {
		ConvenienceStore store1 = new ConvenienceStore();

	}

}
