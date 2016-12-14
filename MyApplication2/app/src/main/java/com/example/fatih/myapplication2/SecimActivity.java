package com.example.fatih.myapplication2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class SecimActivity extends AppCompatActivity
{

    CheckBox cbDH, cbMilliyet,cbHaberTurk,cbHaber7,cbInternetHaber,cbCnn,
            cbMynet,cbHaberler,cbHurriyet,cbOnedio,cbShift,cbDijital,cbChip,
            cbFutbolAjans,cbFotoMac,cbNtv,cbAmk,cbAnadolu,cbdogan ;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secim);

        cbDH = (CheckBox) findViewById(R.id.cbDH);
        cbMilliyet = (CheckBox) findViewById(R.id.cbMilliyet);
        cbAmk = (CheckBox) findViewById(R.id.cbAmk);
        cbChip = (CheckBox) findViewById(R.id.cbChip);
        cbCnn = (CheckBox) findViewById(R.id.cbCnn);
        cbDijital = (CheckBox) findViewById(R.id.cbDijital);
        cbFotoMac = (CheckBox) findViewById(R.id.cbFotoMac);
        cbFutbolAjans = (CheckBox) findViewById(R.id.cbFutbolAjans);
        cbHaber7 = (CheckBox) findViewById(R.id.cbHaber7);
        cbHaberler = (CheckBox) findViewById(R.id.cbHaberler);
        cbHurriyet = (CheckBox) findViewById(R.id.cbHurriyet);
        cbHaberTurk = (CheckBox) findViewById(R.id.cbHaberTurk);
        cbShift = (CheckBox) findViewById(R.id.cbShift);
        cbOnedio = (CheckBox) findViewById(R.id.cbOnedio);
        cbNtv = (CheckBox) findViewById(R.id.cbNtv);
        cbMynet = (CheckBox) findViewById(R.id.cbMynet);
        cbInternetHaber = (CheckBox) findViewById(R.id.cbInternetHaber);

        cbDH.setChecked(MainActivity.enableDH);
        cbMilliyet.setChecked(MainActivity.enableMilliyet);
        cbFutbolAjans.setChecked(MainActivity.enableFutbolAjans);
        cbOnedio.setChecked(MainActivity.enableOnedio);
        cbInternetHaber.setChecked(MainActivity.enableInternetHaber);
        cbMynet.setChecked(MainActivity.enableMynet);
        cbNtv.setChecked(MainActivity.enableNtv);
        cbAmk.setChecked(MainActivity.enableAmk);
        cbChip.setChecked(MainActivity.enableChip);
        cbCnn.setChecked(MainActivity.enableCNN);
        cbDijital.setChecked(MainActivity.enableDijital);
        cbShift.setChecked(MainActivity.enableShift);
        cbHurriyet.setChecked(MainActivity.enableHurriyet);
        cbHaber7.setChecked(MainActivity.enableHaber7);
        cbHaberler.setChecked(MainActivity.enableHaberler);
        cbHaberTurk.setChecked(MainActivity.enableHaberTurk);
        cbFotoMac.setChecked(MainActivity.enableFoto);

        cbDH.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableDH = b;
            }
        });
        cbInternetHaber.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableInternetHaber = b;
            }
        });
        cbMynet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableMynet = b;

            }
        });
        cbNtv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableNtv = b;
            }
        });
        cbAmk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableAmk = b;
            }
        });
        cbChip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableChip = b;
            }
        });
        cbCnn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableCNN = b;
            }
        });
        cbDijital.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableDijital = b;
            }
        });
        cbShift.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableShift = b;
            }
        });
        cbHurriyet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableHurriyet = b;
            }
        });
        cbHaber7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableHaber7 = b;
            }
        });
        cbHaberler.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableHaberler = b;
            }
        });
        cbHaberTurk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableHaberTurk = b;
            }
        });

        cbFotoMac.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableFoto = b;
            }
        });
        cbOnedio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableOnedio = b;
            }
        });

        cbFutbolAjans.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableFutbolAjans = b;
            }
        });

        cbMilliyet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                MainActivity.enableMilliyet = b;
            }
        });
    }
}
