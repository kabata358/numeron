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
			// 生成した数字の重複確認
			for (int j = 0; j < i; j++) {
				if (answer[i] == answer[j]){
					i--;
					break;
				}
			}
		}
		
		/* 答えを表示する
		System.out.println(Arrays.toString(answer) + System.getProperty("line.separator"));
		*/
		
		System.out.println("+------------------+");
		System.out.println("|     ゲーム開始     |");
		System.out.println("+------------------+" + System.getProperty("line.separator"));
		
		// 入力回数をカウントする
		int count = 0;
		
		// 3つの数字を入力する
		String inputNum;
		int num[] = new int[3];
		Scanner scanner = new Scanner(System.in);
		
		// 3つの数字の入力と判定処理
		while (true) {
			System.out.print("3桁の数字を入力してください。　-> ");
			inputNum = scanner.next();
			
			//★★★入力されたのが数字かの判定が必要
			
			
			// 入力した文字列の桁数を確認
			if (inputNum.length() != 3) {
				System.out.println("数字は3桁で入力してください。" + System.getProperty("line.separator"));
				continue;
			}
			
			// 入力した文字列を数字として配列に格納
			for (int i = 2; i >= 0; i--) {
				num[i] = Integer.parseInt(inputNum) % 10;
				inputNum = String.valueOf(Integer.parseInt(inputNum) / 10);
			}
			
			// 入力した3つの数字の重複確認
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
				System.out.println("同じ数字は入力しないでください。" + System.getProperty("line.separator"));
				continue;
			}
			
			// EAT, BITE 判定
			int eat = 0;
			int bite = 0;
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					// 入力した数字が答えと一致している場合
					if (num[i] == answer[j]) {
						if (i == j) {	// 入力した数字の桁が一致している場合
							eat++;
						} else {		// 入力した数字の桁が一致していない場合
							bite++;
						}
					}
				}
			}
			
			System.out.println("  【 " + eat + " EAT  /  " + bite + " BITE" + " 】" + System.getProperty("line.separator"));
			count++;
			
			// 3EAT でゲーム終了
			if (eat == 3) {
				break;
			}
		}
		
		System.out.println("+------------------+");
		System.out.println("|     ゲーム終了     |");
		System.out.println("+------------------+");
		System.out.println(count + "回目で正解しました。");
	}

}
