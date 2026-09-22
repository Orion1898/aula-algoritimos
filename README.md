# Verificador de Número Primo (numeroprimo.java)

Descrição
- Programa em Java que verifica se um número inteiro positivo é primo.

Arquivo principal
- [numeroprimo.java](numeroprimo.java)

Como compilar
```
javac numeroprimo.java
```

Como executar
- Passando números como argumentos:
```
java numeroprimo 2 3 4 17 18 19
```
- Modo interativo (digite números e pressione Enter):
```
java numeroprimo
```

Saída esperada (exemplo):
```
2 -> primo
3 -> primo
4 -> não primo
17 -> primo
```

Detalhes da implementação
- Método público: `ehPrimo(long n)`
- Regras principais:
  - n <= 1 -> não primo
  - n <= 3 -> primo
  - pares (>2) -> não primo
  - testa divisores ímpares até `i <= n / i` (equivalente a `i*i <= n`) para evitar overflow
- Complexidade: O(sqrt(n)) no pior caso

Observações
- Garanta que `javac`/`java` estejam no `PATH` do sistema. No Windows instale o JDK e adicione `C:\Program Files\Java\jdk<versão>\bin` ao 
