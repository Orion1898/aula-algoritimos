function ehPrimo(n) {
  const numero = Number(n);

  if (!Number.isInteger(numero) || numero <= 1) {
    return false;
  }

  if (numero <= 3) {
    return true;
  }

  if (numero % 2 === 0) {
    return false;
  }

  for (let divisor = 3; divisor * divisor <= numero; divisor += 2) {
    if (numero % divisor === 0) {
      return false;
    }
  }

  return true;
}

function somatorio(valores) {
  if (!Array.isArray(valores)) {
    throw new TypeError('O argumento deve ser um array de números.');
  }

  return valores.reduce((total, valor) => total + Number(valor), 0);
}

function fibonacci(quantidade) {
  const n = Number(quantidade);

  if (!Number.isInteger(n) || n < 0) {
    throw new Error('A quantidade deve ser um número inteiro não negativo.');
  }

  if (n === 0) return 0;
  if (n === 1) return 1;

  let anterior = 0;
  let atual = 1;

  for (let i = 2; i <= n; i += 1) {
    const proximo = anterior + atual;
    anterior = atual;
    atual = proximo;
  }

  return atual;
}

function fibonacciSequencia(quantidade) {
  const n = Number(quantidade);

  if (!Number.isInteger(n) || n < 0) {
    throw new Error('A quantidade deve ser um número inteiro não negativo.');
  }

  const sequencia = [];

  for (let i = 0; i < n; i += 1) {
    sequencia.push(fibonacci(i));
  }

  return sequencia;
}

function mdc(a, b) {
  let primeiro = Math.abs(Number(a));
  let segundo = Math.abs(Number(b));

  while (segundo !== 0) {
    const resto = primeiro % segundo;
    primeiro = segundo;
    segundo = resto;
  }

  return primeiro;
}

function quickSort(array) {
  const copia = [...array];

  if (copia.length <= 1) {
    return copia;
  }

  const pivo = copia[copia.length - 1];
  const menores = [];
  const maiores = [];

  for (let i = 0; i < copia.length - 1; i += 1) {
    if (copia[i] < pivo) {
      menores.push(copia[i]);
    } else {
      maiores.push(copia[i]);
    }
  }

  return [...quickSort(menores), pivo, ...quickSort(maiores)];
}

function contarValoresEntrePrimeiroEValor(dados, n) {
  if (!Array.isArray(dados) || dados.length === 0) {
    return 0;
  }

  const limite = Number(n);
  const primeiro = Number(dados[0]);
  const inicio = Math.min(primeiro, limite);
  const fim = Math.max(primeiro, limite);

  return dados.filter((valor) => Number.isInteger(Number(valor)) && Number(valor) >= inicio && Number(valor) <= fim).length;
}

if (require.main === module) {
  console.log('Número primo:');
  console.log('7 ->', ehPrimo(7));
  console.log('12 ->', ehPrimo(12));

  console.log('\nSomatório:');
  console.log('somatorio([1, 2, 3, 4, 5]) ->', somatorio([1, 2, 3, 4, 5]));

  console.log('\nFibonacci:');
  console.log('fibonacci(8) ->', fibonacci(8));
  console.log('fibonacciSequencia(10) ->', fibonacciSequencia(10));

  console.log('\nMDC:');
  console.log('mdc(48, 18) ->', mdc(48, 18));

  console.log('\nQuickSort:');
  console.log('quickSort([9, 4, 7, 2, 1, 6]) ->', quickSort([9, 4, 7, 2, 1, 6]));

  console.log('\nContagem:');
  console.log('contarValoresEntrePrimeiroEValor([4, 8, 1, 7, 10], 8) ->', contarValoresEntrePrimeiroEValor([4, 8, 1, 7, 10], 8));
}

module.exports = {
  ehPrimo,
  somatorio,
  fibonacci,
  fibonacciSequencia,
  mdc,
  quickSort,
  contarValoresEntrePrimeiroEValor,
}
