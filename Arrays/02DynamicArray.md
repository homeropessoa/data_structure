Eu tive uma duvida sobre logica que foi a seguinte ao estudar DynamicArray.

No método pushback da classe DynamicArray, por que o elemento é inserido em arr[length] e não em arr[length-1]? 
E, ao fazer resize quando length == capacity, não deveria causar outro resize após inserir o elemento e aumentar length?

Ao que eu percebi meu engano. Segue a explicacao:

# 1. Sobre o índice arr[length] = n;
No método pushback, o objetivo é inserir o novo elemento na próxima posição disponível do array. Para isso, usamos o índice length, que representa quantos elementos já foram inseridos.

Quando o array está vazio `(length = 0)`, o primeiro elemento será inserido em `arr[0]`.
Quando há 1 elemento `(length = 1)`, o próximo será inserido em `arr[1]`.
E assim por diante.
Ou seja, a próxima posição livre do array é sempre o índice length, porque os índices válidos preenchidos vão de 0 até length-1.

## Exemplo: Suponha que o array tem capacidade 4 e length = 2.
Elementos ocupam `arr[0]` e `arr[1]`.
O próximo será inserido em `arr[2]`, por isso usamos `arr[length]`.

# 2. Sobre o resize()
O resize() só é chamado quando `length == capacity`.
Isso significa que todas as posições do array estão ocupadas e, portanto, não há espaço para um novo elemento.

O array é expandido (duplicando a capacidade).
Os elementos antigos são copiados para o novo array maior.
Agora há espaço para inserir o novo elemento em `arr[length]`.

## Detalhe importante:
O método resize() acontece antes de inserir o novo elemento.
Depois do resize, o array tem espaço suficiente, então o elemento é inserido normalmente.

# 3. Sobre o incremento do length++
Após inserir o elemento, você faz `length++`.
Isso não causa um novo resize imediatamente, porque agora `length < capacity` (já que o array foi expandido, se necessário).

O resize só ocorre quando você tentar inserir um novo elemento e `length == capacity` novamente.

# 4. Por que não usar arr[length-1]?
Se você usasse `arr[length-1]`, estaria sobrescrevendo o último elemento já inserido.
O correto é inserir na primeira posição livre, que é `arr[length]`.

# 5. Fluxo do método pushback
Checa se precisa expandir o array `(length == capacity)`. Se sim, faz o resize.
Insere o elemento na próxima posição livre `(arr[length] = n)`.
Atualiza o length para refletir o novo tamanho.

# Resumindo
length = número de elementos inseridos.
Próxima posição livre: `arr[length]`.
Depois do resize: sempre tem espaço para inserir.
`length++` apenas atualiza a contagem, não causa resize imediato.