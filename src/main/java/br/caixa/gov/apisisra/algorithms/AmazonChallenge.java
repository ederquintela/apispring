package br.caixa.gov.apisisra.algorithms;

public class AmazonChallenge {

    public static int maxValidStack(int[] weights) {
        int n = weights.length;
        int[] dp = new int[n];
        int len = 0;

        for (int w : weights) {
            int i = binarySearch(dp, 0, len, w);
            dp[i] = w;
            if (i == len) len++;
        }

        return len;
    }

    // Busca binária para encontrar a posição correta
    private static int binarySearch(int[] dp, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (dp[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    // Teste simples
    public static void main(String[] args) {
        int[] weights = {4, 5, 2, 2, 3, 6};
        System.out.println("Maior pilha possível: " + maxValidStack(weights));
    }
}
