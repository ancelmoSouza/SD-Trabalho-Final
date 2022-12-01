import qxd.ufc.com.Entitys.Livraria;
import qxd.ufc.com.Entitys.Livro;

public class Main {
    public static void main(String[] args) {
        Livraria la = new Livraria();

        Livro l = new Livro("Solo Leveling", "Iori Yagami", "12334123123");
        Livro l1 = new Livro("O Safado que Leu a Novel", "Iori Yagami", "099098122");
        Livro l2 = new Livro("Mercenary Enrollment", "Iori Yagami", "552356365312");
        la.addLivro(l);
        la.addLivro(l1);
        la.addLivro(l2);

        la.listLivros();

        la.removeLivro(l);

        la.listLivros();
    }
}