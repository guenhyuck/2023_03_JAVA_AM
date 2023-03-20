class Main {
	public static void main(String[] args) {
        int n = 5; // 출력할 행 수
        for (int i = 1; i <= n; i++) { // i는 행 번호
            for (int j = 1; j <= i; j++) { // j는 열 번호
                System.out.print("*");
            }
            System.out.println();
        }
    }
}