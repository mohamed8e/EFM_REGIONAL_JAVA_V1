package EFM_REGIONAL_JAVA_V2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class Magasin {
    ArrayList<Article> listeArticle = new ArrayList();

    public Magasin() {
    }

    public void ajouter(Article a) throws Exception {
        if (this.listeArticle.contains(a)) {
            throw new Exception("this article already exists");
        } else {
            this.listeArticle.add(a);
        }
    }

    public int idiceDe(int code) {
        int indice = -1;

        for(int i = 0; i < this.listeArticle.size(); ++i) {
            if (((Article)this.listeArticle.get(i)).getCode() == code) {
                indice = i;
            }
        }

        return indice;
    }

    public boolean supprimer(int code) {
        boolean isSupprimer = false;
        Iterator var3 = this.listeArticle.iterator();

        while(var3.hasNext()) {
            Article i = (Article)var3.next();
            if (i.getCode() == code) {
                this.listeArticle.remove(i);
                isSupprimer = true;
                break;
            }
        }

        return isSupprimer;
    }

    public boolean supprimer(Article A) {
        if (this.listeArticle.contains(A)) {
            this.listeArticle.remove(A);
            return true;
        } else {
            return false;
        }
    }

    public int nobreArticleEnSolde() {
        int nobreArticleEnSolde = 0;
        Iterator var2 = this.listeArticle.iterator();

        while(var2.hasNext()) {
            Article i = (Article)var2.next();
            if (i.getClass() == ArticleEnSolde.class) {
                ++nobreArticleEnSolde;
            }
        }

        return nobreArticleEnSolde;
    }

    public void enregistrer(String chemin) throws IOException {
        File myfile = new File(chemin);
        FileWriter fileWriter = new FileWriter(myfile);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(this.listeArticle);
        printWriter.close();
    }

    public void supprimerFichier(String chemin) throws IOException {
        File myfile = new File(chemin);
        myfile.delete();
    }
}