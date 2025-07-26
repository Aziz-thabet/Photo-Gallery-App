package com.example.photogalleryapp.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0096@\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/photogalleryapp/data/repository/PhotoRepository;", "Lcom/example/photogalleryapp/domain/repository/PhotoRepository;", "dao", "Lcom/example/photogalleryapp/Data/local/PhotoDao;", "pexelsApiService", "Lcom/example/photogalleryapp/Data/remote/PexelsApiService;", "(Lcom/example/photogalleryapp/Data/local/PhotoDao;Lcom/example/photogalleryapp/Data/remote/PexelsApiService;)V", "getPhotos", "", "Lcom/example/photogalleryapp/domain/models/PhotoModel;", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePhoto", "", "photo", "(Lcom/example/photogalleryapp/domain/models/PhotoModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class PhotoRepository implements com.example.photogalleryapp.domain.repository.PhotoRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.photogalleryapp.Data.local.PhotoDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.photogalleryapp.Data.remote.PexelsApiService pexelsApiService = null;
    
    public PhotoRepository(@org.jetbrains.annotations.NotNull()
    com.example.photogalleryapp.Data.local.PhotoDao dao, @org.jetbrains.annotations.NotNull()
    com.example.photogalleryapp.Data.remote.PexelsApiService pexelsApiService) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getPhotos(boolean forceRefresh, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.photogalleryapp.domain.models.PhotoModel>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object savePhoto(@org.jetbrains.annotations.NotNull()
    com.example.photogalleryapp.domain.models.PhotoModel photo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}