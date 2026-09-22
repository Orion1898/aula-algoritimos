import java.util.Arrays;

public class Main {
    public static boolean ehPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }

        for (int divisor = 3; divisor * divisor <= n; divisor += 2) {
            if (n % divisor == 0) {
                return false;
            }
        }

        return true;
    }

    public static int somatorio(int[] valores) {
        int total = 0;
        for (int valor : valores) {
            total += valor;
        }
        return total;
    }

    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N deve ser maior ou igual a zero.");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int anterior = 0;
        int atual = 1;

        for (int i = 2; i <= n; i++) {
            int proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }

        return atual;
    }

    public static int[] fibonacciSequencia(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N deve ser maior ou igual a zero.");
        }

        int[] sequencia = new int[n];
        for (int i = 0; i < n; i++) {
            sequencia[i] = fibonacci(i);
        }

        return sequencia;
    }

    public static int mdc(int a, int b) {
        int primeiro = Math.abs(a);
        int segundo = Math.abs(b);

        while (segundo != 0) {
            int resto = primeiro % segundo;
            primeiro = segundo;
            segundo = resto;
        }

        return primeiro;
    }

    public static void quickSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int inicio, int fim) {
        if (inicio >= fim) {
            return;
        }

        int pivo = array[fim];
        int indice = inicio;

        for (int j = inicio; j < fim; j++) {
            if (array[j] <= pivo) {
                trocar(array, indice, j);
                indice++;
            }
        }

        trocar(array, indice, fim);
        quickSort(array, inicio, indice - 1);
        quickSort(array, indice + 1, fim);
    }

    private static void trocar(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int contarValoresEntrePrimeiroEValor(int[] dados, int n) {
        if (dados == null || dados.length == 0) {
            return 0;
        }

        int primeiro = dados[0];
        int inicio = Math.min(primeiro, n);
        int fim = Math.max(primeiro, n);
        int contador = 0;

        for (int valor : dados) {
            if (valor >= inicio && valor <= fim) {
                contador++;
            }
        }

        return contador;
    }

    public static void main(String[] args) {
        System.out.println("=== Número primo ===");
        System.out.println("7 -> " + ehPrimo(7));
        System.out.println("12 -> " + ehPrimo(12));

        System.out.println("\n=== Somatório ===");
        int[] valores = {1, 2, 3, 4, 5};
        System.out.println("Soma = " + somatorio(valores));

        System.out.println("\n=== Fibonacci ===");
        System.out.println("Fibonacci(8) = " + fibonacci(8));
        System.out.println("Sequência até 10 = " + Arrays.toString(fibonacciSequencia(10)));

        System.out.println("\n=== MDC ===");
        System.out.println("MDC(48, 18) = " + mdc(48, 18));

        System.out.println("\n=== Quicksort ===");
        int[] paraOrdenar = {9, 4, 7, 2, 1, 6};
        quickSort(paraOrdenar);
        System.out.println("Ordenado = " + Arrays.toString(paraOrdenar));

        System.out.println("\n=== Contagem ===");
        int[] dados = {4, 8, 1, 7, 10};
        System.out.println("Contagem entre primeiro e N = " + contarValoresEntrePrimeiroEValor(dados, 8));
    }
}
