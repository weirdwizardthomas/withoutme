package com.weirdwizardtom.withoutme.ui.mywishlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.weirdwizardtom.withoutme.R;
import com.weirdwizardtom.withoutme.pojo.MyWish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyWishlistFragment extends Fragment {

    private MyWishlistViewModel myWishlistViewModel;

    private WishlistItemAdapter itemAdapter;
    private RecyclerView items;
    private FloatingActionButton createWishFab;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_my_wishlist, container, false);

        myWishlistViewModel = new ViewModelProvider(this).get(MyWishlistViewModel.class);

        itemAdapter = WishlistItemAdapter.emptyInstance();

        List<MyWish> wishes = new ArrayList<>();

        wishes.add(new MyWish("a", "b", new Date()));

        itemAdapter.setData(wishes);
        items = root.findViewById(R.id.wishlist_recycler_view);
        items.setAdapter(itemAdapter);
        items.setLayoutManager(new LinearLayoutManager(getContext()));

        createWishFab = root.findViewById(R.id.wishlist_create_wish_fab);
        createWishFab.setOnClickListener(v -> Navigation.findNavController(root).navigate(R.id.mywishlist_to_createwish_action));

        return root;
    }
}