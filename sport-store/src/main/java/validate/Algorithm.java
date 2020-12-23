package validate;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {
	private double[] Time ;
	private int[] Value;
	private double [][]A;
	public Algorithm(int []qty,int []value) {
		Time=new double[qty.length];
		Value=new int[qty.length];
		for(int  i=1;i<qty.length;i++) {
			Time[i]=qty[i]*0.25;
			Value[i]=value[i];
		}
		A=new double[qty.length][33];
	}
	public static void main(String[] args) {
		int []qty= {0,6,8,10,14,16};
		int []Value= {0,100,120,150,170,200};
		Algorithm al=new Algorithm(qty, Value);
		List<Integer>list=al.cal();
		for(Integer data :list) {
			System.out.println(qty[data]+" "+Value[data]);
		}
	}
	public List<Integer> cal(){
		for(int i = 0 ; i <Time.length ; i++) {
			for(int j = 0 ; j < 33 ; j++) {
				if(i==0||j==0) {
					A[i][j] = 0;
				}
			}
		}
		int a;
		for(int i = 1 ; i < Time.length ; i++) {
			for(double time = 0.25 ; time <= 8.0 ; time += 0.25 ) {
				if(time < Time[i]) {
					a = (int) (time/0.25);
					A[i][a] = A[i-1][a];
				}
				else {
					a = (int) (time/0.25);
					A[i][a] = (A[i-1][a] > Value[i]+A[i-1][(int) ( (time - Time[i])/0.25)])?A[i-1][a]:Value[i]+A[i-1][(int) ((time - Time[i])/0.25)];
				}
					
			}
		}
		double res = A[Time.length-1][32];
		double time = 8;
		List<Integer>result=new ArrayList<Integer>();
		for(int i = Time.length-1; i > 0 && res > 0 ; i-- ) {
			if(res != A[i-1][(int)(time/0.25)]) {
				result.add(i);
				res -= Value[i];
				time -= Time[i];
			}
		}
		return result;
	}
	}


