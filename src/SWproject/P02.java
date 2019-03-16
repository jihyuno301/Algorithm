package SWproject;
/*
 * Title : 알파벳 정렬
 * 문자열을 입력받아서 알파벳순으로 정렬되게 하라
 * 예시 : computer(cemoprtu) 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P02 {
	
	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] arr = br.readLine().toLowerCase().toCharArray();
		for(int i=0; i<arr.length-1; i++) {
			
			for(int j=i+1; j<arr.length; j++) {
				if(arr[j]<arr[i]) swap(arr,i,j);
			}
		}
		
		for(int i=0; i<arr.length; i++) sb.append(arr[i]+"");
		System.out.println(sb.toString());
		
		
	}
}
