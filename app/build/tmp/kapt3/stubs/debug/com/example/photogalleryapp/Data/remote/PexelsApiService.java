package com.example.photogalleryapp.Data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/photogalleryapp/Data/remote/PexelsApiService;", "", "getCuratedPhotos", "Lretrofit2/Response;", "Lcom/example/photogalleryapp/Data/remote/PexelsResponse;", "perPage", "", "page", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface PexelsApiService {
    
    @retrofit2.http.GET(value = "curated")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCuratedPhotos(@retrofit2.http.Query(value = "per_page")
    int perPage, @retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.photogalleryapp.Data.remote.PexelsResponse>> $completion);
}