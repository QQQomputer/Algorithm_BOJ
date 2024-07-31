package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//성훈이 코드
//84ms
public class Q14719_빗물_ver성훈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[w];
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxHeight = 0;
        int standardIdx = 0;
        for (int i = 0; i < w; i++) {
            if (maxHeight < arr[i]) {
                maxHeight = arr[i];
                standardIdx = i;
            }
        }

        int area = maxHeight;
        int leftMax = 0;
        int rightMax = 0;

        // 기준 인덱스 왼쪽 영역
        for (int i = 0; i < standardIdx; i++) {
            leftMax = Math.max(leftMax, arr[i]);
            area += leftMax;
        }
        // 기준 인덱스 오른쪽 영역(꼭 거꾸로 순회해야 함!)
        for (int i = w - 1; i > standardIdx; i--) {
            rightMax = Math.max(rightMax, arr[i]);
            area += rightMax;
        }
        for (int i = 0; i < w; i++) {
            area -= arr[i];
        }
        System.out.println(area);
    }

}