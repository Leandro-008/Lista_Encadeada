import java.util.Random;

public class Main {
    static void mostrarPessoaEliminada(Pessoa pessoa) {
        System.out.println("A pessoa eliminada é a de número: " + pessoa.getNumero());
    }

    public static void main(String[] args) {
        int n = 20; 
        int m = 3; 

        Celula inicio = null;
        Celula atual = null;
        for (int i = 1; i <= n; i++) {
            Pessoa pessoa = new Pessoa(i); 
            Celula celula = new Celula(pessoa); 

            if (atual == null) {
                inicio = celula;
                atual = celula;
            } else {
                atual.setProxima(celula);
                atual = celula;
            }
        }

        atual.setProxima(inicio) ;

        atual = inicio; 
        Random random = new Random(); 
        while (atual.getProxima() != atual) {
            for (int i = 1; i < m; i++) {
                atual = atual.getProxima();
            }

            Celula anterior = atual;
            atual = atual.getProxima();
            anterior.setProxima(atual.getProxima()) ;

            mostrarPessoaEliminada(atual.getPessoa() );

            m = random.nextInt(19) ;

            n--;
        }

        System.out.println("A pessoa sobrevivente é a de número: " + atual.getPessoa().getNumero());
    }
}