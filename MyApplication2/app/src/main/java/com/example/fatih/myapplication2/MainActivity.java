package com.example.fatih.myapplication2;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements SwipeRefreshLayout.OnRefreshListener
{
    ArrayList<Haber> dS = new ArrayList<>();

    public static boolean enableDH = false, enableMilliyet = false,enableFutbolAjans=false,
            enableOnedio=false,enableHurriyet=false,enableHaberTurk=false,enableHaber7=false,enableHaberler=true,
            enableFoto=false,enableNtv=false,enableAmk=false,enableInternetHaber=false,enableCNN=false,
            enableMynet=false,enableShift=false,enableDijital=false,enableChip=false;

    ProgressDialog pd;
    SwipeRefreshLayout srl;
    ListView lv;
    BaseAdapter ba;
    LayoutInflater li;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        srl = (SwipeRefreshLayout) findViewById(R.id.srl);
        li = LayoutInflater.from(this);
        lv = (ListView) findViewById(R.id.lv);

        ba = new BaseAdapter() {
            @Override
            public int getCount() {
                return dS.size();
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup)
            {
                if (view == null)
                    view = li.inflate(R.layout.haber_item,null);
                Haber h = dS.get(i);
                dS.subList(0,3);
                TextView tvsaat = (TextView) view.findViewById(R.id.tvsaat);
                ImageView iv = (ImageView) view.findViewById(R.id.iv);
                TextView tv = (TextView) view.findViewById(R.id.tv);
                ImageView ivicon=(ImageView)view.findViewById(R.id.ivicon);

                tv.setText(h.baslik);
                tvsaat.setText(h.saat.substring(5,22).replace("Nov","Kasım"));
                Picasso.with(MainActivity.this)
                        .load(h.resimURL)
                        .into(iv);
                tv.setText(h.baslik);
                Picasso.with(MainActivity.this)
                        .load(h.icon)
                        .into(ivicon);
                return view;
            }
        };

        lv.setAdapter( ba );

        srl.setOnRefreshListener(this);

        getRSSData();
    }


    protected void onResume()
    {
        getRSSData();
        pd.dismiss();
        super.onResume();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add("RSS Seçimi")
                .setIcon(android.R.drawable.ic_menu_myplaces);


        menu.add("Yenile")
                .setIcon(android.R.drawable.ic_menu_rotate);


        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        String ne = ""+item.getTitle();

        if (ne.equals("RSS Seçimi"))
        {
            Intent i2 = new Intent(this, SecimActivity.class);
            startActivity(i2);
        }

        if (ne.equals("Yenile"))
        {
            getRSSData();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onRefresh()
    {
        getRSSData();
    }

    public void getRSSData()
    {
        new AsyncTask<String, String, String>()
        {
            protected void onPreExecute()
            {
                pd = new ProgressDialog(MainActivity.this);
                pd.setMessage("Lütfen Bekleyin");
                pd.show();
            }

            protected String doInBackground(String... strings)
            {
                try
                {
                    dS.clear();
                    if (enableDH)
                    {
                        Elements hl = Jsoup.connect("https://www.donanimhaber.com/rss/tum/")
                                .timeout(30000)
                                .userAgent("Mozilla")
                                .get()
                                .select("item");
                        hl.subList(3,hl.size()).clear();
                        for (Element hE : hl)
                        {
                            String baslik = hE.select("title").text();
                            String img = hE.select("enclosure").attr("url");
                            String url = hE.select("guid").text();
                            String icon = "https://upload.wikimedia.org/wikipedia/tr/9/9a/Donan%C4%B1mhaber-Logo.png";
                            String saat = hE.select("pubDate").text();
                            Haber h = new Haber(baslik,img,url,icon,saat);
                            dS.add(h);
                        }
                    }
                    if (enableMilliyet)
                    {
                        Elements hl = Jsoup.connect("http://www.milliyet.com.tr/rss/rssNew/gundemRss.xml")
                                .timeout(30000)
                                .userAgent("Mozilla")
                                .get()
                                .select("item");
                        hl.subList(3,hl.size()).clear();
                        for (Element hE : hl)
                        {
                            String baslik = hE.select("title").text();
                            String img = hE.select("ImageURL").text();
                            if(img==null)
                            {
                                img="";
                            }
                            String url = hE.select("link").text();
                            String icon="https://upload.wikimedia.org/wikipedia/tr/archive/9/90/20130126180709!Milliyet_logosu.png";
                            String saat=hE.select("pubDate").text();
                            Haber h = new Haber(baslik,img,url,icon,saat);
                            dS.add(h);
                        }
                    }
                    if (enableOnedio)
                    {
                        Elements hl = Jsoup.connect("https://onedio.com/support/rss.xml?")
                                .timeout(30000)
                                .userAgent("Mozilla")
                                .get()
                                .select("item");
                        hl.subList(3,hl.size()).clear();
                        for (Element hE : hl)
                        {
                            String baslik = hE.select("title").text();
                            String img = hE.select("description").text().substring(13,82);
                            String url = hE.select("guid").text();
                            String icon = "https://onedio.com/images/logo/onedio-new2x-new.png";
                            String saat = hE.select("pubDate").text();
                            Haber h = new Haber(baslik,img,url,icon,saat);
                            dS.add(h);
                        }
                    }
                    if (enableHurriyet)
                    {
                        Elements hl = Jsoup.connect("http://www.hurriyet.com.tr/rss/anasayfa")
                                .timeout(30000)
                                .userAgent("Mozilla")
                                .get()
                                .select("item");
                        hl.subList(3,hl.size()).clear();
                        for (Element hE : hl)
                        {
                            String baslik = hE.select("title").text();
                            String img = hE.select("enclosure").attr("url");
                            String url = hE.select("guid").text();
                            String icon = "http://fontslogo.com/wp-content/uploads/2013/03/Hurriyet-Logo-Font.jpg";
                            String saat = hE.select("pubDate").text();
                            Haber h = new Haber(baslik,img,url,icon,saat);
                            dS.add(h);
                        }
                    }
                    if (enableHaber7)
                    {
                        Elements hl = Jsoup.connect("http://sondakika.haber7.com/sondakika.rss")
                                .timeout(30000)
                                .userAgent("Mozilla")
                                .get()
                                .select("item");
                        hl.subList(3,hl.size()).clear();
                        for (Element hE : hl)
                        {
                            String baslik = hE.select("title").text();
                            String html= hE.select("description").text();
                            String url = Jsoup.parse(html).select("a").attr("href");
                            String img = Jsoup.parse(html).select("img").attr("src");
                            Log.e("resim",img);
                            Log.e("link",url);
                            String icon = "http://image.cdn.haber7.com//logo.jpg";
                            String saat = hE.select("pubDate").text();
                            Haber h = new Haber(baslik,img,url,icon,saat);
                            dS.add(h);
                        }
                    }
                } catch (Exception e) { }
                return null;
            }
            protected void onPostExecute(String s)
            {
                ba.notifyDataSetChanged();
                pd.dismiss();
            }
        }.execute();
    }
}
