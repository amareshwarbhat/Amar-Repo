package app.widas.com.widas.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import app.widas.com.widas.R;

public class TabFragment extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLaout;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_tab, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);

        viewPager = (ViewPager) getActivity().findViewById(R.id.viewpager);
        setUpViewPager(viewPager);

        tabLaout = (TabLayout) getActivity().findViewById(R.id.tabs);
        tabLaout.setupWithViewPager(viewPager);
    }


    private void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdaptor adaptor = new ViewPagerAdaptor(getActivity().getSupportFragmentManager());
        adaptor.addFragment(new FreeConsultationFragment(), "FreeConsultation");
        adaptor.addFragment(new EventsFragment(), "Events");
        adaptor.addFragment(new NewsLetterFragment(), "NewsLetter");
        viewPager.setAdapter(adaptor);
    }

    public class ViewPagerAdaptor extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdaptor(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment freeConsultationFragment, String title) {

            mFragmentList.add(freeConsultationFragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
