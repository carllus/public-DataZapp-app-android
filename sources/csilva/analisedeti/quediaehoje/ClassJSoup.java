package csilva.analisedeti.quediaehoje;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ClassJSoup {
    /* access modifiers changed from: package-private */
    public List<ObjectItens> depois_amanha() {
        List<ObjectItens> retorno = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("http://www.oieduca.com.br/biblioteca/que-dia-e-hoje/?dia=" + dia_d_amanha() + "&mes=" + mes_d_amanha()).timeout(99999).get();
            doc.html(doc.html().replace("div id=", "div class="));
            Iterator<Element> it = doc.getElementsByClass("quadro").iterator();
            while (it.hasNext()) {
                Element itens = it.next();
                itens.html(itens.html().replace("div class=", "div id=").replace("<img src=\"", "<div id='imagem'>").replace(".jpg\">", ".jpg</div>").replace(".JPG\">", ".JPG</div>").replace(".gif\">", ".gif</div>").replace(".GIF\">", ".gif</div>").replace(".png\">", ".png</div>").replace(".PNG\">", ".png</div>").replace(".jpeg\">", ".jpeg</div>").replace(".JPEG\">", ".jpeg</div>").replace("//", "/").replace("http:/", "http://").replace("<p>", "<div id='descricao'>").replace("</p>", "</div>").replace("<div style=\"float:right;width:630px;padding-top:10px;line-height:30px;\">", "<div id='text-titulo'>").replace("<a href=\"/", "<div id='url'>http://www.oieduca.com.br/").replace("\">Saiba mais</a>", "</div>"));
                Element titulo = itens.getElementById("text-titulo");
                Element data = itens.getElementById("data_titulo");
                Element descricao = itens.getElementById("descricao");
                Element imagem = itens.getElementById("imagem");
                Element url = itens.getElementById("url");
                ObjectItens item = new ObjectItens();
                item.setNome(titulo.text());
                item.setData("[Depois] Em " + dia_d_amanha() + "/" + mes_d_amanha() + "/" + data.text());
                item.setDescricao(descricao.text());
                item.setImagem(imagem.text());
                item.setUrl(url.text());
                retorno.add(item);
            }
        } catch (Exception e) {
        }
        return retorno;
    }

    /* access modifiers changed from: package-private */
    public List<ObjectItens> amanha() {
        List<ObjectItens> retorno = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("http://www.oieduca.com.br/biblioteca/que-dia-e-hoje/?dia=" + dia_amanha() + "&mes=" + mes_amanha()).timeout(99999).get();
            doc.html(doc.html().replace("div id=", "div class="));
            Iterator<Element> it = doc.getElementsByClass("quadro").iterator();
            while (it.hasNext()) {
                Element itens = it.next();
                itens.html(itens.html().replace("div class=", "div id=").replace("<img src=\"", "<div id='imagem'>").replace(".jpg\">", ".jpg</div>").replace(".JPG\">", ".JPG</div>").replace(".gif\">", ".gif</div>").replace(".GIF\">", ".gif</div>").replace(".png\">", ".png</div>").replace(".PNG\">", ".png</div>").replace(".jpeg\">", ".jpeg</div>").replace(".JPEG\">", ".jpeg</div>").replace("//", "/").replace("http:/", "http://").replace("<p>", "<div id='descricao'>").replace("</p>", "</div>").replace("<div style=\"float:right;width:630px;padding-top:10px;line-height:30px;\">", "<div id='text-titulo'>").replace("<a href=\"/", "<div id='url'>http://www.oieduca.com.br/").replace("\">Saiba mais</a>", "</div>"));
                Element titulo = itens.getElementById("text-titulo");
                Element data = itens.getElementById("data_titulo");
                Element descricao = itens.getElementById("descricao");
                Element imagem = itens.getElementById("imagem");
                Element url = itens.getElementById("url");
                ObjectItens item = new ObjectItens();
                item.setNome(titulo.text());
                item.setData("[Amanhã] Em " + dia_amanha() + "/" + mes_amanha() + "/" + data.text());
                item.setDescricao(descricao.text());
                item.setImagem(imagem.text());
                item.setUrl(url.text());
                retorno.add(item);
            }
        } catch (Exception e) {
        }
        return retorno;
    }

    /* access modifiers changed from: package-private */
    public List<ObjectItens> hoje() {
        List<ObjectItens> retorno = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("http://www.oieduca.com.br/biblioteca/que-dia-e-hoje/?dia=" + dia() + "&mes=" + mes()).timeout(99999).get();
            doc.html(doc.html().replace("div id=", "div class="));
            Iterator<Element> it = doc.getElementsByClass("quadro").iterator();
            while (it.hasNext()) {
                Element itens = it.next();
                itens.html(itens.html().replace("div class=", "div id=").replace("<img src=\"", "<div id='imagem'>").replace(".jpg\">", ".jpg</div>").replace(".JPG\">", ".JPG</div>").replace(".gif\">", ".gif</div>").replace(".GIF\">", ".gif</div>").replace(".png\">", ".png</div>").replace(".PNG\">", ".png</div>").replace(".jpeg\">", ".jpeg</div>").replace(".JPEG\">", ".jpeg</div>").replace("//", "/").replace("http:/", "http://").replace("<p>", "<div id='descricao'>").replace("</p>", "</div>").replace("<div style=\"float:right;width:630px;padding-top:10px;line-height:30px;\">", "<div id='text-titulo'>").replace("<a href=\"/", "<div id='url'>http://www.oieduca.com.br/").replace("\">Saiba mais</a>", "</div>"));
                Element titulo = itens.getElementById("text-titulo");
                Element data = itens.getElementById("data_titulo");
                Element descricao = itens.getElementById("descricao");
                Element imagem = itens.getElementById("imagem");
                Element url = itens.getElementById("url");
                ObjectItens item = new ObjectItens();
                item.setNome(titulo.text());
                item.setData("[hoje] Em " + dia_mes() + "/" + data.text());
                item.setDescricao(descricao.text());
                item.setImagem(imagem.text());
                item.setUrl(url.text());
                retorno.add(item);
            }
        } catch (Exception e) {
        }
        return retorno;
    }

    public String dia() {
        return new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
    }

    public String dia_amanha() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        c.add(6, 1);
        return sdf.format(c.getTime());
    }

    public String dia_d_amanha() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        c.add(6, 2);
        return sdf.format(c.getTime());
    }

    public String mes() {
        return new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
    }

    public String mes_amanha() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        c.add(6, 1);
        return sdf.format(c.getTime());
    }

    public String mes_d_amanha() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        c.add(6, 2);
        return sdf.format(c.getTime());
    }

    public String ano() {
        return new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
    }

    public String dia_mes() {
        return new SimpleDateFormat("dd/MM").format(Calendar.getInstance().getTime());
    }
}
