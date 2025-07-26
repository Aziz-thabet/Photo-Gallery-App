package com.example.photogalleryapp.Activites;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u001eH\u0014J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006&"}, d2 = {"Lcom/example/photogalleryapp/Activites/HomeScreen;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/photogalleryapp/databinding/ActivityHomeScreenBinding;", "connectivityManager", "Landroid/net/ConnectivityManager;", "editor", "Landroid/content/SharedPreferences$Editor;", "networkCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "networkStatusImageView", "Landroid/widget/ImageView;", "photoAdapter", "Lcom/example/photogalleryapp/Activites/PhotoAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sharedPreferences", "Landroid/content/SharedPreferences;", "themeSwitch", "Lcom/google/android/material/switchmaterial/SwitchMaterial;", "viewModel", "Lcom/example/photogalleryapp/ViewModel/PhotoViewModel;", "getViewModel", "()Lcom/example/photogalleryapp/ViewModel/PhotoViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isNetworkAvailable", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setupNetworkStatusMonitor", "setupThemeSwitch", "updateNetworkStatusIcon", "isConnected", "app_debug"})
public final class HomeScreen extends androidx.appcompat.app.AppCompatActivity {
    private com.google.android.material.switchmaterial.SwitchMaterial themeSwitch;
    private android.content.SharedPreferences sharedPreferences;
    private android.content.SharedPreferences.Editor editor;
    private com.example.photogalleryapp.databinding.ActivityHomeScreenBinding binding;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private com.example.photogalleryapp.Activites.PhotoAdapter photoAdapter;
    private android.widget.ImageView networkStatusImageView;
    private android.net.ConnectivityManager connectivityManager;
    private android.net.ConnectivityManager.NetworkCallback networkCallback;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public HomeScreen() {
        super();
    }
    
    private final com.example.photogalleryapp.ViewModel.PhotoViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupThemeSwitch() {
    }
    
    private final void setupNetworkStatusMonitor() {
    }
    
    private final void updateNetworkStatusIcon(boolean isConnected) {
    }
    
    private final boolean isNetworkAvailable() {
        return false;
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
}