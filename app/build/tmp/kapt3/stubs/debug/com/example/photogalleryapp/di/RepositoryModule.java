package com.example.photogalleryapp.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/example/photogalleryapp/di/RepositoryModule;", "", "()V", "providePhotoRepository", "Lcom/example/photogalleryapp/domain/repository/PhotoRepository;", "photoDao", "Lcom/example/photogalleryapp/Data/local/PhotoDao;", "pexelsApiService", "Lcom/example/photogalleryapp/Data/remote/PexelsApiService;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class RepositoryModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.photogalleryapp.di.RepositoryModule INSTANCE = null;
    
    private RepositoryModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.example.photogalleryapp.domain.repository.PhotoRepository providePhotoRepository(@org.jetbrains.annotations.NotNull()
    com.example.photogalleryapp.Data.local.PhotoDao photoDao, @org.jetbrains.annotations.NotNull()
    com.example.photogalleryapp.Data.remote.PexelsApiService pexelsApiService) {
        return null;
    }
}