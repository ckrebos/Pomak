package seminarski.hci.pomak.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import seminarski.hci.pomak.R;
import seminarski.hci.pomak.fragments.AboutUsFragment;
import seminarski.hci.pomak.fragments.ContactFragment;
import seminarski.hci.pomak.fragments.HomeFragment;
import seminarski.hci.pomak.fragments.ProductsFragment;
import seminarski.hci.pomak.fragments.ServiceFragment;
import seminarski.hci.pomak.tabs.SlidingTabLayout;

public class  MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private SlidingTabLayout slidingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        viewPager=(ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        slidingTabLayout=(SlidingTabLayout)findViewById(R.id.tabs);
        slidingTabLayout.setViewPager(viewPager);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_scan) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class MyPagerAdapter extends FragmentPagerAdapter{
        String[] tabNames;
        ArrayList<Fragment> fragments=new ArrayList<>();


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            tabNames=getResources().getStringArray(R.array.tabs);
        }

        @Override
        public Fragment getItem(int position) {
            HomeFragment homeFragment=HomeFragment.getInstance(position);
            AboutUsFragment aboutUsFragment =AboutUsFragment.newInstance(position);
            ProductsFragment productsFragment=ProductsFragment.newInstance(position);
            ServiceFragment serviceFragment=ServiceFragment.getInstance(position);
            ContactFragment contactFragment= ContactFragment.getInstance(position);
            fragments.add(homeFragment);
            fragments.add(aboutUsFragment);
            fragments.add(productsFragment);
            fragments.add(serviceFragment);
            fragments.add(contactFragment);
            return fragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabNames[position];
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

}
