package id.co.sigma.android.mylayoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imgFavourite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Room Detail");
        getSupportActionBar().setSubtitle("Sunset Hotel");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imgFavourite=(ImageView)findViewById(R.id.img_favourite);
        imgFavourite.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch ( item.getItemId()){
            case R.id.action_share :
                //todo add action share
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/html");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "This is the text shared.");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT,"Test Intent Sharing");
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                //Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private boolean isFavourited;

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.img_favourite){
            if( isFavourited){
                imgFavourite.setColorFilter(ContextCompat.getColor(this,android.R.color.white));
                isFavourited= false;
            }else {
                imgFavourite.setColorFilter(ContextCompat.getColor(this,R.color.colorAccent));
                isFavourited= true;
            }
        }
    }
}
