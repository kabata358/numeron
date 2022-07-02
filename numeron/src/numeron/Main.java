package numeron;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 3つの数字をランダムに生成
		Random rnd = new Random();
		int answer[] = new int[3];
		
		for (int i = 0; i < 3; i++){
			// 数字をランダムに生成
			answer[i] = rnd.nextInt(10);
			for (int j = 0; j < i; j++) {
				// 生成した数字が重複した場合
				if (answer[i] == answer[j]){
					i--;
					break;
				}
			}
		}
		
		System.out.println(Arrays.toString(answer));
		
		
		// 入力
		Scanner scanner = new Scanner(System.in);
		int inputNum;
		int num[] = new int[3];
		
		while (true) {
			System.out.print("3桁の数字を入力してください。　-> ");
			inputNum = scanner.nextInt();
			
			// 入力した数字の桁数を確認
			if (String.valueOf(inputNum).length() != 3) {
				System.out.println("数字は3桁で入力してください。");
				continue;
			}
			
			// 入力した数字を配列に格納
			for (int i = 2; i >= 0; i--) {
				num[i] = inputNum % 10;
				inputNum /= 10;
			}
			
			// 入力した数字が重複していないか確認
			boolean flag = true;
			for (int i = 0; i < 3; i++){
				for (int j = 0; j < i; j++) {
					// 入力した数字が重複している場合
					if (num[i] == num[j]){
						flag = false;
					}
				}
			}
			if (flag == false) {
				System.out.println("同じ数字は入力しないでください。");
				continue;
			}
			
			// 判定
			int eat = 0;
			
			for (int i = 0; i < 3; i++) {
				if (num[i] == answer[i]) {
					eat++;
				}
			}
			
			System.out.println(eat + "EAT ");
			
			if (eat == 3) {
				break;
			}
		}
		
		System.out.println("ゲーム終了");
		
	}

}
