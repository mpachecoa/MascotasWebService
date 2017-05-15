package com.example.sistema.mascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sistema.mascotas.adapter.PageAdapter;
import com.example.sistema.mascotas.view.CuentaActivityView;
import com.example.sistema.mascotas.view.fragment.ListaFragmentView;
import com.example.sistema.mascotas.view.fragment.PerfilFragmentView;
import com.example.sistema.mascotas.view.FavoritoMascotasView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar miActionBar;

    ArrayList<Fragment> fragments;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miActionBar= (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setIcon(R.drawable.ic_dog_footprint_48_1);

        tabLayout   = (TabLayout) findViewById(R.id.tabLayout);
        viewPager   = (ViewPager) findViewById(R.id.viewPager);
        agregarFragment();
        setUpViewPager();

    }

    private ArrayList<Fragment> agregarFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ListaFragmentView());
        fragments.add(new PerfilFragmentView());
        return fragments;

    }

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_lista);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mFavoritos: // Favoritos
                Intent intent = new Intent(this, FavoritoMascotasView.class);
                startActivity(intent);
                break;
            case R.id.mContacto: // Contactos
                Intent iContacto = new Intent(this, ContactoActivity.class);
                startActivity(iContacto);
                break;
            case R.id.mAcercaDe: // Acerca de
                Intent iAcerdaDe = new Intent(this, BioActivity.class);
                startActivity(iAcerdaDe);
                break;
            case R.id.mCuenta: // Configurar cuenta
                Intent iCuenta = new Intent(this, CuentaActivityView.class);
                startActivity(iCuenta);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
