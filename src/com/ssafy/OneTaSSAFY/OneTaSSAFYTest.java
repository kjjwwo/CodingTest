package com.ssafy.OneTaSSAFY;

public class OneTaSSAFYTest {
	public static void main(String[] args) {
		
		// 두 점의 좌표
		int[] start = {1,1};
		int[] end = {2,2};
		
		int a = Math.abs(end[0] - start[0]); // x 좌표의 차이
		int b = Math.abs(end[1] - start[1]); // y 좌표의 차이
		
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		
		// 아크탄젠트는 Math.atan() 메소드를 이용하면 계산할 수 있음
		// Math.atan()의 결과는 radian으로 나옴 (degree가 아님)
		double radian = Math.atan(b/a);
		
		// radian을 degree로 변경을 해야 실제 각도를 얻을 수 있음
		System.out.printf("%f, %f", c, Math.toDegrees(radian));
		
		
		double x1 = 1.0, y1 = 2.0; // my ball 초기 위치
		double x2 = 5.0, y2 = 1.0; // 목표 위치
		
		// theta (세타) 계산
		double alpha = calculateTheta(x1, y1, x2, y2);
		
		// 출력 (라디안 및 도 단위 변환)
		System.out.println("my ball의 출발 각도 theta (라디안): " + alpha);
		System.out.println("my ball의 출발 각도 theta (도): " + (alpha * (180.0 / PI)) + "도");
		
	}
	
	static final double PI = 3.141592;
	
	public static double calculateTheta(double x1, double y1, double x2, double y2) {
		// 1) my ball(내 공)과 정사영까지의 x거리 a
		double a = x2 - x1;
		// 2) my ball(내 공)과 정사영까지의 y거리 b
		double b = y2 + y1;
		// 3) my ball(내 공)이 법선과 벽의 교차점으로 이동하기 위한 방향 Theta
		double tanTheta = a/b;
		double theta = Math.atan(tanTheta);
		return theta;
	}
	
}
