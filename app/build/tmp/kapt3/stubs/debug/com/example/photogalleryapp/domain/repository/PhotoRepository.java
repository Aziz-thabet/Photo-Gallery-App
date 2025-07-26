package com.example.photogalleryapp.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/example/photogalleryapp/domain/repository/PhotoRepository;", "", "getPhotos", "", "Lcom/example/photogalleryapp/domain/models/PhotoModel;", "forceRefresh", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePhoto", "", "photo", "(Lcom/example/photogalleryapp/domain/models/PhotoModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface PhotoRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPhotos(boolean forceRefresh, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.photogalleryapp.domain.models.PhotoModel>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object savePhoto(@org.jetbrains.annotations.NotNull()
    com.example.photogalleryapp.domain.models.PhotoModel photo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}