package br.edu.infnet.ATInterface;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_drawer_layout);

        Toolbar toolbar = findViewById(R.id.minha_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setSubtitle("Infnet");

        drawer = findViewById(R.id.drawer_layout);
        //Hamburguer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer, toolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        //sincronizar estado com o navigation drawer
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        // Configurar a activity como "quem responde quando um item é selecionado"
        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public void onBackPressed() {
        //Se o navigation drawer estiver aberto, fechamos ele
        if (drawer.isDrawerOpen(Gravity.START)){
            drawer.closeDrawer(Gravity.START);
        }
        else{ //caso contrário, faça o que já era feito antes
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_search){
            Toast.makeText(this, "Selecionou PESQUISAR",
                            Toast.LENGTH_SHORT).show();
        }
        else if (itemId == R.id.action_settings){
            Toast.makeText(this, "Selecionou CONFIG",
                           Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId){
            case R.id.first_item:
                //codigo aqui
                Intent intent = new Intent(this, InformacoesPessoais.class);
                startActivity(intent);
                break;
            case R.id.second_item:
                intent = new Intent(this, Formacao.class);
                startActivity(intent);
                break;
            case R.id.third_item:
                intent = new Intent(this, ExpPro.class);
                startActivity(intent);
                break;
            case R.id.fourth_item:
                intent = new Intent(this, Cursos.class);
                startActivity(intent);
                break;
            case R.id.fifth_item:
                intent = new Intent(this, Publicacoes.class);
                startActivity(intent);
                break;
        }
        return false;
    }
}
