package EFM_REGIONAL_JAVA_V2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArticleEnSolde extends Article {
    int remise;

    ArticleEnSolde(int code, double prix, int remise) {
        super(code, prix);
        this.remise = remise;
    }

    public int getRemise() {
        return this.remise;
    }

    public void setRemise(int remise) throws Exception {
        Pattern pa = Pattern.compile("[0-9]", 16);
        Matcher ma = pa.matcher(String.valueOf(remise));
        if (!ma.find()) {
            throw new Exception("la remise est invalide");
        } else {
            this.remise = remise;
        }
    }

    public double prixArticle() {
        return this.getPrix() * (double)this.remise / 100.0;
    }

    public String toString() {
        String var10000 = super.toString();
        return var10000 + "; remise = " + this.remise;
    }
}
